package U5_DescomposicioProblemes;
/*
Feu un programa anomenat CalculTirada que calculi la probabilitat en tant per 
cent de treure per sota d’un valor concret tirant dos daus de sis cares. Per fer 
això, l’estratègia que s’ha considerat és desar dins d’un array el nombre de 
repeticions de cada tirada possible (sempre entre 2 i 12) i després treballar a 
partir d’aquests valors
*/
import java.util.Scanner;

public class CalculTirada {

    public static final int CARES_DAU = 6;

    //Variables globals
    int[] llistaTirades = new int[CARES_DAU * 2 - 1];
    int valor = 0;

    public static void main(String[] args) {
        CalculTirada programa = new CalculTirada();
        programa.inici();
    }

    public void inici() {
        llegirValor();
        generarTirades();
        mostrarProbabilitat();
    }

    public void llegirValor() {
        System.out.print("Escriu el valor a calcular [2 - 12]: ");
        Scanner lector = new Scanner(System.in);
        //mientras valor sea = a 0 se ejecutara
        while (valor == 0) {
            //si lee un valor lanza la funcion comprovarValor
            if (lector.hasNextInt()) {
                valor = lector.nextInt();
                comprovarValor();
            } else {
                lector.next();
            }
        }
        lector.nextLine();
    }

    public void generarTirades() {
        //genera las posibles tiradas con un doble bucle i es un dado y j otro 
        for (int i = 1; i <= CARES_DAU; i++) {
            for (int j = 1; j <= CARES_DAU; j++) {
                llistaTirades[i + j - 2]++;
                //System.out.println("Valor de i:" + i + " Valor de j:" + j + " valor de i + j - 2 es: " + ((i + j) - 2));
            }
        }
    }

    public void mostrarProbabilitat() {
        int acumulador = 0;
        // para 
        for (int i = 0; i <= (valor - 2); i++) {
            acumulador = acumulador + llistaTirades[i];
        }
        double resultat = (acumulador * 100) / (CARES_DAU * CARES_DAU);
        System.out.println("La probabilitat es " + resultat + "%.");

    }

    public void comprovarValor() {
        //si valor es menos que 2 o mayor que 12
        if ((valor < 2) || (valor > CARES_DAU * 2)) {
            System.out.println("El valor no es entre 2 i 12.");
            valor = 0;
        }
    }

}
