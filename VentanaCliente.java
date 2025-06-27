import javax.swing.*;
import java.awt.event.*;

public class VentanaCliente extends JFrame {

    private GestorFacturacion gestor;

    public VentanaCliente(GestorFacturacion gestor) {
        this.gestor = gestor;

        setTitle("Agregar Cliente");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 80, 25);
        add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(100, 20, 150, 25);
        add(txtNombre);

        JLabel lblCuit = new JLabel("CUIT:");
        lblCuit.setBounds(20, 60, 80, 25);
        add(lblCuit);

        JTextField txtCuit = new JTextField();
        txtCuit.setBounds(100, 60, 150, 25);
        add(txtCuit);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(80, 110, 120, 30);
        add(btnAgregar);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String cuit = txtCuit.getText();

                if (nombre.isEmpty() || cuit.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Completá todos los campos.");
                    return;
                }

                gestor.agregarCliente(nombre, cuit);
                JOptionPane.showMessageDialog(null, "✅ Cliente agregado correctamente.");
                dispose(); // Cierra la ventana
            }
        });

        setVisible(true);
    }
}
