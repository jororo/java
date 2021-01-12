package vídeo_154;

// Curso Java. Streams III. Usando buffers. Vídeo 154
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Vídeo_154 {

    public static void main(String[] args) {

        Leer_Fichero accediendo = new Leer_Fichero();
        accediendo.leer();

    }

}

class Leer_Fichero {

    static final String DIRECTORIO = "datos/ejemplo.txt";

    public void leer() {

        FileReader Fichero;
        String linea = "";
        try {

            Fichero = new FileReader(DIRECTORIO);

            BufferedReader buffer_Lectura = new BufferedReader(Fichero);

            while (linea != null) {

                linea = buffer_Lectura.readLine();

                if (linea != null) {
                    System.out.println(linea);
                }

            }

            Fichero.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No s'ha pogut trobar el fitxer de dades d'alumnes");
        } catch (IOException ex) {
            System.out.println("Hi ha hagut un error de lectura en el fitxer de dades d'alumnes");
        }

    }

}
