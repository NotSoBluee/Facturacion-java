
public class Main {
    public static void main(String[] args) {
     ConexionBD.BDInicializador.crearTablas();
       
        GestorFacturacion gestor = new GestorFacturacion();
       
        new VentanaPrincipal(gestor);
    }

}
