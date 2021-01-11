package Activitats_text;

public class ComptaAsString {

    public static final String cadena = "Hi havia una vegada…";

    public static void main(String[] args) {

        int comptador = 0;
        //recorre la cedena de texto asta el final
        for (int i = 0; i < cadena.length(); i++) {
            //si en la poicion "i" de la cedena de testo  es igual a "a"
            if (cadena.charAt(i) == 'a') {
                //aumenta en uno el contador
                comptador++;
            }
        }

        System.out.println("Hi ha " + comptador + " as.");
    }
}
