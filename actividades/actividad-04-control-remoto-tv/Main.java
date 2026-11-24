import java.util.Scanner;

// Cliente: arma el televisor, los comandos y el control remoto, y deja usarlo desde un menú
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Televisor tv = new Televisor();

        ControlRemoto control = new ControlRemoto();
        control.asignarBoton(0, new ComandoEncenderApagar(tv));
        control.asignarBoton(1, new ComandoSubirVolumen(tv));
        control.asignarBoton(2, new ComandoBajarVolumen(tv));
        control.asignarBoton(3, new ComandoCanalSiguiente(tv));
        control.asignarBoton(4, new ComandoCanalAnterior(tv));

        int opcion = -1;
        while (opcion != 0) {
            System.out.println();
            System.out.println("===== CONTROL REMOTO DEL TELEVISOR =====");
            System.out.println("1. Encender / Apagar");
            System.out.println("2. Subir volumen");
            System.out.println("3. Bajar volumen");
            System.out.println("4. Canal siguiente");
            System.out.println("5. Canal anterior");
            System.out.println("0. Salir");
            System.out.print("Presione un botón: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            if (opcion >= 1 && opcion <= 5) {
                control.presionarBoton(opcion - 1);
            } else if (opcion != 0) {
                System.out.println("Opción no válida.");
            }
        }
        System.out.println("Control remoto guardado. Hasta luego.");
    }
}
