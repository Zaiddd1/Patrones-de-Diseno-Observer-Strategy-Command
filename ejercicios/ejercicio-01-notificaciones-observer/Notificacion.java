// Un aviso que el sistema envía a los usuarios suscritos
public class Notificacion {

    private String tipo;        // "Promoción" o "Actualización de producto"
    private String mensaje;

    public Notificacion(String tipo, String mensaje) {
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return "[" + tipo + "] " + mensaje;
    }
}
