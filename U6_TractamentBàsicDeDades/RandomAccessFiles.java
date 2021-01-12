/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U6_TractamentBàsicDeDades;

/**
 *
 * @author jordi
 */
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFiles {

    public static void main(String[] args) throws IOException {

        char c;
        boolean finArchivo = false;
        RandomAccessFile archivo;

        try {
            archivo = new RandomAccessFile("prueba.txt", "rw");
            System.out.println("El tamaño es: " + archivo.length());
            System.out.println("El tamaño es: " + archivo.length());
        } catch (FileNotFoundException fe) {
            System.out.println("No se encontro el archivo");

        }

    }

}
