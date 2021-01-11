package Activitats_array;

public class CercarMulltiplesDeTres {

    public static void main(String[] args) {

        int array[] = {1, 12, 4, 5, 7, 3, 2, 9, 6, 7};
        int i = 0;
        // contador de valores multiples de 3
        int numMultiples = 0;
        //mientras numMultiples sea menor que 2 y i sea menos que el valor maximo de la array
        while ((numMultiples < 2) && (i < array.length)) {
            //si array en i dividida por 3 el resto es igual a 0 ejecuta lo siguinte
            if (array[i] % 3 == 0) {
                // contador numMultiples suma 1
                numMultiples++;
                // si el contador numMultiples es igual a 2 ejecuta lo siguinte
                if (numMultiples == 2) {

                    System.out.println("El segon múltiple és: " + array[i] + ".");

                }
            }
            i++;
        }

        //si el contador numMultiples es menor qeu 2 ejecuta lo siguinte
        if (numMultiples < 2) {
            System.out.println("Hi ha menys de 2 múltiples de tres...");
        }
    }
}
