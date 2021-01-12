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
public class ValorMinim {

    // creamos una array statica
    public static final double[] array = {1, -2.2, 6.7, 4, 23.5, -5.5, 4.43, 20};

    public static final void main(String[] args) {
        // a "minim" le damso el valord e la array
        double minim = array[0];
        // recorremos la "array" en i es menos que el valor de minim
        for (int i = 1; i < array.length; i++) {
            //si el valor de  se ejecuta
            if (array[i] < minim) {
                //damos a "minim" el valor de "array" en i
                minim = array[i];
            }
        }
        System.out.println("El valor mínim és " + minim + ".");
    }
}
