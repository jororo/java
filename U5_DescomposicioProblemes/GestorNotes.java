package U5_DescomposicioProblemes;

/*
Feu un programa anomenat GestorNotes que permeti gestionar les notes dins una 
aula de fins a 40 estudiants. Les notes es poden anar introduint dins el sistema 
de manera esglaonada. A partir d’un menú, s’ha de poder:

Registrar noves notes. Cada cop que es faci, s’ha de poder llegir una seqüència 
de valors arbitràriament llarga fins a trobar un -1. Llavors s’acaba la lectura. 
Per exemple, si es volen entrar les notes 3, 4 i 7.5, s’escriuria “3 4 7,5 -1”.
Mostrar per pantalla la nota mitjana fins al moment.
Mostrar un histograma de tots les notes segons les classificacions Suspès 
(menys de 5), Aprovat (entre 5 i 6.5), Notable (entre 6.5 i 8.5) i Excel·lent 
(més de 8.5).
 */
import java.util.Scanner;

public class GestorNotes {

    //1 3 4,5 5 5,5 6 6 7,3 8,5 9,2 10 -1
    //Constant que tradueix índexs histograma a text
    private static final String[] textHistograma = {"Suspès ", "Aprovat ", "Notable ", "Excel·lent"};

    //Variables globals
    private boolean fi = false;
    private boolean seguirLlegint = true;

    Scanner lector = new Scanner(System.in);
    private int numNotes = 0;
    private float[] notes = new float[40];

    //Índexs: 0 = Suspesos, 1 = Aprovats, 2 = Notables, 3 = Excel·lents
    private int[] histograma = new int[textHistograma.length];

    //Mètodes associats al problema general
    public static void main(String[] args) {
        GestorNotes programa = new GestorNotes();
        programa.inici();
    }

    public void inici() {
        while (!fi) {
            mostrarMenu();
            tractarOpcio();
        }
    }

    public void mostrarMenu() {
        System.out.println("Benvingut al gestor de notes");
        System.out.println("----------------------------");
        System.out.println("[RT] Registrar notes.");
        System.out.println("[MJ] Consultar nota mitjana.");
        System.out.println("[HT] Histograma de notes.");
        System.out.println("[FI] Sortir.");
        System.out.print("Opció: ");
    }

    public void tractarOpcio() {
        String opcio = lector.nextLine();
        if (opcio.equalsIgnoreCase("RT")) {
            registreNotes();
        } else if (opcio.equalsIgnoreCase("MJ")) {
            mostrarMitjana();
        } else if (opcio.equalsIgnoreCase("HT")) {
            mostrarHistograma();
        } else if (opcio.equalsIgnoreCase("FI")) {
            fi = true;
        } else {
            System.out.println("Opció incorrecta!\n");
        }
    }

    //Mètodes associats al segon nivell de descomposició
    public void registreNotes() {
        System.out.println("Escriu les notes, posa -1 per acabar:");
        // mientraS seguirLlegint sea verdadero
        while (seguirLlegint) {
            //si numNotes es igual a la logitud de la array notes 
            if (numNotes == notes.length) {
                System.out.println("Ja no queda més espai.");
                seguirLlegint = false;
            }
            llegirValor();
        }
        lector.nextLine();
    }

    public void mostrarMitjana() {
        if (numNotes > 0) {
            System.out.print("La nota mitjana és de ");
            calculaMitjana();
            System.out.println(".");
        } else {
            System.out.println("No hi ha notes registrades.");
        }
    }

    public void mostrarHistograma() {
        calculaHistograma();
        for (int i = 0; i < histograma.length; i++) {
            System.out.print(textHistograma[i] + ":");
            for (int j = 0; j < histograma[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

//Mètodes associats al tercer nivell de descomposició
    public void llegirValor() {
        if (lector.hasNextFloat()) {
            float valor = lector.nextFloat();
            if (valor == -1) {
                seguirLlegint = false;
            } else {
                notes[numNotes] = valor;
                numNotes++;
            }
        } else {
            lector.next();
        }
    }

    public void calculaMitjana() {
        float acumulador = 0;
        for (int i = 0; i < numNotes; i++) {
            acumulador = acumulador + notes[i];
        }
        System.out.print((acumulador / numNotes));
    }

    public void calculaHistograma() {
        for (int i = 0; i < numNotes; i++) {
            if ((notes[i] >= 9) && (notes[i] <= 10)) {
                histograma[3]++;
            } else if (notes[i] >= 6.5) {
                histograma[2]++;
            } else if (notes[i] >= 5) {
                histograma[1]++;
            } else {
                histograma[0]++;
            }
        }
    }

}
