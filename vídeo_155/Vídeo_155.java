package vídeo_155;
// Curso Java Streams IV. Leyendo archivos. Streams Byte I. Vídeo 155

import java.io.*;

public class Vídeo_155 {

    static final String DIRECTORIO = "datos/ejemplo.txt";

    public static void main(String[] args) {

        try {

            boolean final_ar = false;
            FileInputStream archivo_Lectura = new FileInputStream(DIRECTORIO);

            while (!final_ar) {

                int byte_entrada = archivo_Lectura.read();
                if (byte_entrada == -1) {
                    final_ar = true;
                }
                char leer = (char) byte_entrada;
                System.out.print(leer);
            }
            archivo_Lectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha pogut trobar el fitxer de dades d'alumnes");
        } catch (IOException e) {
            System.out.println("Hi ha hagut un error de lectura en el fitxer de dades d'alumnes");
        }

    }

}
