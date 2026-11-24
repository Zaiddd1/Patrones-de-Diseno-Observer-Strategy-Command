import java.util.List;

// Contexto: guarda la estrategia elegida y se la pide cuando hay que calcular
public class CalculadoraDePrecios {

    private EstrategiaDescuento estrategia = new SinDescuento();

    // aquí se cambia la estrategia mientras el programa está funcionando
    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public EstrategiaDescuento getEstrategia() {
        return estrategia;
    }

    public double calcularTotal(List<Producto> productos) {
        return estrategia.calcularTotal(productos);
    }
}
