package EAC6_P1_LLIURABLE;

import java.util.Scanner;

public class Utils {
    static final String MARC_TITOL = "********************************************************************************";
    static final String MARC_INFO = "--------------------------------------------------------------------------------";

    private void mostrarFraseTitol(String titol, int amplada){
        int nEspais = (amplada - titol.length())/2;
        for(int i=0; i<nEspais; i++){
            System.out.print(" ");
        }
        System.out.println(titol);
    }
    
    void mostrarTitols(String titol, String subtitol){
        //simular la neteja de pantalla
        for(int i=0; i<10; i++){
            System.out.println();
        }
        //mostrar els títols
        System.out.println(MARC_TITOL);
        mostrarFraseTitol(titol.toUpperCase(), MARC_TITOL.length());
        mostrarFraseTitol(subtitol, MARC_TITOL.length());
        System.out.println(MARC_TITOL);
        System.out.println();
        System.out.println();
    }

    int entrarUnEnter(String missatge){
        Scanner scanner = new Scanner(System.in);
        int ret;
        boolean correcte=false;
        do{
            System.out.print(missatge);
            correcte=scanner.hasNextInt();
            if(!correcte){
                scanner.next();
                System.out.println("\nCal que entris un enter si us plau.");
            }
        }while(!correcte);
        ret = scanner.nextInt();  
        scanner.nextLine();
        return ret;
    }
    
    void entrarPerContinuar(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("prem [ENTRAR] per continuar");
       scanner.nextLine();
    }

    
    String seleccionarDeLlista(String missatge, String[] llistaOpcions){
       int opc;
       do{
           System.out.println(missatge);
           System.out.println("\tOpcions vàlides:");
           for(int i=0; i<llistaOpcions.length; i++){
                System.out.print("\t\t");
                System.out.print(i+1);
                System.out.print(") ");
                System.out.println(llistaOpcions[i]);
           }
           opc = entrarUnEnter("Escriviu el número de la opció que vulgueu seleccionar:");
           if(opc<1 || opc>llistaOpcions.length){
               mostrarAlerta("Només podeu escollir una opció vàlida. Torneu-ho a intentar.");
           }
       }while(opc<1 || opc>llistaOpcions.length);
       return llistaOpcions[opc-1];
    }

    void mostrarAlerta(String missatge){
        System.out.print("ALERTA! ");
        System.out.println(missatge);
    }
    
    
    String entrarText(String missatge){
       Scanner scanner = new Scanner(System.in);
       String ret;
       System.out.print(missatge);
       ret = scanner.nextLine();        
       return ret;
    }
    
    void mostrarInformacio(String informacio){
        System.out.println();
        System.out.println(MARC_INFO);
        System.out.println(informacio);
        System.out.println(MARC_INFO);
        System.out.println();
    }
}
