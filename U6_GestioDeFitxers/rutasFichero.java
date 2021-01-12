package U6_GestioDeFitxers;

import java.io.File;

public class rutasFichero {

    public static void main(String[] args) {

        File fichero = new File("test.txt");
        File fichero_2 = new File(fichero.getAbsolutePath());
        System.out.println("La ruta absoluta del fichero es " + fichero.getAbsolutePath());
        System.out.println("El directorio padre del fichero es " + fichero.getParent());
        System.out.println("El directorio padre del fichero_2 es " + fichero_2.getParent());
    }
}
