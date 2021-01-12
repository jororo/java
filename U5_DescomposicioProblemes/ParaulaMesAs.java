package U5_DescomposicioProblemes;
/*
Feu un programa anomenat FraseAmbMesAs que vagi llegint frases pel teclat i, en 
acabar cada entrada d’una frase, mostri quina és la frase que s’ha escrit fins 
al moment amb més lletres ‘a’ (minúscula o majúscula) i quantes en tenia. El 
programa ha d’anar-se executant fins a llegir la frase “fi”. A mode de guia de 
sortida hauria de ser semblant a la que es mostra tot seguit.
*/

import java.util.Scanner;

public class ParaulaMesAs {

    private boolean fi = false;
    private int numAs = 0;
    private String fraseMesAs = null;
    private String fraseActual = null;

    public static void main(String[] args) {
        
        ParaulaMesAs programa = new ParaulaMesAs();
        programa.inici();
        
    }

    public void inici() {
        //mientras "fi" sea falso se ejecuta
        while (!fi) {
            processarFrase();
            mostrarResultatActual();
        }
        

    }

    public void processarFrase() {
        Scanner lector = new Scanner(System.in);
        System.out.print("Escriu una frase:\n> ");
        fraseActual = lector.nextLine();     
        //si fraseActual es igual que fi
        if (fraseActual.equals("fi")) {
            // fi toma el valor verdadero
            fi = true;
        } else {
            //si no llama la funcion compararAs
            compararAs();
        }
    }

    public void mostrarResultatActual() {
        System.out.print("La frase amb més a's és: ");
        System.out.println("\"" + fraseMesAs + "\"");
        System.out.println("Té " + numAs + " a's.");
    }

    public void compararAs() {
        int acumulador = 0;
        String fraseMinuscula = fraseActual.toLowerCase();   
        //recorre el string y si un carater es igual a la aletra a suma uno al contador
        for (int i = 0; i < fraseActual.length(); i++) {
            if (fraseMinuscula.charAt(i) == 'a') {
                acumulador++;
            }
        }
        //si el contador es mayor que "numAs". 
        if (acumulador > numAs) {
            //Introduce el valor del contador a "numAs"
            numAs = acumulador;
            //en fraseMesAs introduce la fraseActual
            fraseMesAs = fraseActual;
        }
    }

}
