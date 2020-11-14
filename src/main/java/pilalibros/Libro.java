package pilalibros;

public class Libro {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String autor;
    private String editorial;
    private Double precio;
    private Integer stock;

    public Libro(Integer id, String nombre, String descripcion, String autor, String editorial, Double precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.autor = autor;
        this.editorial = editorial;
        this.precio = precio;
        this.stock = stock;
    }

    public Libro(String nombre, String descripcion, String autor, String editorial, Double precio, Integer stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.autor = autor;
        this.editorial = editorial;
        this.precio = precio;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
