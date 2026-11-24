// Interfaz Observer: todo el que quiera recibir avisos debe implementarla
public interface Observador {

    void actualizar(Notificacion notificacion);

    String getNombre();
}
