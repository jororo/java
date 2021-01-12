package U6_GestioDeFitxers;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class renombradoFichero {

    public static void main(String[] args) {
        
        //instanciaremos el objeto File
        File f1 = new File("fichero1.txt");
        File f2 = new File("fichero2.txt");
        try {
            // A partir del objeto File creamos el fichero físicamente
            if (f1.createNewFile()) {
                System.out.println("El fichero se ha creado correctamente");
            } else {
                System.out.println("No ha podido ser creado el fichero");
            }
            // A partir del objeto File creamos el fichero físicamente
            if (f2.createNewFile()) {
                System.out.println("El fichero se ha creado correctamente");
            } else {
                System.out.println("No ha podido ser creado el fichero");
            }
        } catch (IOException ex) {
            Logger.getLogger(renombradoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean correcto = f1.renameTo(f2);
        System.out.println("La ruta absoluta del fichero es " + f1.getAbsolutePath());
        System.out.println("La ruta absoluta del fichero es " + f2.getAbsolutePath());
        if (correcto) {
            System.out.println("El renombrado ha sido correcto");
        } else {
            System.out.println("El renombrado no se ha podido realizar");
        }
    }
}
