package EAC4;

public class EAC4_P1T3 {

    public static void main(String[] args) {
        EAC4_P1T3 prog = new EAC4_P1T3();
        prog.inici();
    }

    void inici() {
        mostrarDiesDeLaSetmana();
        System.out.println("-----------");
        dibuixTriangle();
    }

    void mostrarDiesDeLaSetmana() {
        System.out.println(" - Lunes");
        System.out.println(" - Martes");
        System.out.println(" - Miercoles");
        System.out.println(" - Jueves");
        System.out.println(" - Viernes");
        System.out.println(" - Sabado");
        System.out.println(" - Domingo");
    }

    void dibuixTriangle() {
        System.out.println();
        // resta a i 1 en cada vuelta de 5
        for (int i = 5; i >= 0; i--) {

            //suma 1 a j en cada vuelta y el valor a alcazar es 5 menos el valor de i
            for (int j = 0; j <= 5 - i; j++) {
                // muestra asterisco
                System.out.print(" *");
            }
            // crea un salto de linea
            System.out.print("\n");

        }
    }
}
