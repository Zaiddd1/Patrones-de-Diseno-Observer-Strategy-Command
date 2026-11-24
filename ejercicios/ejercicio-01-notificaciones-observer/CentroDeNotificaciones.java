import java.util.ArrayList;
import java.util.List;

// Sujeto (Subject): guarda la lista de suscritos y les avisa cuando hay una notificación nueva
public class CentroDeNotificaciones {

    private List<Observador> suscritos = new ArrayList<>();

    public void suscribir(Observador observador) {
        if (suscritos.contains(observador)) {
            System.out.println(observador.getNombre() + " ya estaba suscrito.");
        } else {
            suscritos.add(observador);
            System.out.println(observador.getNombre() + " se suscribió.");
        }
    }

    public void desuscribir(Observador observador) {
        if (suscritos.remove(observador)) {
            System.out.println(observador.getNombre() + " canceló su suscripción.");
        } else {
            System.out.println(observador.getNombre() + " no estaba suscrito.");
        }
    }

    public void publicar(Notificacion notificacion) {
        if (suscritos.isEmpty()) {
            System.out.println("No hay usuarios suscritos; nadie recibió el aviso.");
            return;
        }
        System.out.println("Enviando a " + suscritos.size() + " suscrito(s)...");
        for (Observador observador : suscritos) {
            observador.actualizar(notificacion);
        }
    }

    public List<Observador> getSuscritos() {
        return suscritos;
    }
}
