package Arrays;

import java.util.Scanner;

class Utils {

    Scanner teclat;

    public void mostrarTex(String text) {
        System.out.println(text);
    }

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

}
