import java.util.*;
import javax.swing.*;

public class VentanaFactura extends JFrame {

    private GestorFacturacion gestor;
    private JComboBox<String> comboClientes;
    private JComboBox<String> comboProductos;
    private JTextField txtCantidad;
    private JTextArea areaFactura;
    private ArrayList<ItemFactura> itemsTemp;

    public VentanaFactura(GestorFacturacion gestor) {
        this.gestor = gestor;
        this.itemsTemp = new ArrayList<>();

        setTitle("Crear Factura");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Cliente
        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(20, 20, 80, 25);
        add(lblCliente);

        comboClientes = new JComboBox<>();
        for (Cliente c : gestor.getClientes()) {
            comboClientes.addItem(c.getNombre());
        }
        comboClientes.setBounds(100, 20, 200, 25);
        add(comboClientes);

        // Producto
        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(20, 60, 80, 25);
        add(lblProducto);

        comboProductos = new JComboBox<>();
        for (Producto p : gestor.getProductos()) {
            comboProductos.addItem(p.getNombre());
        }
        comboProductos.setBounds(100, 60, 200, 25);
        add(comboProductos);

        // Cantidad
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(20, 100, 80, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(100, 100, 200, 25);
        add(txtCantidad);

        JButton btnAgregarItem = new JButton("Agregar ítem");
        btnAgregarItem.setBounds(320, 100, 130, 25);
        add(btnAgregarItem);

        // Factura
        areaFactura = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaFactura);
        scroll.setBounds(20, 140, 430, 150);
        add(scroll);

        JButton btnFinalizar = new JButton("Generar Factura");
        btnFinalizar.setBounds(150, 310, 180, 30);
        add(btnFinalizar);

        btnAgregarItem.addActionListener(e -> agregarItem());
        btnFinalizar.addActionListener(e -> generarFactura());

        setVisible(true);
    }

    private void agregarItem() {
        String productoNombre = (String) comboProductos.getSelectedItem();
        String cantidadTexto = txtCantidad.getText();

        if (productoNombre == null || cantidadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione producto y cantidad.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadTexto);
            Producto producto = gestor.buscarProductoPorNombre(productoNombre);
            if (producto != null) {
                itemsTemp.add(new ItemFactura(producto, cantidad));
                areaFactura.append("- " + cantidad + " x " + producto.getNombre() + " = $" + (producto.getPrecio() * cantidad) + "\n");
                txtCantidad.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida.");
        }
    }

    private void generarFactura() {
        String clienteNombre = (String) comboClientes.getSelectedItem();
        Cliente cliente = gestor.buscarClientePorNombre(clienteNombre);

        if (cliente == null || itemsTemp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Faltan datos para generar factura.");
            return;
        }

        Factura factura = new Factura(cliente);
        for (ItemFactura item : itemsTemp) {
            factura.agregarItem(item.getProducto(), item.getCantidad());

        }

        gestor.guardarFactura(factura);
        JOptionPane.showMessageDialog(this, "✅ Factura generada y guardada.");
        dispose();
    }
}
