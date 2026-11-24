// Interfaz Command: cada acción del carrito se puede ejecutar y también deshacer
public interface Comando {

    void ejecutar();

    void deshacer();

    String getDescripcion();
}
