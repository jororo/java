package U4_Activitats_array;

/*
Aquest programa no mostra res per pantalla, ja que és incorrecte. Com que la 
variable “i”, usada dins de la condició lògica de l’estructura de repetició 
mai no es modifica enlloc, hi ha un bucle infinit.
*/

public class UnAltreProgramaMisterios {

    public static final int[] array = {1, 6, 4, 8, 3, 7, 3, 6, 9, 4, 2, 9, 6};

    public static void main(String[] args) {

        int i = array.length - 1;
        int resultat = 0;

        while (i > (array.length / 2)) {
            if (array[i] == 4) {
                resultat--;
            } else {
                resultat++;
            }
        }
        System.out.println("El resultat és " + resultat + ".");
    }

}
