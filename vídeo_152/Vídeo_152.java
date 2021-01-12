package vídeo_152;

// Curso Java. Streams I. Accediendo a ficheros. Lectura. Vídeo 152
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Vídeo_152 {

    public static void main(String[] args) {

        Leer_Fichero accediendo = new Leer_Fichero();
        accediendo.leer();

    }

}

class Leer_Fichero {

    static final String DIRECTORIO = "datos/ejemplo.txt";
    int c = 0;

    public void leer() {

        FileReader Fichero;
        try {
            Fichero = new FileReader(DIRECTORIO);
            while (c != -1) {

                c = Fichero.read();
                char letra = (char) c;
                System.out.print(letra);

            }

            Fichero.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No s'ha pogut trobar el fitxer de dades d'alumnes");
        } catch (IOException ex) {
            System.out.println("Hi ha hagut un error de lectura en el fitxer de dades d'alumnes");
        }

    }

}
