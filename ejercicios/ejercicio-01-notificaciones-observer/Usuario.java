import java.util.ArrayList;
import java.util.List;

// Observador concreto: un usuario que recibe notificaciones y las guarda en su historial
public class Usuario implements Observador {

    private String nombre;
    private List<Notificacion> recibidas = new ArrayList<>();

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Notificacion notificacion) {
        recibidas.add(notificacion);
        System.out.println("   -> " + nombre + " recibió: " + notificacion);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public List<Notificacion> getRecibidas() {
        return recibidas;
    }
}
