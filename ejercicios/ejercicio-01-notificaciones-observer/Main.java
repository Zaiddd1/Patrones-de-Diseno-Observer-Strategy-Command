import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Menú para suscribir y desuscribir usuarios en cualquier momento y publicar notificaciones
public class Main {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // usuarios registrados en la tienda
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Ana"));
        usuarios.add(new Usuario("Luis"));
        usuarios.add(new Usuario("Marta"));
        usuarios.add(new Usuario("Pedro"));

        CentroDeNotificaciones centro = new CentroDeNotificaciones();
        centro.suscribir(usuarios.get(0));      // Ana y Luis empiezan suscritos
        centro.suscribir(usuarios.get(1));

        int opcion = -1;
        while (opcion != 0) {
            System.out.println();
            System.out.println("===== SISTEMA DE NOTIFICACIONES =====");
            System.out.println("1. Suscribir un usuario");
            System.out.println("2. Desuscribir un usuario");
            System.out.println("3. Publicar una notificación");
            System.out.println("4. Ver las notificaciones de un usuario");
            System.out.println("5. Ver quiénes están suscritos");
            System.out.println("0. Salir");
            opcion = leerNumero("Elija una opción: ");

            if (opcion == 1) {
                Usuario u = elegirUsuario(usuarios);
                if (u != null) {
                    centro.suscribir(u);
                }
            } else if (opcion == 2) {
                Usuario u = elegirUsuario(usuarios);
                if (u != null) {
                    centro.desuscribir(u);
                }
            } else if (opcion == 3) {
                publicar(centro);
            } else if (opcion == 4) {
                Usuario u = elegirUsuario(usuarios);
                if (u != null) {
                    verHistorial(u);
                }
            } else if (opcion == 5) {
                System.out.print("Suscritos:");
                for (Observador o : centro.getSuscritos()) {
                    System.out.print(" " + o.getNombre());
                }
                System.out.println();
            } else if (opcion != 0) {
                System.out.println("Opción no válida.");
            }
        }
        System.out.println("Fin del programa.");
    }

    static void publicar(CentroDeNotificaciones centro) {
        System.out.println("Tipo: 1. Promoción   2. Actualización de producto");
        int tipo = leerNumero("Elija el tipo: ");
        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo no válido.");
            return;
        }
        System.out.print("Escriba el mensaje: ");
        String mensaje = teclado.nextLine().trim();
        if (mensaje.isEmpty()) {
            System.out.println("El mensaje no puede estar vacío.");
            return;
        }
        String nombreTipo = (tipo == 1) ? "Promoción" : "Actualización de producto";
        centro.publicar(new Notificacion(nombreTipo, mensaje));
    }

    static void verHistorial(Usuario usuario) {
        System.out.println("Notificaciones de " + usuario.getNombre() + ":");
        if (usuario.getRecibidas().isEmpty()) {
            System.out.println("   (todavía no recibió ninguna)");
        }
        for (Notificacion n : usuario.getRecibidas()) {
            System.out.println("   - " + n);
        }
    }

    static Usuario elegirUsuario(List<Usuario> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + ". " + usuarios.get(i).getNombre());
        }
        int numero = leerNumero("Elija el usuario: ");
        if (numero < 1 || numero > usuarios.size()) {
            System.out.println("Ese usuario no existe.");
            return null;
        }
        return usuarios.get(numero - 1);
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
