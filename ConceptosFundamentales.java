/*Tu misión:

Crea los productos: Cada producto tiene un nombre, precio y cantidad.
Registra las compras: Cuando un cliente compra, se crea una transacción. 
Esta transacción guarda qué productos compró, cuánto pagó y en qué caja lo hizo.
Simula una compra: Haz que un cliente vaya a una caja, compre varios productos y pague. 
¡Muestra en pantalla todo lo que compró y cuánto pagó!*/

import java.util.ArrayList;

class Humane {

  private String nombre;
  private String apellido;
  private int dni;

  public Humane(String nombre, String apellido, int dni) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }

  public String toString() {
    return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nDNI: " + this.dni;
  }

}

class Empleado extends Humane {

  private double sueldo;

  public Empleado(String nombre, String apellido, int dni, double sueldo) {
    super(nombre, apellido, dni);
    this.sueldo = sueldo;
  }

  public String toString() {
    return "\n" + super.toString() + "\nSueldo: " + this.sueldo;
  }
}

class Caja {
  private Empleado empleado;
  private int nroCaja;

  public Caja(Empleado empleado, int nroCaja) {
    this.empleado = empleado;
    this.nroCaja = nroCaja;
  }

  public String toString() {
    return this.empleado.toString() + "\nNro de caja: " + this.nroCaja;
  }

}

class Cliente extends Humane {

  private boolean mayorista;

  public Cliente(String nombre, String apellido, int dni, boolean mayorista) {
    super(nombre, apellido, dni);
    this.mayorista = mayorista;
  }

  public String toString() {
    return "\n" + super.toString() + "\nMayorista: " + this.mayorista;
  }

}

//Crea los productos: Cada producto tiene un nombre, precio y cantidad.
class Producto{
  private String nombre;
  private double precio;
  private int cantidad;
  
  public Producto(String nombre, double precio, int cantidad){
    this.nombre = nombre;
    this.precio = precio;
    this.cantidad = cantidad;
  }

  public double calcularTotal() {
    return this.precio * this.cantidad;
  }

  public String toString() {
    return nombre + " - Precio: $" + precio + " - Cantidad: " + cantidad;
  }
}

//Registra las compras: Cuando un cliente compra, se crea una transacción.
class Transaccion{
  private Cliente cliente;
  private Caja caja;
  private ArrayList<Producto> productos;
  private double total;

  public Transaccion(Cliente cliente, Caja caja) {
    this.cliente = cliente;
    this.caja = caja;
    this.productos = new ArrayList<>();
    this.total = 0;
  }
  public void agregarProducto(Producto producto) {
    productos.add(producto);
    total += producto.calcularTotal();
  }

  public double getTotal() {
    return total;
  }

  public String toString() {
    String detalles = "Cliente: " + cliente + "\nCaja: " + caja + "\nProductos comprados:\n";
    for (Producto producto : productos) {
      detalles += producto + "\n";
    }
    detalles += "Total a pagar: $" + total;
    return detalles;
  }
}
class ConceptosFundamentales {
  public static void main(String[] args) {
    /*Simula una compra: Haz que un cliente vaya a una caja, compre varios productos y pague. 
    ¡Muestra en pantalla todo lo que compró y cuánto pagó! */
    Cliente cliente = new Cliente("Juan", "Perez", 12345678, true);
    Empleado empleado = new Empleado("Maria", "Lopez", 87654321, 1500.0);
    Caja caja = new Caja(empleado, 1);

        
    Producto producto1 = new Producto("Manzanas", 1233.0, 5);
    Producto producto2 = new Producto("Pan", 2000.0, 2);
    Producto producto3 = new Producto("Leche", 750.59, 3);

       
    Transaccion transaccion = new Transaccion(cliente, caja);
    transaccion.agregarProducto(producto1);
    transaccion.agregarProducto(producto2);
    transaccion.agregarProducto(producto3);

    System.out.println(transaccion);
  }

}
