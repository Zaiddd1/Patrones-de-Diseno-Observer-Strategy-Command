// Observador concreto: un cliente que recibe los avisos de la tienda
public class Cliente implements Observador {

    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public void actualizar(String mensaje) {
        System.out.println("   -> " + nombre + " recibió: " + mensaje);
    }

    public String getNombre() {
        return nombre;
    }
}
