public class Producto {
    private int id;
    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
    this.nombre = nombre;
    this.precio = precio;
}

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

    public void setId(int id) {
        this.id = id;
    }

}
