package U4_Activitats_text;

public class ParteixArguments {

    public static void main(String[] args) {

        String cadena = "Hi havia una vegada una noia.";
        String[] arrayParaules = cadena.split(" ");

        for (int i = 0; i < arrayParaules.length; i++) {

            int meitat = arrayParaules[i].length() / 2;
            //La llargària és senar?

            if (arrayParaules[i].length() % 2 != 0) {
                meitat++;
            }

            String mitjaCadena = arrayParaules[i].substring(0, meitat);
            System.out.println(mitjaCadena);
        }

    }

}
