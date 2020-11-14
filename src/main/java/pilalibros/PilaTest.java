package pilalibros;

import pilalibros.Pila;
import pilalibros.Libro;

public class PilaTest {
    public static void main(String[] args) {
        Pila libros = new Pila(5);

        System.out.println(libros.isEmpty());

        libros.push(new Libro("Harry  Potter", "Tapa Anaranjada", "Pepe", "Planeta", 2.50, 300));
        libros.push(new Libro("Maycol Potter", "Tapa Roja","Sorano","Careta", 3.50, 500));
        libros.push(new Libro("Peras  Potter", "Tapa Verde", "Vargas Calderon","Sol",4.50, 200));
        libros.push(new Libro("Isaac  Potter", "Tapa Negra", "Pepe Borges","Ancient",23.50, 100));
        libros.push(new Libro("Leon  Potter", "Tapa Amarilla","Karlos kk","Matilde", 23.50, 100));

        System.out.println("====================== peek ===========================");
        Libro peek = libros.peek();
        if (peek != null)
            System.out.println(""+peek.getNombre());


        System.out.println("====================== pop & print ===========================");
        //System.out.println(productos.getCima());;// UNA VEZ EJECUTA Y POPEADO NO SE PUEDE REPETIR EL SCRIPT => PROBELMA CON EL IDENTITY
        libros.pop();

        //Producto peek = productos.peek();
        if (peek != null)
            System.out.println(""+peek.getNombre());

        Libro[] PilaProducto = libros.elementosPila();
        if (peek != null) {//si la pila esta vacia
            for (Libro producto : PilaProducto) {
                if (producto == null)//si un elemento de la pila tiene asignado un null
                    continue;
                else
                    System.out.println(producto.getNombre() + " " + producto.getDescripcion());
            }
        }
        System.out.println("====================== print./ ===========================");
        libros.imprimir();
    }
}
