import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorFacturacion gestor = new GestorFacturacion();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Facturación (v0.1) ---");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar producto");
            System.out.println("3. Listar clientes");
            System.out.println("4. Listar productos");
            System.out.println("5. Crear factura");

            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombreC = sc.nextLine();
                    System.out.print("CUIT: ");
                    String cuit = sc.nextLine();
                    gestor.agregarCliente(nombreC, cuit);
                    break;
                case 2:
                    System.out.print("Nombre del producto: ");
                    String nombreP = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    gestor.agregarProducto(nombreP, precio);
                    break;
                case 3:
                    gestor.listarClientes();
                    break;
                case 4:
                    gestor.listarProductos();
                    break;
                case 5:
                     if (gestor.clientes.size() == 0 || gestor.productos.size() == 0) {
                        System.out.println(" Debés cargar al menos un cliente y un producto.");
                        break;
                     }

                      // Mostrar clientes y elegir uno
                      gestor.listarClientes();
                     System.out.print("Elegí el número de cliente: ");
                        int indiceCliente = sc.nextInt();
                      Cliente cliente = gestor.clientes.get(indiceCliente);

                      Factura factura = new Factura(cliente);

                      // Agregar productos hasta que diga que no
                     String continuar;
                      do {
                     gestor.listarProductos();
                      System.out.print("Número de producto: ");
                    int indiceProd = sc.nextInt();
                      System.out.print("Cantidad: ");
                     int cantidad = sc.nextInt();
                      Producto prod = gestor.productos.get(indiceProd);

                      factura.agregarItem(prod, cantidad);

                     System.out.print("¿Agregar otro producto? (s/n): ");
                       continuar = sc.next();
                       } while (continuar.equalsIgnoreCase("s"));

                      factura.mostrarFactura();
                      factura.guardarEnArchivo();

                      break;

              case 0:
                    System.out.println(" Cerrando...");
                    break;
                default:
                    System.out.println(" Opción inválida.");
            }

        } while (opcion != 0);
        sc.close();
    }
}
