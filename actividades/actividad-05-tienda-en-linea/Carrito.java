import java.util.ArrayList;
import java.util.List;

// Receptor del patrón Command: el carrito de compras. Aquí se hace el trabajo de verdad.
public class Carrito {

    private List<Producto> productos = new ArrayList<>();

    public void agregar(Producto producto) {
        productos.add(producto);
    }

    // quita la primera unidad de ese producto; devuelve false si no estaba en el carrito
    public boolean quitar(Producto producto) {
        return productos.remove(producto);
    }

    public boolean contiene(Producto producto) {
        return productos.contains(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double subtotal() {
        double total = 0;
        for (Producto p : productos) {
            total = total + p.getPrecio();
        }
        return total;
    }
}
