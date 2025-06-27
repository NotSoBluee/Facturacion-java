import javax.swing.*;
import java.awt.event.*;

public class VentanaProducto extends JFrame {

    private GestorFacturacion gestor;

    public VentanaProducto(GestorFacturacion gestor) {
        this.gestor = gestor;

        setTitle("Agregar Producto");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 80, 25);
        add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(100, 20, 150, 25);
        add(txtNombre);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(20, 60, 80, 25);
        add(lblPrecio);

        JTextField txtPrecio = new JTextField();
        txtPrecio.setBounds(100, 60, 150, 25);
        add(txtPrecio);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(80, 110, 120, 30);
        add(btnAgregar);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String precioTexto = txtPrecio.getText();

                if (nombre.isEmpty() || precioTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completá todos los campos.");
                    return;
                }

                try {
                    double precio = Double.parseDouble(precioTexto);
                    gestor.agregarProducto(nombre, precio);
                    JOptionPane.showMessageDialog(null, "✅ Producto agregado correctamente.");
                    dispose(); // Cierra la ventana
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "❌ El precio debe ser un número válido.");
                }
            }
        });

        setVisible(true);
    }
}
