import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Menú interactivo: el usuario arma el carrito, elige la estrategia y calcula el precio final
public class Main {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // catálogo de la tienda
        Producto[] catalogo = {
            new Producto("Laptop", 2500.00),
            new Producto("Mouse", 50.00),
            new Producto("Teclado", 120.00),
            new Producto("Monitor", 800.00),
            new Producto("Audífonos", 90.00)
        };

        // las cuatro estrategias que se pueden elegir
        EstrategiaDescuento[] estrategias = {
            new SinDescuento(),
            new DescuentoFijo(),
            new DescuentoPorcentual(),
            new DescuentoPorcentualAcumulado()
        };

        List<Producto> carrito = new ArrayList<>();
        CalculadoraDePrecios calculadora = new CalculadoraDePrecios();

        int opcion = -1;
        while (opcion != 0) {
            System.out.println();
            System.out.println("===== CALCULADORA DE PRECIOS =====");
            System.out.println("1. Agregar un producto al carrito");
            System.out.println("2. Ver el carrito");
            System.out.println("3. Elegir la estrategia de descuento");
            System.out.println("4. Calcular el precio final");
            System.out.println("5. Vaciar el carrito");
            System.out.println("0. Salir");
            System.out.println("Estrategia actual: " + calculadora.getEstrategia().getNombre());
            opcion = leerNumero("Elija una opción: ");

            if (opcion == 1) {
                for (int i = 0; i < catalogo.length; i++) {
                    System.out.println("   " + (i + 1) + ". " + catalogo[i].getNombre()
                            + " - S/ " + String.format("%.2f", catalogo[i].getPrecio()));
                }
                int numero = leerNumero("Producto: ");
                if (numero >= 1 && numero <= catalogo.length) {
                    carrito.add(catalogo[numero - 1]);
                    System.out.println("Se agregó " + catalogo[numero - 1].getNombre() + ".");
                } else {
                    System.out.println("Ese producto no existe.");
                }
            } else if (opcion == 2) {
                verCarrito(carrito);
            } else if (opcion == 3) {
                for (int i = 0; i < estrategias.length; i++) {
                    System.out.println("   " + (i + 1) + ". " + estrategias[i].getNombre());
                }
                int numero = leerNumero("Estrategia: ");
                if (numero >= 1 && numero <= estrategias.length) {
                    calculadora.setEstrategia(estrategias[numero - 1]);
                    System.out.println("Estrategia elegida: " + estrategias[numero - 1].getNombre());
                } else {
                    System.out.println("Esa estrategia no existe.");
                }
            } else if (opcion == 4) {
                calcular(calculadora, carrito);
            } else if (opcion == 5) {
                carrito.clear();
                System.out.println("El carrito quedó vacío.");
            } else if (opcion != 0) {
                System.out.println("Opción no válida.");
            }
        }
        System.out.println("Fin del programa.");
    }

    static void verCarrito(List<Producto> carrito) {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        for (Producto p : carrito) {
            System.out.println("   - " + p.getNombre() + " S/ " + String.format("%.2f", p.getPrecio()));
        }
    }

    static void calcular(CalculadoraDePrecios calculadora, List<Producto> carrito) {
        if (carrito.isEmpty()) {
            System.out.println("Agregue productos antes de calcular.");
            return;
        }
        double subtotal = new SinDescuento().calcularTotal(carrito);
        double total = calculadora.calcularTotal(carrito);
        System.out.println("Estrategia: " + calculadora.getEstrategia().getNombre());
        System.out.println("Subtotal:   S/ " + String.format("%.2f", subtotal));
        System.out.println("Descuento:  S/ " + String.format("%.2f", subtotal - total));
        System.out.println("PRECIO FINAL: S/ " + String.format("%.2f", total));
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
