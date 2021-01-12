/*
Feu un programa que funcioni com una màquina d’escriure. En iniciar la seva 
execució, ha de preguntar a l’usuari que escrigui, usant el teclat el nom d’un 
fitxer. Si aquest fitxer ja existeix, s’ha de demanar que posi un altre nom. 
Un cop s’ha escrit un nom correcte, el programa ha d’anar llegint tot el text 
que escrigui l’usuari i, cada cop que acaba d’introduir una línia, en prémer la 
tecla de retorn, desar-lo al fitxer. El programa acaba quan l’usuari escriu una 
línia de text en la qual només hi ha un punt (”.”). Aquest punt no s’escriu dins 
el fitxer resultant.
 */
package U6_TractamentBàsicDeDades;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MaquinaEscriure {

    public static void main(String[] args) {
        MaquinaEscriure programa = new MaquinaEscriure();
        programa.inici();
    }

    public void inici() {
        try {
            //para intaciar el objeto fichero llamamos la funcion preguntarFitxer para el contructor
            File fitxerSortida = preguntarFitxer();
            PrintStream escriptor = new PrintStream(fitxerSortida);
            Scanner lector = new Scanner(System.in);
            boolean llegir = true;
            while (llegir) {
                String text = lector.nextLine();
                //si la linea introducida es igual a "." se detiene
                if (".".equals(text)) {
                    llegir = false;
                } else {
                    //usamos la funcion println para escribir en el archivo una linea mas salto de linea
                    escriptor.println(text);
                }
            }

            escriptor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error escrivint fitxer: " + e);
        }
    }

    /**
     * Pregunta a l'usuari el nom del fitxer.
     *
     * @return Ruta al fitxer a escriure
     */
    public File preguntarFitxer() {
        //no spide qeu le demos un nombre al fichero lo pasa retornado f que es 
        //la parte del contructor con el parametro del nombre
        Scanner lector = new Scanner(System.in);
        boolean preguntar = true;
        File f = null;
        while (preguntar) {
            System.out.print("Escriu el nom del fitxer on escriure: ");
            String nomFitxer = lector.nextLine();
            String rutaFicher = "Doc/" + nomFitxer;
            f = new File(rutaFicher);
            if (f.exists()) {
                System.out.println("El fitxer ja existeix.");
            } else {
                preguntar = false;
            }
        }
        return f;
    }
}
