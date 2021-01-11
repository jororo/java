package Activitats_array;

public class ProgramaMisterios {

    public static final int[] array = {1, 6, 4, 8, 3, 7, 3, 6, 9, 4, 2, 9, 6};

    public static void main(String[] args) {

        int i = 1;
        int resultat = 0;
        //mientras el valor de array en i diferete a 9 ejecuta lo siguiente
        
        while (array[i] != 9) {
            
            if (array[i - 1] < array[i]) {
                resultat++;
            }
            i++;
        }
        
        System.out.println("El resultat és " + resultat + ".");
    }
}
