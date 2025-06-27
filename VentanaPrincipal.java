import javax.swing.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {

    private GestorFacturacion gestor;

    public VentanaPrincipal(GestorFacturacion gestor) {
        this.gestor = gestor;

        setTitle("Sistema de Facturación");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnCliente = new JButton("Agregar Cliente");
        btnCliente.setBounds(100, 30, 200, 30);
        btnCliente.addActionListener(e -> mostrarVentanaCliente());
        add(btnCliente);

        JButton btnProducto = new JButton("Agregar Producto");
        btnProducto.setBounds(100, 70, 200, 30);
        btnProducto.addActionListener(e -> mostrarVentanaProducto());
        add(btnProducto);

        JButton btnFactura = new JButton("Crear Factura");
        btnFactura.setBounds(100, 110, 200, 30);
        btnFactura.addActionListener(e -> mostrarVentanaFactura());
        add(btnFactura);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(100, 160, 200, 30);
        btnSalir.addActionListener(e -> System.exit(0));
        add(btnSalir);

        setVisible(true);
    }

    private void mostrarVentanaCliente() {
        new VentanaCliente(gestor);
    }

    private void mostrarVentanaProducto() {
        new VentanaProducto(gestor);
    }

    private void mostrarVentanaFactura() {
        new VentanaFactura(gestor);
    }
}
