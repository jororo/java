package U4_Activitats_array;

public class BarrejarArrays {

    public static void main(String[] args) {
        int[] arrayA = {1, 3, 5, 7, 9, 11, 13, 15};
        int[] arrayB = {2, 4, 6, 8, 10, 12, 14, 16};

        int[] nouArray = new int[arrayA.length + arrayB.length];

        //Omple la part de A.
        int indexNou = 0;
        // Recorre la aray asta el final
        for (int i = 0; i < arrayA.length; i++) {
            //en la pocicion de indexNou de la nueva array introduce el valor de arrayA en la posicion de i
            nouArray[indexNou] = arrayA[i];
            //suma dos a indexNou
            indexNou = indexNou + 2;

        }
        // mostramo el conteido de la array nouArray 
        for (int i = 0; i < nouArray.length; i++) {
            System.out.print(nouArray[i]);
            System.out.print(", ");
        }
        System.out.println("");

        //Omple la part de B.
        indexNou = 1;

        for (int i = 0; i < arrayB.length; i++) {
            nouArray[indexNou] = arrayB[i];
            indexNou = indexNou + 2;
        }
        // mostramo el conteido de la array nouArray

        for (int i = 0; i < nouArray.length; i++) {
            System.out.print(nouArray[i]);
            System.out.print(", ");

        }
        System.out.println("");
    }
}
