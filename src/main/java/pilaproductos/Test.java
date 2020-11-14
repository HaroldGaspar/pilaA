package pilaproductos;

import connectiondb.ConnectionDB;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import daos.ProductoDAOImpl;
public class Test {
        public static void main(final String[] args) {
        final ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl();
        
        //ConnectionDB.createInstance();
/*
            productoDAOImpl.insert(new Producto("Mandarinas", "Anaranjadas", 2.50, 300));
            productoDAOImpl.insert(new Producto("Manzanas", "Rojas", 3.50, 500));
            productoDAOImpl.insert(new Producto("Peras", "Verdes", 4.50, 200));
            productoDAOImpl.insert(new Producto("Sandias", "Verdes y rojas", 23.50, 100));
            productoDAOImpl.insert(new Producto("Lemon", "Amarillos", 23.50, 100));
*/
        Producto reTest = productoDAOImpl.selectById(5);
/*
        System.out.println("" + reTest);
        reTest.setNombre("Limon");
        productoDAOImpl.update(reTest);
        List<Producto> productos = productoDAOImpl.selectAll();
            for (Producto producto: productos) {
                System.out.println(producto.getNombre() + " " + producto.getDescripcion());
            }
 */

        productoDAOImpl.delete(reTest);
            List<Producto> productos = productoDAOImpl.selectAll();
            for (Producto producto: productos) {
                System.out.println(producto.getNombre() + " " + producto.getDescripcion());
            }
        }
}
