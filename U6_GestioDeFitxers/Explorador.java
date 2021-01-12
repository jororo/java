/*
Es vol crear un explorador del sistema de fitxers en mode text, controlat des 
del teclat. Aquest programa mostra una línia de comandes on veure’s representada 
la carpeta actual en què es troba l’usuari. A l’inici, estarà a la carpeta de 
treball del programa. Llavors, mitjançant les comandes següents es pot explorar 
el sistema de fitxers:

* cd .., l’usuari es desplaça a la carpeta pare de l’actual.
* cd nomCarpeta, l’usuari entra a la carpeta amb el nom “nomCarpeta”, que ha d’estar dins de la carpeta actual.
* dir, es mostren totes les carpetes i fitxers continguts dins de la carpeta actual.
* fi, finalitza l’execució del programa.
 */
package U6_GestioDeFitxers;

import java.io.File;
import java.util.Scanner;

public class Explorador {

    public static void main(String[] args) {
        Explorador programa = new Explorador();
        programa.inici();
    }

    public void inici() {
        boolean executar = true;
        Scanner lector = new Scanner(System.in);

        //Obtenir carpeta de treball per saber carpeta "actual"
        String dirTreball = System.getProperty("user.dir");
        File rutaActual = new File(dirTreball);

        while (executar) {

            System.out.print(rutaActual.getAbsolutePath() + "> ");
            String ordre = lector.nextLine();

            // String.split() Divide una cadena cada vez que encuentra un 
            // delimitador que coincida con la expresión regular pasada como parámetro.
            String[] comandes = ordre.split(" ", 2);
            if (comandes.length == 1) {

                //Pot ser un "dir" o "fi"
                if ("dir".equals(comandes[0])) {
                    //dir
                    mostraFitxers(rutaActual);
                } else if ("fi".equals(comandes[0])) {
                    //fi
                    System.out.println("Fi del programa!");
                    executar = false;
                } else {
                    System.out.println("Comanda incorrecta!");
                }
            } else if (comandes.length > 1) {
                //Pot ser un "cd"
                if ("cd".equals(comandes[0])) {
                    rutaActual = novaCarpeta(rutaActual, comandes[1]);
                } else {
                    System.out.println("Comanda incorrecta!");
                }
            }
        }
    }

    /**
     * A partir de la carpeta actual i la comanda de l'usuari, es diu quina és
     * la nova carpeta.
     *
     * @param actual carpeta actual
     * @param ordre text escrit per l'usuari
     * @return nova carpeta actual
     */
    public File novaCarpeta(File actual, String ordre) {
        if ("..".equals(ordre)) {
            //S'ha escrit "..", cal pujar al pare
            String pare = actual.getParent();
            if (pare != null) {
                File novaRuta = new File(pare);
                return novaRuta;
            }
        } else {
            //S'ha escrit un nom, cal veure si està bé
            String novaCarpeta = actual.getAbsolutePath() + File.separator + ordre;
            File novaRuta = new File(novaCarpeta);
            if (novaRuta.exists()) {
                return novaRuta;
            } else {
                System.out.println("Aquesta carpeta no existeix!");
            }
        }
        return actual;
    }

    /**
     * A partir d'una ruta, mostra per pantalla el seu contingut.
     *
     * @param ruta ruta de la carpeta a mostrar
     */
    public void mostraFitxers(File ruta) {
        // lista los archivos de la ruta espcificada
        File[] elements = ruta.listFiles();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].isFile()) {
                //si es un archivo ruta en i y devulve el nombre del mismo 
                System.out.println("[FILE] " + elements[i].getName());
            } else {
                //si es un directorio en i y devulve el nombre del mismo
                System.out.println("[DIR] " + elements[i].getName());
            }
        }
    }

}
