import java.util.List;

// Estrategias concretas. Las cuatro implementan la misma interfaz.

class SinDescuento implements EstrategiaDescuento {

    public double calcularTotal(List<Producto> productos) {
        double total = 0;
        for (Producto p : productos) {
            total = total + p.getPrecio();
        }
        return total;
    }

    public String getNombre() {
        return "Sin descuento";
    }
}

// 10 % de rebaja sobre el total, sin importar qué productos sean
class DescuentoFijo implements EstrategiaDescuento {

    public double calcularTotal(List<Producto> productos) {
        double total = 0;
        for (Producto p : productos) {
            total = total + p.getPrecio();
        }
        return total * 0.90;
    }

    public String getNombre() {
        return "Descuento fijo (10 %)";
    }
}

// Si el carrito tiene 2 o más unidades del mismo producto, esas unidades tienen 30 % de descuento
class DescuentoPorcentual implements EstrategiaDescuento {

    public double calcularTotal(List<Producto> productos) {
        double total = 0;
        for (Producto p : productos) {
            int repetidos = contarIguales(productos, p.getNombre());
            if (repetidos >= 2) {
                total = total + p.getPrecio() * 0.70;
            } else {
                total = total + p.getPrecio();
            }
        }
        return total;
    }

    private int contarIguales(List<Producto> productos, String nombre) {
        int cantidad = 0;
        for (Producto p : productos) {
            if (p.getNombre().equals(nombre)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public String getNombre() {
        return "Descuento porcentual (2 iguales = 30 %)";
    }
}

// Desde 3 productos en el carrito, el más barato tiene 50 % de descuento
class DescuentoPorcentualAcumulado implements EstrategiaDescuento {

    public double calcularTotal(List<Producto> productos) {
        double total = 0;
        double masBarato = productos.isEmpty() ? 0 : productos.get(0).getPrecio();
        for (Producto p : productos) {
            total = total + p.getPrecio();
            if (p.getPrecio() < masBarato) {
                masBarato = p.getPrecio();
            }
        }
        if (productos.size() >= 3) {
            total = total - masBarato * 0.50;
        }
        return total;
    }

    public String getNombre() {
        return "Descuento acumulado (3 o más = 50 % al más barato)";
    }
}
