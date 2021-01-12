/*
Feu un programa anomenat CopiarFitxerBinari que realitzi una còpia d’un fitxer 
orientat a byte. El programa primer ha de demanar a l’usuari que introdueixi pel 
teclat els noms dels fitxers origen i destinació. Un cop fet, ha d’assegurar-se 
que l’origen existeix i que el destí no (no es vol sobreescriure’l). Finalment, 
ha de crear un fitxer amb el nom de la destinació que contingui exactament les 
mateixes dades que el fitxer origen, siguin quines siguin aquestes dades o el 
seu tipus.
 */
package U6_TractamentBàsicDeDades;

import java.util.Scanner;
import java.io.File;
import java.io.RandomAccessFile;

//Proveu-lo sobre un fitxer orientat a caràcter...
public class CopiarFitxerBinari {

    public static void main(String[] args) {
        CopiarFitxerBinari programa = new CopiarFitxerBinari();
        programa.inici();
    }

    public void inici() {
        //Es llegeix de teclat rutes origen i destinació
        Scanner teclat = new Scanner(System.in);
        System.out.print("Escriu el nom del fitxer origen: ");
        String origen = teclat.nextLine();
        File rutaOrigen = new File(origen);

        //si existe el fichero origen
        if (rutaOrigen.isFile()) {

            System.out.print("Escriu el nom del fitxer destinació: ");
            String desti = teclat.nextLine();
            File rutaDesti = new File(desti);
            
            //si existe el fichero destino
            if (rutaDesti.isFile()) {
                System.out.println("El fitxer destinació ja existeix.");
            } else {
                ferCopia(rutaOrigen, rutaDesti);
            }
        } else {
            System.out.println("El fitxer origen no existeix.");
        }
    }

    /**
     * Copia un fitxer orientat a byte, a partir d'una ruta origen, a una de
     * destinació.
     *
     * @param rutaOrigen Ruta del fitxer origen
     * @param rutaDesti Ruta del fitxer destinació
     */
    public void ferCopia(File rutaOrigen, File rutaDesti) {
        try {
            //RandomAccessFile: Clase que permite accesos de lectura y escritura a un fichero con acceso aleatorio.
            RandomAccessFile rafOrigen = new RandomAccessFile(rutaOrigen, "r");
            RandomAccessFile rafDesti = new RandomAccessFile(rutaDesti, "rw");

            long numBytes = rutaOrigen.length();
            for (int i = 0; i < numBytes; i++) {
                byte dada = rafOrigen.readByte();
                rafDesti.writeByte(dada);
            }
            rafDesti.setLength(numBytes);

            rafOrigen.close();
            rafDesti.close();
            System.out.println("Copia finalitzada correctament.");
        } catch (Exception e) {
            System.out.println("Error fent la còpia: " + e);
        }
    }

}
