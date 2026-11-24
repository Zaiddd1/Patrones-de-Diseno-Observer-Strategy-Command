import java.util.List;

// Interfaz Strategy: cada tipo de descuento calcula el total de una forma distinta
public interface EstrategiaDescuento {

    double calcularTotal(List<Producto> productos);

    String getNombre();
}
