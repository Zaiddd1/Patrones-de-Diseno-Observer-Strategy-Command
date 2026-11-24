import java.util.ArrayDeque;
import java.util.Deque;

// Invocador: ejecuta los comandos y los guarda en una pila para poder deshacerlos
public class HistorialDeComandos {

    private Deque<Comando> pila = new ArrayDeque<>();

    public void ejecutar(Comando comando) {
        comando.ejecutar();
        pila.push(comando);
        System.out.println("Hecho: " + comando.getDescripcion() + ".");
    }

    public void deshacerUltimo() {
        if (pila.isEmpty()) {
            System.out.println("No hay acciones para deshacer.");
            return;
        }
        Comando ultimo = pila.pop();
        ultimo.deshacer();
        System.out.println("Se deshizo: " + ultimo.getDescripcion() + ".");
    }
}
