package pilalibros;

import daos.LibroDAOImpl;
import daos.ProductoDAOImpl;
import pilaproductos.Producto;

import java.util.List;

public class Pila {
    private Libro[] libros;
    private int cantidadDeElementos;
    private int cima;
    final LibroDAOImpl libroDAOImpl;

    public Pila(int cantidadDeElementos) {
        libroDAOImpl = new LibroDAOImpl();//connectar pila a sql server
        this.cantidadDeElementos = cantidadDeElementos;
        this.cima = libroDAOImpl.selectAll().size();

        //definir libros[]
        this.libros = new Libro[cantidadDeElementos];
        if (cima != 0) {
            List<Libro> bookList = libroDAOImpl.selectAll();
            int i=0;
            for (Libro libro: bookList) {
                libros[i] = libro;
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

    public void push(Libro dato) {
        if (cima < cantidadDeElementos) {
            libroDAOImpl.insert(dato);

            //update pila
            libros[cima] = dato;
            ++cima;
            System.out.println("[push executed]");
        }
        else {
            System.out.println("La pila ya se encuentra llena");
        }
    }

    public Libro peek() {
        if (cima == 0) {
            System.out.println("No hay datos en la pila");
            return null;
        }else {
            return libroDAOImpl.selectById(cima);
        }
    }

    public void pop() {
        if (cima == 0) {
            System.out.println("La pila se encuentra vacia");
        }
        else {
            libroDAOImpl.delete(libroDAOImpl.selectById(cima));

            //update pila
            libros[cima-1]= null;//indice
            --cima;
            System.out.println("[pop executed]");
        }
    }

    public Libro[] elementosPila() {
        return libros;
    }

    public void imprimir() {
        if (cima == 0)
            System.out.println("No hay elementos en la pila");
        else {
            for (Libro libro : libros) {
                //Evitar error por procesar null, al usar pop
                if (libro == null)
                    continue;
                else
                    System.out.println("" + libro.getNombre());
            }
        }
    }

}

