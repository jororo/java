package vídeo_153;

// Curso Java. Streams I. Accediendo a ficheros. Lectura. Vídeo 152
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Vídeo_153 {

    public static void main(String[] args) {

        Escribiendo_Fichero accediendo = new Escribiendo_Fichero();
        accediendo.escribir();

    }

}

class Escribiendo_Fichero {

    static final String DIRECTORIO = "datos/ejemplo_2.txt";

    void escribir() {

        String frase = "Prueba de escritura\n";
        FileWriter Escritura;

        try {

            Escritura = new FileWriter(DIRECTORIO, true);
            for (int i = 0; i < frase.length(); i++) {
                Escritura.write(frase.charAt(i));
                System.out.print(frase.charAt(i));
            }

            Escritura.close();

        } catch (FileNotFoundException ex) {
            System.out.println("No s'ha pogut trobar el fitxer de dades d'alumnes");
        } catch (IOException ex) {
            System.out.println("Hi ha hagut un error de lectura en el fitxer de dades d'alumnes");
        }

    }

}
