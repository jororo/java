package EAC5_P1_LLIURABLE;

public class AppEac5P1 {

    public static void main(String[] args) {
        Utils util = new Utils();
        String valorAlfa, msg;
        int valorEnter;
        String[] matricula = {"1122ABCD", "22AB", "A234ABC", "1122A4C", "1122ABC"};

        valorAlfa = util.entrarTex("Entra un valor alfanumeric: ");
        util.mostrarTex("El valor que has entrat és: " + valorAlfa);

        valorEnter = util.entrarEnter("Entra un valor enter: ");
        util.mostrarTex("El valor que has entrat és: " + valorEnter);

        for (int i = 0; i < matricula.length; i++) {
            msg = util.validarMatricula(matricula[i]);
            System.out.print(matricula[i] + ": ");
            if (msg.equals("")) {
                util.mostrarTex(" té un format correcte");
            } else {
                util.mostrarTex(msg);
            }
        }
    }
}