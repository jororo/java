package EAC5_P3_LLIURABLE;

import java.util.Scanner;

public class Utils {

    static final String MATRICULA_SUPERA_MAX = "La matricula té més de 7 caracters";
    static final String MATRICULA_INFERIOR_MIN = "La matricula té menys de 7 caracters";
    static final String POSICIOMATRICULA_NO_NUMERO = "Un dels quatre primers caracters no és un número";
    static final String POSICIOMATRICULA_NO_LLETRA = "Un dels tres ultims caracters no és una lletra";
    Scanner teclat;

    public String entrarTex(String tex) {
        System.out.print(tex);
        teclat = new Scanner(System.in);
        String str = teclat.nextLine();
        return str;
    }

    public int entrarEnter(String tex) {
        System.out.print(tex);
        teclat = new Scanner(System.in);
        int num = teclat.nextInt();
        return num;
    }

    public void mostrarTex(String text) {
        System.out.println(text);
    }

    public String validarMatricula(String matricula) {
        String ret = "";
        if (matricula.length() > 7) {
            ret = MATRICULA_SUPERA_MAX;
        } else if (matricula.length() < 7) {
            ret = MATRICULA_INFERIOR_MIN;
        } else {
            ret = validarFormatMatricula(matricula);
        }
        return ret;
    }

    private String validarFormatMatricula(String matricula) {
        String ret = "";
        int valor;
        int i = 0;
        boolean trobatError = false;
        while (i < matricula.length() && !trobatError) {
            valor = matricula.charAt(i);
            if (i < 4) {
                if (valor < 48 || valor > 57) {
                    trobatError = true;
                    ret = POSICIOMATRICULA_NO_NUMERO;
                }
            } else {
                if (valor < 65 || valor > 90) {
                    trobatError = true;
                    ret = POSICIOMATRICULA_NO_LLETRA;
                }
            }
            i++;
        }
        return ret;
    }
}
