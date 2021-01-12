/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U4_Activitats_array;

/**
 *
 * @author jordi
 */
public class ComptaAsArray {
    
    public static final char[] array = {'a', 'c', 'z', 'a', 'w', 'a', 'q', 'f', 'f', 'c', 'a'};

    public static void main(String[] args) {
        
        int comptador = 0;
        //recorremos la array
        for (int i = 0; i < array.length; i++) {
            //si el valor de la array en i = el caracter a
            if (array[i] == 'a') {
                //contador suma 1
                comptador++;
            }
        }
        System.out.println("Hi ha " + comptador + " a's.");
    }
}
