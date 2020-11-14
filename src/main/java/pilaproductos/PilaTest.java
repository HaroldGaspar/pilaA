package pilaproductos;

import pilaproductos.Pila;
import pilaproductos.Producto;

public class PilaTest {
    public static void main(String[] args) {
        Pila productos = new Pila(5);

        System.out.println(productos.isEmpty());

        productos.push(new Producto("Mandarinas", "Anaranjadas", 2.50, 300));
        productos.push(new Producto("Manzanas", "Rojas", 3.50, 500));
        productos.push(new Producto("Peras", "Verdes", 4.50, 200));
        productos.push(new Producto("Sandias", "Verdes y rojas", 23.50, 100));
        productos.push(new Producto("Lemon", "Amarillos", 23.50, 100));

        System.out.println("====================== peek ===========================");
        Producto peek = productos.peek();
        if (peek != null)
            System.out.println(""+peek.getNombre());


        System.out.println("====================== pop & print ===========================");
        //System.out.println(productos.getCima());;// UNA VEZ EJECUTA Y POPEADO NO SE PUEDE REPETIR EL SCRIPT => PROBELMA CON EL IDENTITY
        productos.pop();

        //Producto peek = productos.peek();
        if (peek != null)
            System.out.println(""+peek.getNombre());

        Producto[] PilaProducto = productos.elementosPila();
        if (peek != null) {//si la pila esta vacia
            for (Producto producto : PilaProducto) {
                if (producto == null)//si un elemento de la pila tiene asignado un null
                    continue;
                else
                    System.out.println(producto.getNombre() + " " + producto.getDescripcion());
            }
        }
        System.out.println("====================== print./ ===========================");
        productos.imprimir();
    }
}
