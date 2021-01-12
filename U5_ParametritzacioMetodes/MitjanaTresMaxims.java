/*
Feu un programa anomenat MitjanaTresMaxims que llegeixi una seqüència de 10 
valors enters des del teclat, els desi a un array i mostri per pantalla quina és 
la mitjana aritmètica dels seus tres valors més grans. A mode d’exemple, el 
comportament del programa podria ser el següent:
 */
package U5_ParametritzacioMetodes;

import java.util.Scanner;

//Un programa que diu quina és la mitjana entre els tres valors més grans
public class MitjanaTresMaxims {

    public static void main(String[] args) {
        MitjanaTresMaxims programa = new MitjanaTresMaxims();
        programa.inici();
    }

    public void inici() {
        System.out.println("Escriu deu enters separats per espais: ");
        int[] array = llegirArrayEntersTeclat();
        double res = calculaMitjanaTresMaxims(array);
        System.out.println("La mitjana dels tres valors més grans és " + res);
    }

    public int[] llegirArrayEntersTeclat() {
        Scanner lector = new Scanner(System.in);
        int[] llistaEnters = new int[10];
        int entersLlegits = 0;
        //Mientras entersLlegits sea menor que 10
        while (entersLlegits < 10) {

            if (lector.hasNextInt()) {
                // la array llistaEnters en la pocicion entersLlegits introduce el entero
                llistaEnters[entersLlegits] = lector.nextInt();
                // suma 1 al contador entersLlegits
                entersLlegits++;
            } else {
                lector.next();
            }
        }
        lector.nextLine();
        return llistaEnters;
    }

    public double calculaMitjanaTresMaxims(int[] array) {
        ordenarDescendent(array);
        return (array[0] + array[1] + array[2]) / 3;
    }

    public void ordenarDescendent(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                //si array en i es menor que array en j
                if (array[i] < array[j]) {
                    //da a la varaible canvi el valor de array en i
                    int canvi = array[i];
                    //da a la array en i canvi el valor de array en j
                    array[i] = array[j];
                    //da a la array en j canvi el valor de canvi
                    array[j] = canvi;
                }
            }
        }
    }

}
