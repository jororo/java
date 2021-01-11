package EAC4;

public class EAC4_P4T1 {

    public static void main(String[] args) {
        EAC4_P4T1 prg = new EAC4_P4T1();
        prg.inici();
    }

    void inici() {
        /* Per investigar què passa si fem canvis a tot un array passat per paràmetre 
         */
        int[] varArray = new int[8];

        for (int i = 0; i < varArray.length; i++) {
            varArray[i] = i * 2;
        }

        System.out.print("Abans de cridar a la funció ");
        System.out.print("canviarValorParametreArray(varArray) ");
        System.out.print("la variable varArray val: ");
        printIntArray(varArray);
        canviarValorParametreArray(varArray);
        System.out.print("Despres de cridar a la funció ");
        System.out.print("canviarValorParametreArray(varArray) ");
        System.out.print("la variable varArray val: ");
        printIntArray(varArray);
    }

    void canviarValorParametreArray(int[] param) {
        int[] valorACanviar = new int[8];
        for (int i = 0; i < valorACanviar.length; i++) {
            valorACanviar[i] = i * 3;
        }

        System.out.print("Dins la funció canviarValorParametreArray(param), ");
        System.out.print("abans del canvi [param={0, 3, 9, ...}] el paràmetre val: ");
        printIntArray(param);
        param = valorACanviar;
        System.out.print("Dins la funció canviarValorParametreArray(param), ");
        System.out.print("després del canvi [param={0, 3, 9, ...}] el paràmetre val: ");
        printIntArray(param);
    }

    void printIntArray(int[] valors) {
        int limitFor = valors.length - 1;
        System.out.print("{ ");
        for (int i = 0; i < limitFor; i++) {
            System.out.print(valors[i]);
            System.out.print(", ");
        }
        if (limitFor >= 0) {
            System.out.print(valors[limitFor]);
        }
        System.out.println(" }");
    }
}
