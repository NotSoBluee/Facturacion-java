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

## Versión 0.3
- Se agregan métodos para:
  - Calcular subtotal
  - Calcular IVA (21%)
  - Calcular total
- El método `mostrarFactura()` ahora imprime todo el desglose completo

---
##  Versión 0.4
- Guardar la factura generada en archivo `.txt`  
- Archivo con timestamp y estructura legible

---
##  Versión 0.5
- Nueva opción en el menú: ver facturas anteriores  
- Lee todos los archivos `.txt` guardados en carpeta `/facturas`  
- Muestra el contenido en consola

**Versión actual: 1.0**  
GUI
---

## Descripción

Este es un sistema de facturación simple desarrollado en Java, que permite:

- Registrar productos
- Registrar clientes
- Crear facturas con múltiples ítems
- Calcular subtotal, IVA (21%) y total
- Guardar las facturas en archivos `.txt`
- Interfaz gráfica construida con `Swing`

---

- Java 17+
- Swing (interfaz gráfica)
- Git y GitHub para control de versiones
- Visual Studio Code

## v 1.1 NO Funcional

agregue un par de cosas para completar el crud y estoy teniendo una tanda de problemitas
nada que no pueda manejar pero subo esto para tener un checkpoint 

## V 1.2 Funcional! 

- Crud solo falta editar producto!
con todoas sus debidas ventanas menos esa jajaja

# Versión 1.3 Cerramos

Se puede:

- [x] Crear producto con nombre y precio
- [x] Listar productos guardados en la base de datos
- [x] Eliminar producto por ID
- [x] Editar producto existente por ID
- [x] Interfaz gráfica con campos y botones funcionales

---
# Version Final.

Decido terminar el proyecto aqui(por ahora)y encarar otros proyectos.
cosas a arreglar. el layout de agregar producto!

##  Cómo ejecutar

Compilar:

```bash
javac *.java

Ejecutar:
java -cp ".;sqlite-jdbc-3.36.0.3.jar" Main 