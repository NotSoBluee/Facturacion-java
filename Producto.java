public class Producto {
    private final String nombre;
    private final double precio;
    private final int id;

    public Producto(int id, String nombre, double precio) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
}

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public int getId() {
        return this.id;
    }

}
