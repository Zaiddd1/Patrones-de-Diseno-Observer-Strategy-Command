// Comandos concretos: cada uno es una acción sobre el carrito convertida en objeto

class ComandoAgregar implements Comando {
    private Carrito carrito;
    private Producto producto;

    public ComandoAgregar(Carrito carrito, Producto producto) {
        this.carrito = carrito;
        this.producto = producto;
    }

    public void ejecutar() {
        carrito.agregar(producto);
    }

    public void deshacer() {
        carrito.quitar(producto);       // lo contrario de agregar
    }

    public String getDescripcion() {
        return "agregar " + producto.getNombre();
    }
}

class ComandoQuitar implements Comando {
    private Carrito carrito;
    private Producto producto;

    public ComandoQuitar(Carrito carrito, Producto producto) {
        this.carrito = carrito;
        this.producto = producto;
    }

    public void ejecutar() {
        carrito.quitar(producto);
    }

    public void deshacer() {
        carrito.agregar(producto);      // lo contrario de quitar
    }

    public String getDescripcion() {
        return "quitar " + producto.getNombre();
    }
}
