import java.awt.*;
import javax.swing.*;

public class VentanaProducto extends JFrame {
    private JTextField campoNombre;
    private JTextField campoPrecio;
    private JButton btnAgregar;
    private JButton btnListar;
    private JTextArea areaProductos;
    private JButton btnEliminar;
    private JTextField campoEliminarId;



    private GestorFacturacion gestor;

    

    public VentanaProducto(GestorFacturacion gestor) {
        this.gestor = gestor;

        

        setTitle("Gestión de Productos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        // Campos y etiquetas
        panel.add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        panel.add(campoNombre);

        panel.add(new JLabel("Precio:"));
        campoPrecio = new JTextField();
        panel.add(campoPrecio);

        // Botón agregar
        btnAgregar = new JButton("Agregar Producto");
        panel.add(btnAgregar);
        panel.add(new JLabel());
        btnAgregar = new JButton("Agregar Producto");
        btnListar = new JButton("Listar Productos");

        panel.add(btnAgregar);
        panel.add(btnListar);
        panel.add(new JLabel("ID a eliminar:"));
        campoEliminarId = new JTextField();
        panel.add(campoEliminarId);

        btnEliminar = new JButton("Eliminar Producto");
        panel.add(btnEliminar);
        panel.add(new JLabel()); // espacio vacío para que quede alineado




        // Espacio en blanco al lado del botón
        panel.add(new JLabel());

        add(panel); // Agrega panel al frame

        areaProductos = new JTextArea(10, 30);
        areaProductos.setEditable(false);
        add(new JScrollPane(areaProductos), BorderLayout.SOUTH);


        // Acción del botón
        btnAgregar.addActionListener(e -> {

            String nombre = campoNombre.getText();
            String precioTexto = campoPrecio.getText();
            
            


            if (nombre.isEmpty() || precioTexto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Completa todos los campos.");
                return;
            }

            try {
                double precio = Double.parseDouble(precioTexto);
                Producto nuevo = new Producto(nombre, precio);
                boolean exito = gestor.agregarProducto(nuevo);

                if (exito) {
                    JOptionPane.showMessageDialog(null, "Producto agregado con éxito.");
                    campoNombre.setText("");
                    campoPrecio.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar producto.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Precio inválido.");
            }
              });
                 btnListar.addActionListener(e -> {
                  areaProductos.setText(""); // limpia antes de listar

                  for (Producto p : gestor.obtenerProductos()) {
                areaProductos.append("ID: " + p.getId() + " - " +
                             p.getNombre() + " - $" +
                             p.getPrecio() + "\n");
              }

             if (areaProductos.getText().isEmpty()) {
               areaProductos.setText("No hay productos cargados.");
             }
            });

    btnEliminar.addActionListener(e -> {
        String idTexto = campoEliminarId.getText();

       if (idTexto.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Ingresá un ID.");
            return;
       }

      try {
        int id = Integer.parseInt(idTexto);

        boolean exito = gestor.eliminarProducto(id);

        if (exito) {
            JOptionPane.showMessageDialog(null, "Producto eliminado.");
            campoEliminarId.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un producto con ese ID.");
        }

        } catch (NumberFormatException ex) {
           JOptionPane.showMessageDialog(null, "ID inválido.");
        }
        });



        setVisible(true); // Mostrar la ventana
    }
}
