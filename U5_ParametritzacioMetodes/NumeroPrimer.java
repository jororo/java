/*
Feu un programa anomenat NumeroPrimer que inclogui un mètode anomenat esPrimer. 
Aquest mètode, donat un número enter, ha de dir si és primer o no. Un número 
primer és aquell que no pot ser dividit per cap altre número excepte l’1 o ell 
mateix. Només cal que funcioni amb valors positius, però no es pot usar 
System.out.println(…) dins d’aquest mètode. Proveu que funciona fent 
successives invocacions des del mètode inici.
 */
package U5_ParametritzacioMetodes;

//Un programa que comprova la primalitat d'un valor
public class NumeroPrimer {

    public static void main(String[] args) {
        NumeroPrimer programa = new NumeroPrimer();
        programa.inici();
    }

    public void inici() {
        int i;

        i = 18;
        System.out.println("El " + i + " és primer? " + esPrimer(i));
        i = 13;
        System.out.println("El " + i + " és primer? " + esPrimer(i));
        i = 33;
        System.out.println("El " + i + " és primer? " + esPrimer(i));
    }

    //Param. entrada: el valor a testejar
    //Param. sortida: si és primer (true) o no (false)
    public boolean esPrimer(int valor) {
        //El codi és més simple si es fa return directament
        for (int i = 2; i < valor; i++) {
            // si "valor" es multiplo de "i" retorna false
            if (valor % i == 0) {
                return false;
            }
        }
        return true;
    }

}
