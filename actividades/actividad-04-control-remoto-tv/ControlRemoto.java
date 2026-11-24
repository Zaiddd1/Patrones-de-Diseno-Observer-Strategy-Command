// Invocador: tiene 5 botones y a cada uno se le asigna un comando.
// No sabe qué hace cada comando; solo llama a ejecutar().
public class ControlRemoto {

    private Comando[] botones = new Comando[5];

    public void asignarBoton(int posicion, Comando comando) {
        botones[posicion] = comando;
    }

    public void presionarBoton(int posicion) {
        if (botones[posicion] == null) {
            System.out.println("Ese botón no tiene ninguna función asignada.");
        } else {
            botones[posicion].ejecutar();
        }
    }
}
