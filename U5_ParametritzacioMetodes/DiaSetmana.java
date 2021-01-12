/*
Donat el codi font parcial del programa DiaSetmana, que es mostra tot seguit, 
completeu el mètode diaDeLaSetmana (inicialment buit), de manera que, donat un 
número de dia de la setmana (1-7), retorni el nom del dia (Dilluns…Diumenge). 
També ha de tenir en compte el cas que el valor d’entrada no sigui cap dia de la 
setmana.
 */
package U5_ParametritzacioMetodes;

//Un programa que diu quin dia de la setmana és
public class DiaSetmana {

    public static void main(String[] args) {
        DiaSetmana programa = new DiaSetmana();
        programa.inici();
    }

    public void inici() {
        String nom = diaDeLaSetmana(3);
        System.out.println("El tercer dia de la setmana és " + nom);
        nom = diaDeLaSetmana(5);
        System.out.println("El cinquè dia de la setmana és " + nom);
        nom = diaDeLaSetmana(8);
        System.out.println("El vuite dia de la setmana és " + nom);
    }

    //Param. entrada: número del dia
    //Param. sortida: el nom del dia
    public String diaDeLaSetmana(int numDia) {
        //Aquesta solució usa una estructura de selecció
        String nomDia = "(No existeix aquest dia)";
        switch (numDia) {
            case 1:
                nomDia = "dilluns";
                break;
            case 2:
                nomDia = "dimarts";
                break;
            case 3:
                nomDia = "dimecres";
                break;
            case 4:
                nomDia = "dijous";
                break;
            case 5:
                nomDia = "divendres";
                break;
            case 6:
                nomDia = "dissabte";
                break;
            case 7:
                nomDia = "diumenge";
                break;
        }
        return nomDia;
    }
}
