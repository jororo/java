package EAC4;

import java.util.Scanner;

public class EAC4_P2T3 {

    public static void main(String[] args) {
        //Es crea una instància del programa
        EAC4_P2T3 programa = new EAC4_P2T3();
        //Es crida el mètode inici per tal de comencçar l'execució
        programa.inici();
    }

    public void inici() {
        int mesInicial;
        int mesFinal;
        int totalDies;

        mesInicial = demanarMesInicial();
        mesFinal = demanarMesFinal();
        totalDies = calcularDies(mesInicial, mesFinal);
        System.out.println(totalDies);
    }

    private int demanarMesInicial() {
        int resposta;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indica el número del més mes inicial: ");
        resposta = scanner.nextInt();
        return resposta;
    }

    private int demanarMesFinal() {
        int resposta;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indica el número del més mes final: ");
        resposta = scanner.nextInt();
        return resposta;
    }

    private int calcularDiesQueTeElMes(int mesACalcular) {
        int diesTrobats;

        switch (mesACalcular) {
            case 1:
                diesTrobats = 31;
                break;
            case 2:
                diesTrobats = 28;
                break;
            case 3:
                diesTrobats = 31;
                break;
            case 4:
                diesTrobats = 30;
                break;
            case 5:
                diesTrobats = 31;
                break;
            case 6:
                diesTrobats = 30;
                break;
            case 7:
                diesTrobats = 31;
                break;
            case 8:
                diesTrobats = 31;
                break;
            case 9:
                diesTrobats = 30;
                break;
            case 10:
                diesTrobats = 31;
                break;
            case 11:
                diesTrobats = 30;
                break;
            case 12:
                diesTrobats = 31;
                break;
            default:
                diesTrobats = -1;
        }
        return diesTrobats;
    }

    private int calcularDies(int mesInicial, int mesFinal) {
        int res = 0;
        // cogemos del mes inicial al mes final y en cada vuelta del for sumamos el valor de la funcion "calcularDiesQueTeElMes" cin el valor de "i"
        for (int i = mesInicial; i <= mesFinal; i++) {
            res = res + calcularDiesQueTeElMes(i);
        }
        return res;
    }

}
