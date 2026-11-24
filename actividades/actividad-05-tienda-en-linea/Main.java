import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Tienda en línea que combina los tres patrones:
//   Observer -> los clientes suscritos reciben las ofertas (clases Tienda y Cliente)
//   Strategy -> la oferta cambia el descuento que se aplica al total (clase Tienda)
//   Command  -> agregar y quitar productos del carrito se puede deshacer (HistorialDeComandos)
public class Main {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Producto[] catalogo = {
            new Producto("Laptop", 2500.00),
            new Producto("Mouse", 50.00),
            new Producto("Teclado", 120.00),
            new Producto("Monitor", 800.00),
            new Producto("Audífonos", 90.00)
        };

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Ana"));
        clientes.add(new Cliente("Luis"));
        clientes.add(new Cliente("Marta"));

        Tienda tienda = new Tienda();
        Carrito carrito = new Carrito();
        HistorialDeComandos historial = new HistorialDeComandos();

        int opcion = -1;
        while (opcion != 0) {
            System.out.println();
            System.out.println("===== TIENDA EN LÍNEA =====");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Agregar un producto al carrito");
            System.out.println("3. Quitar un producto del carrito");
            System.out.println("4. Deshacer la última acción");
            System.out.println("5. Ver carrito y total a pagar");
            System.out.println("6. Suscribir o desuscribir un cliente");
            System.out.println("7. Publicar una oferta");
            System.out.println("8. Terminar la oferta");
            System.out.println("0. Salir");
            opcion = leerNumero("Elija una opción: ");

            if (opcion == 1) {
                mostrarCatalogo(catalogo);
            } else if (opcion == 2) {
                Producto p = elegirProducto(catalogo);
                if (p != null) {
                    historial.ejecutar(new ComandoAgregar(carrito, p));
                }
            } else if (opcion == 3) {
                Producto p = elegirProducto(catalogo);
                if (p != null && !carrito.contiene(p)) {
                    System.out.println(p.getNombre() + " no está en el carrito.");
                } else if (p != null) {
                    historial.ejecutar(new ComandoQuitar(carrito, p));
                }
            } else if (opcion == 4) {
                historial.deshacerUltimo();
            } else if (opcion == 5) {
                verCarrito(carrito, tienda);
            } else if (opcion == 6) {
                suscripcion(clientes, tienda);
            } else if (opcion == 7) {
                int porcentaje = leerNumero("Porcentaje de descuento (1 a 90): ");
                if (porcentaje >= 1 && porcentaje <= 90) {
                    tienda.publicarOferta(porcentaje);
                } else {
                    System.out.println("Porcentaje no válido.");
                }
            } else if (opcion == 8) {
                tienda.terminarOferta();
            } else if (opcion != 0) {
                System.out.println("Opción no válida.");
            }
        }
        System.out.println("Gracias por su visita.");
    }

    static void mostrarCatalogo(Producto[] catalogo) {
        for (int i = 0; i < catalogo.length; i++) {
            System.out.println("   " + (i + 1) + ". " + catalogo[i].getNombre()
                    + " - S/ " + String.format("%.2f", catalogo[i].getPrecio()));
        }
    }

    static Producto elegirProducto(Producto[] catalogo) {
        mostrarCatalogo(catalogo);
        int numero = leerNumero("Producto: ");
        if (numero < 1 || numero > catalogo.length) {
            System.out.println("Ese producto no existe.");
            return null;
        }
        return catalogo[numero - 1];
    }

    static void verCarrito(Carrito carrito, Tienda tienda) {
        if (carrito.getProductos().isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        for (Producto p : carrito.getProductos()) {
            System.out.println("   - " + p.getNombre() + " S/ " + String.format("%.2f", p.getPrecio()));
        }
        double subtotal = carrito.subtotal();
        double total = tienda.calcularTotal(subtotal);
        System.out.println("Descuento actual: " + tienda.getDescuentoActual());
        System.out.println("Subtotal:      S/ " + String.format("%.2f", subtotal));
        System.out.println("TOTAL A PAGAR: S/ " + String.format("%.2f", total));
    }

    static void suscripcion(List<Cliente> clientes, Tienda tienda) {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("   " + (i + 1) + ". " + clientes.get(i).getNombre());
        }
        int numero = leerNumero("Cliente: ");
        if (numero < 1 || numero > clientes.size()) {
            System.out.println("Ese cliente no existe.");
            return;
        }
        int accion = leerNumero("1. Suscribir   2. Desuscribir: ");
        if (accion == 1) {
            tienda.suscribir(clientes.get(numero - 1));
        } else if (accion == 2) {
            tienda.desuscribir(clientes.get(numero - 1));
        } else {
            System.out.println("Opción no válida.");
        }
    }

    static int leerNumero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
