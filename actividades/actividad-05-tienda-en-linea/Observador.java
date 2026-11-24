// Interfaz Observer: los clientes suscritos reciben los avisos de la tienda
public interface Observador {

    void actualizar(String mensaje);

    String getNombre();
}
