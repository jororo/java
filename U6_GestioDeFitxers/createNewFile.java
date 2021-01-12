package U6_GestioDeFitxers;

/*
Método que crea un fichero vacío. Siempre y cuando el fichero no exista. 
Si el fichero es creado satisfactoriamente devuelve true, 
en caso de que el fichero exista devuelve false.
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class createNewFile {

    public static void main(String[] args) {

        File fichero = new File("c:\\temp\\miFichero.txt");

        try {
            // A partir del objeto File creamos el fichero físicamente
            if (fichero.createNewFile()) {
                System.out.println("El fichero se ha creado correctamente");
            } else {
                System.out.println("No ha podido ser creado el fichero");
            }
        } catch (IOException ex) {
            Logger.getLogger(createNewFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
