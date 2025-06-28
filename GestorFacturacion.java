import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class GestorFacturacion {
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Producto> productos = new ArrayList<>();

    public void agregarCliente(String nombre, String cuit) {
        clientes.add(new Cliente(nombre, cuit));
        System.out.println(" Cliente agregado.");
    }



    public void agregarProducto(String nombre, double precio) {
        productos.add(new Producto(nombre, precio));
        System.out.println(" Producto agregado.");
    }

    public void listarClientes() {
        System.out.println("\n Lista de Clientes:");
        for (Cliente c : clientes) {
            System.out.println(" - " + c);
        }
    }

    public void listarProductos() {
        System.out.println("\n Lista de Productos:");
        for (Producto p : productos) {
            System.out.println(" - " + p);
        }
    }
    public void listarFacturasGuardadas() {
    File carpeta = new File("facturas");
    File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".txt"));

    if (archivos == null || archivos.length == 0) {
        System.out.println(" No hay facturas guardadas.");
        return;
    }

    for (File archivo : archivos) {
        System.out.println("\n Leyendo: " + archivo.getName());
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println(" Error al leer: " + archivo.getName());
        }
    }
    }
        public Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : productos) {
        if (p.getNombre().equalsIgnoreCase(nombre)) {
            return p;
        }
    }
    return null;
    }
        public Cliente buscarClientePorNombre(String nombre) {
        for (Cliente c : clientes) {
        if (c.getNombre().equalsIgnoreCase(nombre)) {
            return c;
        }
    }
    return null;
    }
    public void guardarFactura(Factura factura) {
    String nombreArchivo = "factura_" + System.currentTimeMillis() + ".txt";

    try (java.io.PrintWriter writer = new java.io.PrintWriter(nombreArchivo)) {
        writer.println("Cliente: " + factura.getCliente().getNombre());
        writer.println("CUIT: " + factura.getCliente().getCuit());
        writer.println("----------------------------");
        for (ItemFactura item : factura.getItems()) {
            writer.println(item.getCantidad() + " x " + item.getProducto().getNombre()
                + " = $" + (item.getCantidad() * item.getProducto().getPrecio()));
        }
        writer.println("----------------------------");
        writer.printf("Subtotal: $%.2f%n", factura.calcularSubtotal());
        writer.printf("IVA (21%%): $%.2f%n", factura.calcularIVA());
        writer.printf("Total: $%.2f%n", factura.calcularTotal());
    } catch (Exception e) {
        System.out.println("Error al guardar la factura: " + e.getMessage());
    }
    }
        public List<Cliente> getClientes() {
        return clientes;
}

        public List<Producto> getProductos() {
        return productos;
}
public boolean agregarProducto(Producto producto) {
    String sql = "INSERT INTO productos(nombre, precio) VALUES(?, ?)";

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, producto.getNombre());
        pstmt.setDouble(2, producto.getPrecio());

        pstmt.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("⚠ Error al agregar producto: " + e.getMessage());
        return false;
    }
}
    public List<Producto> obtenerProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

    try (Connection conn = ConexionBD.conectar();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            double precio = rs.getDouble("precio");

            lista.add(new Producto(id, nombre, precio));
        }

        } catch (SQLException e) {
        System.out.println("⚠ Error al obtener productos: " + e.getMessage());
        }

    return lista;
}
     public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id);
        int filas = pstmt.executeUpdate();

    return filas > 0;

        } catch (SQLException e) {
        System.out.println("⚠ Error al eliminar producto: " + e.getMessage());
        return false;
        }
}
    public boolean actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, precio = ? WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getId());

            int filas = pstmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("⚠ Error al actualizar producto: " + e.getMessage());
            return false;
    }
}



}
