// Estrategias concretas

class SinDescuento implements EstrategiaDescuento {

    public double aplicar(double subtotal) {
        return subtotal;
    }

    public String getNombre() {
        return "Sin descuento";
    }
}

class DescuentoPorcentual implements EstrategiaDescuento {
    private int porcentaje;

    public DescuentoPorcentual(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double aplicar(double subtotal) {
        return subtotal * (100 - porcentaje) / 100.0;
    }

    public String getNombre() {
        return "Oferta del " + porcentaje + " %";
    }
}
