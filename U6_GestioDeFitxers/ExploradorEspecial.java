/*
L’objectiu d’aquesta activitat és ampliar un programa existent que gestiona 
fitxers, de manera que s’hi integrin noves funcionalitats.

Modifiqueu el programa de l’explorador de carpetes de manera que incorpori les 
comandes següents:

* del nomFitxer, esborra el fitxer de la carpeta actual anomenat “nomFitxer”.
* prop nomFitxer, mostra les propietats d’un fitxer: la seva mida i la seva 
darrera data de modificació.

 */
package U6_GestioDeFitxers;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class ExploradorEspecial {

    public static void main(String[] args) {
        ExploradorEspecial programa = new ExploradorEspecial();
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
                //Pot ser un "cd" o "del" o "rename"
                if ("cd".equals(comandes[0])) {
                    rutaActual = novaCarpeta(rutaActual, comandes[1]);
                } else if ("del".equals(comandes[0])) {
                    esborraFitxer(rutaActual, comandes[1]);
                } else if ("prop".equals(comandes[0])) {
                    mostraPropietats(rutaActual, comandes[1]);
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
     * @param carpeta nom de la nova carpeta on moure's
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
        File[] elements = ruta.listFiles();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].isFile()) {
                System.out.println("[FILE] " + elements[i].getName());
            } else {
                System.out.println("[DIR] " + elements[i].getName());
            }
        }
    }

    /**
     * A partir de la carpeta actual i el nom d'un fitxer, l'esborra.
     *
     * @param actual carpeta actual
     * @param fitxer nom del fitxer a esborrar
     */
    public void esborraFitxer(File actual, String fitxer) {
        String nom = actual.getAbsolutePath() + File.separator + fitxer;
        File rutaFitxer = new File(nom);
        if (rutaFitxer.isFile()) {
            rutaFitxer.delete();
            System.out.println("S'ha esborrat el fitxer.");
        } else {
            System.out.println("No existeix aquest fitxer!");
        }
    }

    /**
     * A partir de la carpeta actual i el nom d'un fitxer, mostra les
     * propietats.
     *
     * @param actual carpeta actual
     * @param fitxer nom del fitxer a esborrar
     */
    public void mostraPropietats(File actual, String fitxer) {
        String nom = actual.getAbsolutePath() + File.separator + fitxer;
        File rutaFitxer = new File(nom);
        if (rutaFitxer.isFile()) {
            System.out.println("----------");
            System.out.println("Mida: " + rutaFitxer.length());
            long mod = rutaFitxer.lastModified();
            Date data = new Date(mod);
            System.out.println("Modificació: " + data);
            System.out.println("----------");
        } else {
            System.out.println("No existeix aquest fitxer!");
        }
    }

}
