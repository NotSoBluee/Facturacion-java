#  Sistema de Facturación en Java – Versión 0.1

## Descripción
Este proyecto es un sistema de facturación simple hecho en Java.  
Se encuentra en desarrollo y será construido por versiones. Esta es la **v0.1**, que incluye:

- Alta de productos
- Alta de clientes
- Listado de ambos
- Menú interactivo por consola

## Estructura actual

- `Producto.java` → Clase para crear productos con nombre y precio.
- `Cliente.java` → Clase para registrar clientes con nombre y CUIT.
- `GestorFacturacion.java` → Maneja listas y operaciones sobre productos y clientes.
- `Main.java` → Menú de consola interactivo.

## Versión 0.1 – Funcionalidad

# Sistema de Facturación en Java

## Descripción

Este proyecto simula un sistema de facturación simple.  
Está siendo desarrollado en versiones, agregando funcionalidades reales paso a paso.  


---

##  Versión 0.2 Clases actuales

| Clase            | Descripción                                       |
|------------------|---------------------------------------------------|
| `Producto`       | Representa un producto con nombre y precio        |
| `Cliente`        | Representa un cliente con nombre y CUIT           |
| `GestorFacturacion` | Permite agregar/listar productos y clientes     |
| `ItemFactura`    | Relaciona producto + cantidad dentro de factura   |
| `Factura`        | Contiene cliente y varios `ItemFactura`           |
| `Main`           | Menú por consola para operar                      |

---

 Nueva clase `Factura` con múltiples productos  
 Permite elegir un cliente  
 Permite agregar productos con cantidad  
 Muestra la factura en consola  

---

### Versión 0.3
- Se agregan métodos para:
  - Calcular subtotal
  - Calcular IVA (21%)
  - Calcular total
- El método `mostrarFactura()` ahora imprime todo el desglose completo

---


##  Cómo ejecutar

Compilar:

```bash
javac *.java

Ejecutar:
java Main
