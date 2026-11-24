// Receptor: es el que hace el trabajo de verdad (cambia el volumen, el canal, etc.)
public class Televisor {

    private boolean encendido = false;
    private int volumen = 10;
    private int canal = 1;

    public void encenderApagar() {
        encendido = !encendido;
        if (encendido) {
            System.out.println("El televisor se encendió.");
        } else {
            System.out.println("El televisor se apagó.");
        }
        mostrarEstado();
    }

    public void subirVolumen() {
        if (!estaEncendido()) {
            return;
        }
        if (volumen < 100) {
            volumen = volumen + 5;
        }
        System.out.println("Volumen subido.");
        mostrarEstado();
    }

    public void bajarVolumen() {
        if (!estaEncendido()) {
            return;
        }
        if (volumen > 0) {
            volumen = volumen - 5;
        }
        System.out.println("Volumen bajado.");
        mostrarEstado();
    }

    public void canalSiguiente() {
        if (!estaEncendido()) {
            return;
        }
        canal = canal + 1;
        if (canal > 20) {
            canal = 1;                  // después del 20 vuelve al 1
        }
        System.out.println("Cambió al canal siguiente.");
        mostrarEstado();
    }

    public void canalAnterior() {
        if (!estaEncendido()) {
            return;
        }
        canal = canal - 1;
        if (canal < 1) {
            canal = 20;                 // antes del 1 está el 20
        }
        System.out.println("Cambió al canal anterior.");
        mostrarEstado();
    }

    // si el televisor está apagado, los botones (menos el de encender) no hacen nada
    private boolean estaEncendido() {
        if (!encendido) {
            System.out.println("El televisor está apagado. Enciéndalo primero.");
        }
        return encendido;
    }

    private void mostrarEstado() {
        if (encendido) {
            System.out.println("   Estado: ENCENDIDO | Canal " + canal + " | Volumen " + volumen);
        } else {
            System.out.println("   Estado: APAGADO");
        }
    }
}
