import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Factura {
    private final Cliente cliente;
    private final ArrayList<ItemFactura> items = new ArrayList<>();

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarItem(Producto producto, int cantidad) {
        items.add(new ItemFactura(producto, cantidad));
    }

   public void mostrarFactura() {
    System.out.println("\n🧾 Factura para " + cliente);
    for (ItemFactura item : items) {
        System.out.println(" - " + item);
    }

    System.out.printf("\nSubtotal: $%.2f\n", calcularSubtotal());
    System.out.printf("IVA (21%%): $%.2f\n", calcularIVA());
    System.out.printf("TOTAL: $%.2f\n", calcularTotal());
}


    public ArrayList<ItemFactura> getItems() {
        return items;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public double calcularSubtotal() {
    double subtotal = 0;
    for (ItemFactura item : items) {
        subtotal += item.getSubtotal();
    }
    return subtotal;
    }

    public double calcularIVA() {
    return calcularSubtotal() * 0.21;
    }

    public double calcularTotal() {
    return calcularSubtotal() + calcularIVA();
    }
    public void guardarEnArchivo() {
    // ✅ Línea 1: asegurarse que exista la carpeta
    new java.io.File("facturas").mkdirs();

    // ✅ Línea 2: nombrar el archivo dentro de esa carpeta
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    String fechaHora = LocalDateTime.now().format(dtf);
    String nombreArchivo = "facturas/factura_" + fechaHora + ".txt";

    try (FileWriter writer = new FileWriter(nombreArchivo)) {
        writer.write("🧾 Factura para " + cliente + "\n\n");
        for (ItemFactura item : items) {
            writer.write(item + "\n");
        }
        writer.write(String.format("\nSubtotal: $%.2f\n", calcularSubtotal()));
        writer.write(String.format("IVA (21%%): $%.2f\n", calcularIVA()));
        writer.write(String.format("TOTAL: $%.2f\n", calcularTotal()));
        System.out.println("📁 Factura guardada como: " + nombreArchivo);
    } catch (IOException e) {
        System.out.println(" Error al guardar la factura.");
    }
}



    
}
