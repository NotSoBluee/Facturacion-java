public class Cliente {
    private final String nombre;
    private final String cuit;

    public Cliente(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }
    @Override
    public String toString() {
        return nombre + " (CUIT: " + cuit + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public String getCuit() {
        return cuit;
    }
}
