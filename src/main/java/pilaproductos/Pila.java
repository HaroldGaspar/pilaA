
package pilaproductos;

import daos.ProductoDAOImpl;

import java.util.List;

public class Pila {
    private Producto[] productos;
    private int cantidadDeElementos;
    private int cima;
    final ProductoDAOImpl productoDAOImpl;
    
    public Pila(int cantidadDeElementos) {
        productoDAOImpl = new ProductoDAOImpl();//connectar pila a sql server
        this.cantidadDeElementos = cantidadDeElementos;
        this.cima = productoDAOImpl.selectAll().size();

        //definir productos[]
        this.productos = new Producto[cantidadDeElementos];
        if (cima != 0) {
            List<Producto> productLis = productoDAOImpl.selectAll();
            int i=0;
            for (Producto producto: productLis) {
                productos[i] = producto;
                i++;
            }
        }

    }

    public int getCima() {
        return cima;
    }

    public boolean isEmpty() {
        return (cima == 0)? true : false;
    }
    
    public void push(Producto dato) {
        if (cima < cantidadDeElementos) {
            productoDAOImpl.insert(dato);

            //update pila
            productos[cima] = dato;
            ++cima;
            System.out.println("[push executed]");
        }
        else {
            System.out.println("La pila ya se encuentra llena");
        }
    }
    
    public Producto peek() {
        if (cima == 0) {
            System.out.println("No hay datos en la pila");
            return null;
        }else {
            return productoDAOImpl.selectById(cima);
        }
    }
    
    public void pop() {
        if (cima == 0) {
            System.out.println("La pila se encuentra vacia");
        }
        else {
            productoDAOImpl.delete(productoDAOImpl.selectById(cima));

            //update pila
            productos[cima-1]= null;//indice
            --cima;
            System.out.println("[pop executed]");
        }
    }
    
    public Producto[] elementosPila() {
        return productos;
    }
    
    public void imprimir() {
        if (cima == 0)
            System.out.println("No hay elementos en la pila");
        else {
            for (Producto producto : productos) {
                //Evitar error por procesar null, al usar pop
                if (producto == null)
                    continue;
                else
                    System.out.println("" + producto.getNombre());
            }
        }
    }

}
