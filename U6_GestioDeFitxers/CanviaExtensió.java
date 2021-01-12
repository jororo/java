/*
Genereu un programa que pregunti a l’usuari dues cadenes de text de tres lletres, 
de manera que les pugui escriure pel teclat en una mateixa línia. El programa ha 
de cercar tots els fitxers en el seu directori de treball que tinguin com 
extensió la primera cadena de text i canviar-la a la segona. Per exemple, si 
l’usuari escriu “txt jpg”, tots els fitxers amb extensió ”.txt” han de passar a 
tenir l’extensió ”.jpg”.
 */
package U6_GestioDeFitxers;

import java.io.File;
import java.util.Scanner;

public class CanviaExtensió {

    public static void main(String[] args) {
        CanviaExtensió programa = new CanviaExtensió();
        programa.inici();
    }

    public void inici() {
        System.out.print("Escriu l'extensió origen i destí: ");
        Scanner lector = new Scanner(System.in);
        String origen = lector.next();
        String desti = lector.next();

        // da a dirTreball el directoriode trabajo del programa java
        String dirTreball = System.getProperty("user.dir");
        // intaciamos el objeto file "rutaTreball" en el directorio de trabajo
        File rutaTreball = new File(dirTreball);
        // .listFiles() Retorna una lista de rutas de los ficheros y directorios que tenga un objeto File
        File[] elements = rutaTreball.listFiles();

        for (int i = 0; i < elements.length; i++) {
            //si exite un fichero 
            if (elements[i].isFile()) {
                canviaExtensio(elements[i], origen, desti);
            }
        }
    }

    /**
     * A partir d'una ruta d'un fitxer, mira si té una extensió donada, i si és
     * així, la canvia per una altra.
     *
     * @param ruta Ruta del fitxer a comprovar
     * @param or Ruta origen que cal comprovar
     * @param des Ruta destinació que cal assignar
     */
    public void canviaExtensio(File ruta, String or, String des) {
        //Método que devuelve el nombre del fichero o directorio instanciado 
        // mediante la clase File. Solo devuelve la parte final del path.
        String nom = ruta.getName();
        // damos a punt el valor de la última posición donde se ecuntra un punto
        int punt = nom.lastIndexOf(".");
        // si punt es mayor o igual a 0
        if (punt >= 0) {

            String extOrigen = nom.substring(punt + 1, nom.length());
            if (extOrigen.equals(or)) {
                // da a nouNom el valor de la subcadena de nom entra el caracter 0 y el punto
                String nouNom = nom.substring(0, punt + 1) + des;
                nouNom = ruta.getParent() + File.separator + nouNom;
                // instacaimos el objeto nuevo con el nombre nuevo
                File novaRuta = new File(nouNom);
                ruta.renameTo(novaRuta);
            }
        }
    }

}
