/*
Feu un programa que actuï de manera diferent segons si existeix o no una carpeta 
anomenada “Temp” a la seva carpeta de treball. Si no existeix, l’ha d’intentar 
crear. Si existeix, l’ha de crear. Cada cop que es realitza una acció, cal dir 
si s’ha pogut dur a terme i la ruta absoluta de la carpeta processada. Per 
exemple, els missatges següents s’anirien alternant per diferents execucions:
 */
package U6_GestioDeFitxers;

import java.io.File;

public class Commutador {

    public static void main(String[] args) {
        Commutador programa = new Commutador();
        programa.inici();
    }

    public void inici() {

        // Cremoas la intaci f con sl contructor de archivos indicado la ruta relativa al espacio de trabajo
        File f = new File("Temp");
        // Si conprueba que exita el directorio f
        if (f.isDirectory()) {

            boolean ok = f.delete();
            if (ok) {
                //devulve la ruta absoluta del fichero f
                System.out.println("S'ha esborrat la carpeta " + f.getAbsolutePath());
            } else {
                System.out.println("Error esborrant la carpeta " + f.getAbsolutePath());
            }
            // SI no existe el directorio f
        } else {
            // si se crea el directorio f, ok es verdadero
            boolean ok = f.mkdir();
            if (ok) {
                System.out.println("S'ha creat la carpeta " + f.getAbsolutePath());
            } else {
                System.out.println("Error creant la carpeta " + f.getAbsolutePath());
            }
        }

    }
}
