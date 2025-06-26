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
    }

    public ArrayList<ItemFactura> getItems() {
        return items;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
