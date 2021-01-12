/*
Genereu un programa que, a partir d’una frase, la desi en un fitxer orientat a 
byte. Ara bé, si us fixeu en els continguts de la unitat, veureu que entre la 
llista de mètodes bàsics per escriure tipus de dades a un fitxer d’aquestes 
característiques no hi ha cap mètode que escrigui cadenes de text directament. 
Per tant, el que es farà és emmagatzemar cada paraula individualment com si fos 
una seqüència de bytes. Per cada paraula, cal escriure primer la seva mida en 
bytes, i llavors immediatament els bytes de què es composa. Per transformar una 
cadena de text a un array de bytes podeu usar el mètode getBytes() de la classe 
String.
 */

package U6_TractamentBàsicDeDades;

import java.io.RandomAccessFile;
import java.io.File;

public class TractarCadenesBinari {

    public static void main(String[] args) {
        TractarCadenesBinari programa = new TractarCadenesBinari();
        programa.inici();
    }

    public void inici() {
        File fitxer = new File("CadenesText.bin");

        String text = "Hi havia una vegada una cadena de text";
        String[] paraules = text.split(" ");

        generarFitxer(fitxer, paraules);
        tractarFitxer(fitxer);
    }

    /**
     * Genera un fitxer orientat a byte d'acord al format especificat. Si el
     * fitxer ja existia, se sobreescriu totalment.
     *
     * @param f Ruta del fitxer a generar
     * @param paraules Paraules que cal escriure
     */
    public void generarFitxer(File f, String[] paraules) {
        try {
            if (f.isFile()) {
                f.delete();
            }
            RandomAccessFile raf = new RandomAccessFile(f, "rw");

            for (int i = 0; i < paraules.length; i++) {
                byte[] bytes = paraules[i].getBytes();
                raf.writeInt(bytes.length);
                raf.writeBytes(paraules[i]);
            }

            raf.close();
        } catch (Exception e) {
            System.out.println("Error generant fitxer: " + e);
        }
    }

    /**
     * Tracta el fitxer, de manera que es mostren per pantalla només les
     * paraules que ocupen més de tres bytes.
     *
     * @param f Ruta al fitxer que cal tractar
     */
    public void tractarFitxer(File f) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "r");

            while (raf.getFilePointer() < raf.length()) {
                int numBytes = raf.readInt();
                if (numBytes > 3) {
                    //Si ocupa més de tres bytes, es llegeix i es mostra
                    byte[] bytes = new byte[numBytes];
                    for (int i = 0; i < numBytes; i++) {
                        bytes[i] = raf.readByte();
                    }
                    String paraula = new String(bytes);
                    System.out.println(paraula);
                } else {
                    //Si n'ocupa menys, se salta
                    raf.skipBytes(numBytes);
                }
            }

            raf.close();
        } catch (Exception e) {
            System.out.println("Error tractant fitxer: " + e);
        }
    }

}
