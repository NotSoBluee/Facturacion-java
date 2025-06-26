import java.util.ArrayList;

public class GestorFacturacion {
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Producto> productos = new ArrayList<>();

    public void agregarCliente(String nombre, String cuit) {
        clientes.add(new Cliente(nombre, cuit));
        System.out.println("✅ Cliente agregado.");
    }

    public void agregarProducto(String nombre, double precio) {
        productos.add(new Producto(nombre, precio));
        System.out.println("✅ Producto agregado.");
    }

    public void listarClientes() {
        System.out.println("\n📋 Lista de Clientes:");
        for (Cliente c : clientes) {
            System.out.println(" - " + c);
        }
    }

    public void listarProductos() {
        System.out.println("\n📋 Lista de Productos:");
        for (Producto p : productos) {
            System.out.println(" - " + p);
        }
    }
}
