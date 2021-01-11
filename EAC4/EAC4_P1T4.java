package EAC4;

import java.util.Scanner;

public class EAC4_P1T4 {

    int mesEscollit;
    int diesQueTeElMesEscollit;

    public static void main(String[] args) {
        //Es crea una intència del programa
        EAC4_P1T4 programa = new EAC4_P1T4();
        //Es crida el mètode inici per tal de comencçar l'execució
        programa.inici();
    }

    public void inici() {
        demanarMes();
        calcularDiesQueTeElMes();
        mostrarDiesDelMes();
    }

    public void demanarMes() {
        // pide el numero del mes y lo da como valor a "mesEscollit"
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica el número del més de l'any per saber quants dies té:");
        mesEscollit = scanner.nextInt();
    }

    public void calcularDiesQueTeElMes() {
        // con la varaible "mesEscollit" devulve el resultado del switch
        switch (mesEscollit) {
            case 1:
                diesQueTeElMesEscollit = 31;
                break;
            case 2:
                diesQueTeElMesEscollit = 28;
                break;
            case 3:
                diesQueTeElMesEscollit = 31;
                break;
            case 4:
                diesQueTeElMesEscollit = 30;
                break;
            case 5:
                diesQueTeElMesEscollit = 31;
                break;
            case 6:
                diesQueTeElMesEscollit = 30;
                break;
            case 7:
                diesQueTeElMesEscollit = 31;
                break;
            case 8:
                diesQueTeElMesEscollit = 31;
                break;
            case 9:
                diesQueTeElMesEscollit = 30;
                break;
            case 10:
                diesQueTeElMesEscollit = 31;
                break;
            case 11:
                diesQueTeElMesEscollit = 30;
                break;
            case 12:
                diesQueTeElMesEscollit = 31;
                break;
            default:
                diesQueTeElMesEscollit = -1;
        }
    }

    public void mostrarDiesDelMes() {
        // si el valor de "diesQueTeElMesEscollit"  es igual a -1 muestra lo siguinte
        if (diesQueTeElMesEscollit == -1) {
            System.out.print("No existeix el mes ");
            System.out.print(mesEscollit);
            System.out.print(". Només hi ha 12 mesos.");
        } else {
            // Si no lo es muestra lo siguinte
            System.out.print("T'informem que el més ");
            System.out.print(mesEscollit);
            System.out.print(" conté ");
            System.out.print(diesQueTeElMesEscollit);
            System.out.println(" dies");
        }
    }
}
