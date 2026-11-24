// Interfaz Strategy: una forma de calcular el descuento
public interface EstrategiaDescuento {

    double aplicar(double subtotal);

    String getNombre();
}
