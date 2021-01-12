/*
Genereu un programa que, en iniciar-se, pregunti el nom d’un fitxer a l’usuari. 
El programa ha de comprovar que existeix. Aquest fitxer ha de contenir una 
seqüència de valors reals, entre 0 i 10, que representen un seguit de notes 
d’estudiants d’una aula. Per indicar el final de la seqüència, s’usa el valor -1 
com a marca de fi. Podeu generar-lo prèviament vosaltres mateixos amb un editor 
de text.

El programa ha de llegir el contingut del fitxer i generar-ne un de nou anomenat 
“Histograma-nom del fitxer llegit”. Per exemple, si el fitxer amb les notes es 
diu, “NotesReals.txt”, el fitxer resultat s’anomenarà “Histograma-NotesReals.txt”. 
El contingut d’aquest fitxer ha de ser un histograma de les notes, comptant que:

Excel·lent = nota entre 10 i 9
Notable = nota entre 9 i 6.5
Aprovat = nota entre 6.5 i 5
Suspès = nota inferior a 5
 */
package U6_TractamentBàsicDeDades;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class Histogrames {

    private static final String[] textHistograma
            = {"Suspès ", "Aprovat ", "Notable ", "Excel·lent"};

    public static void main(String[] args) {
        Histogrames programa = new Histogrames();
        programa.inici();
    }

    public void inici() {
        //para intaciar el objeto fichero llamamos la funcion preguntarFitxer para el contructor
        File fitxerEntrada = preguntarFitxer();
        //
        int[] histograma = crearHistograma(fitxerEntrada);

        String nomSortida = "Histograma-" + fitxerEntrada.getName();
        File fitxerSortida = new File(nomSortida);
        String titol = "Histograma del fitxer " + fitxerEntrada.getName();
        escriureHistograma(titol, histograma, fitxerSortida);

        System.out.println("Histograma escrit al fitxer " + fitxerSortida);
    }

    /**
     * Pregunta a l'usuari el nom del fitxer.
     *
     * @return Ruta al fitxer a escriure
     */
    public File preguntarFitxer() {
        Scanner lector = new Scanner(System.in);
        boolean preguntar = true;
        File f = null;
        while (preguntar) {
            System.out.print("Escriu el nom del fitxer amb les dades: ");
            String nomFitxer = lector.nextLine();
            f = new File(nomFitxer);
            if (f.isFile()) {
                preguntar = false;
            } else {
                System.out.println("Aquest fitxer no existeix.");
            }
        }
        return f;
    }

    /**
     * A partir d'un fitxer orientat a caràcter que conté reals, genera
     * l'histograma. El valor -1 indica el final de les dades.
     *
     * @param f Fitxer d'on llegir les dades
     * @return L'array de l'histograma.
     */
    public int[] crearHistograma(File f) {
        try {
            Scanner lector = new Scanner(f);
            int[] histograma = new int[4];
            boolean llegir = true;

            while (llegir) {
                double valor = lector.nextDouble();
                if (valor == -1) {
                    llegir = false;
                } else {
                    int index = indexHistograma(valor);
                    if (index != -1) {
                        histograma[index]++;
                    }
                }
            }

            lector.close();
            return histograma;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Escriu un array que representa un histograma a un fitxer.
     *
     * @param titol Títol a la primera línia de l'histograma.
     * @param histograma array amb l'histograma (4 posicions)
     * @param f Fitxer destinació
     */
    public void escriureHistograma(String titol, int[] histograma, File f) {
        try {
            PrintStream escriptor = new PrintStream(f);
            escriptor.println(titol);
            escriptor.println("------------");
            for (int i = 0; i < histograma.length; i++) {
                escriptor.print(textHistograma[i] + ":");
                for (int j = 0; j < histograma[i]; j++) {
                    escriptor.print("*");
                }
                escriptor.println();
            }

            escriptor.close();
        } catch (Exception e) {
            System.out.println("Error escrivint resultat: " + f);
        }
    }

    /**
     * A partir del valor d'una nota, diu a quin índex de l'histograma
     * correspon.
     *
     * @param valor Valor de nota a comprovar.
     * @return Índex de l'histograma (0-3), o -1 si el valor no està entre 0 i
     * 10.
     */
    public int indexHistograma(double valor) {
        if ((valor >= 9) && (valor <= 10)) {
            return 3;
        } else if ((valor >= 6.5) && (valor < 9)) {
            return 2;
        } else if ((valor >= 5) && (valor < 6.5)) {
            return 1;
        } else if ((valor >= 0) && (valor < 5)) {
            return 0;
        }
        return -1;
    }
}