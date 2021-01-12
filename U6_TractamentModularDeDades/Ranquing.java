/*
Modifiqueu la classe Ranquing, amb la qual heu treballat als continguts d’aquest 
apartat, de manera que ara, en lloc de treballar amb un fitxer orientat a 
caràcter, ho faci amb un orientat a byte. Les dades que ha de contenir són les 
mateixes (una llista amb conjunts de tres inicials i la puntuació associada). 
En aquest cas, però, no hi ha puntuacions per defecte a l’inici del joc. Primer 
de tot no hi ha fitxer, i el llistat va incorporant les puntuacions de 
successives partides a poc a poc, amb un màxim sempre de 10 alhora. Després de 
la primera partida hi haurà 1 puntuació, després de la segona 2, etc. Això vol 
dir que les 10 primeres puntuacions al llarg de la vida del joc sempre 
s’inclouran al fitxer.
 */
package U6_TractamentModularDeDades;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ranquing {

//Es declara el fitxer de puntuacions com una constant
    public static final File RANQUING = new File("Ranquing");

    /**
     * A partir d'una puntuació, estableix la seva posició al fitxer
     *
     * @param punts Punts que cal comprovar
     * @return posició per la puntuació. -1 Si error.
     */
    public int cercarRanquing(int punts) {
        try {
            //Fitxer no existeix (primera partida)
            if (RANQUING.isFile() == false) {
                return 0;
            }
            RandomAccessFile raf = new RandomAccessFile(RANQUING, "r");
            //Cada posició ocupa 10 bytes (3 chars = 2 bytes) + (1 int = 4 bytes)
            long numPosicions = RANQUING.length() / 10;
            int pos = 0;
            while (pos < numPosicions) {
                //Saltar inicials i llegim punts
                raf.skipBytes(6);
                int rankPunts = raf.readInt();
                if (punts > rankPunts) {
                    //S'ha trobat la posició
                    break;
                }
                pos++;
            }
            //S'arriba aquí si s'ha arribat al final del fitxer
            raf.close();
            return pos;
        } catch (IOException e) {
            return -1;
        }
    }

    /**
     * Insereix una puntuació al rànquing
     *
     * @param inicials Inicials del jugador
     * @param punts Puntuació assolida
     * @param pos Posició dins el rànquing, o -1 si hi ha error
     * @return 0 si tot correcte, -1 Si error.
     */
    public int entrarPuntuacio(String inicials, int punts, int pos) {
        try {
            //Són realment inicials?
            if (inicials.length() != 3) {
                return -1;
            }
            RandomAccessFile raf = new RandomAccessFile(RANQUING, "rw");
            //Cada posició ocupa 10 bytes (3 chars = 2 bytes) + (1 int = 4 bytes)
            long numPosicions = RANQUING.length() / 10;
            if (pos < numPosicions) {
                //Cal desplaçar rànquings
                for (long i = numPosicions; i > pos; i--) {
                    long offset = (i - 1) * 10;
                    raf.seek(offset);
                    //Es llegeixen tres inicials
                    String inis = "" + raf.readChar();
                    inis = inis + raf.readChar();
                    inis = inis + raf.readChar();
                    //Es llegeixen els punts
                    int pun = raf.readInt();

                    //S'escriuen al bloc següent
                    raf.writeChars(inis);
                    raf.writeInt(pun);
                }
            }
            //Escriure puntuació
            long offset = pos * 10;
            raf.seek(offset);
            raf.writeChars(inicials);
            raf.writeInt(punts);
            raf.close();
            return 0;
        } catch (IOException e) {
            return -1;
        }
    }

    /**
     * Llegeix les puntuacions i les formata com una cadena de text
     *
     * @return Cadena de text resultant. null si hi ha error
     */
    public String llegirRanquing() {
        try {
            String txtRanquing = "Rànquing de puntuacions\n----------------------\n";
            RandomAccessFile raf = new RandomAccessFile(RANQUING, "r");
            long numPosicions = RANQUING.length() / 10;
            for (int i = 0; i < numPosicions; i++) {
                txtRanquing = txtRanquing + raf.readChar();
                txtRanquing = txtRanquing + raf.readChar();
                txtRanquing = txtRanquing + raf.readChar();
                txtRanquing = txtRanquing + "\t" + raf.readInt() + "\n";
            }
            raf.close();
            return txtRanquing;
        } catch (IOException e) {
            return null;
        }

    }

}
