import java.util.ArrayList;
import java.util.List;

// La tienda cumple dos papeles:
//  - Sujeto (Observer): avisa a los clientes suscritos cuando hay una oferta.
//  - Contexto (Strategy): guarda el descuento que se aplica al carrito y lo cambia con cada oferta.
public class Tienda {

    private List<Observador> suscritos = new ArrayList<>();
    private EstrategiaDescuento descuento = new SinDescuento();

    // ----- parte Observer -----
    public void suscribir(Observador observador) {
        if (suscritos.contains(observador)) {
            System.out.println(observador.getNombre() + " ya estaba suscrito.");
        } else {
            suscritos.add(observador);
            System.out.println(observador.getNombre() + " se suscribió a las ofertas.");
        }
    }

    public void desuscribir(Observador observador) {
        if (suscritos.remove(observador)) {
            System.out.println(observador.getNombre() + " canceló su suscripción.");
        } else {
            System.out.println(observador.getNombre() + " no estaba suscrito.");
        }
    }

    private void avisar(String mensaje) {
        if (suscritos.isEmpty()) {
            System.out.println("(no hay clientes suscritos, nadie recibió el aviso)");
        }
        for (Observador observador : suscritos) {
            observador.actualizar(mensaje);
        }
    }

    // ----- parte Strategy -----
    public void publicarOferta(int porcentaje) {
        descuento = new DescuentoPorcentual(porcentaje);                 // cambia la estrategia
        avisar("¡Oferta! " + porcentaje + " % de descuento en toda la tienda.");
    }

    public void terminarOferta() {
        descuento = new SinDescuento();                                  // vuelve a la estrategia normal
        avisar("La oferta terminó. Los precios vuelven a la normalidad.");
    }

    public double calcularTotal(double subtotal) {
        return descuento.aplicar(subtotal);
    }

    public String getDescuentoActual() {
        return descuento.getNombre();
    }
}
