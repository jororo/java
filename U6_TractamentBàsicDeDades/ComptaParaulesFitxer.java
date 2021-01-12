/*
Feu un programa anomenat ComptaParaulesFitxer que llegeixi un fitxer orientat a 
caràcter on hi ha tot de frases escrites en línies diferents. Per indicar el 
final del fitxer, hi ha una frase o només posa “fi”. Aquest programa ha de 
mostrar per pantalla el nombre de paraules que té cada frase, sense comptar la 
de “fi”. Les contraccions (l’, d’, etc.) compten com a part de la paraula 
associada.
 */
package U6_TractamentBàsicDeDades;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ComptaParaulesFitxer {

    public static void main(String[] args) {
        ComptaParaulesFitxer programa = new ComptaParaulesFitxer();
        programa.inici();
    }

    public void inici() {
        try {
            //Creamos una instacai de la case file 
            File f = new File("Doc/Document.txt");
            //pasamos la intacai anteriro como parametro al escaner
            Scanner lector = new Scanner(f);
            boolean llegir = true;
            int numLinia = 1;
            //mientras dea verdadero
            while (llegir) {
                String text = lector.nextLine();
                if ("fi".equals(text)) {
                    llegir = false;
                } else {
                    //Es pot usar "split" per comptar les paraules separadas por espacios y crear una array paraules
                    String[] paraules = text.split(" ");
                    //damos a numPar el valor total de fials de la array paraules
                    int numPar = paraules.length;
                    System.out.println("La línia " + numLinia + " té " + numPar + " paraules.");
                    numLinia++;
                }
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error llegint fitxer: " + e);
        }

    }
}
