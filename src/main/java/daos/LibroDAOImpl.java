package daos;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pilalibros.Libro;
import pilaproductos.Producto;
import connectiondb.ConnectionDB;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class LibroDAOImpl implements ILibrosDao{
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static Statement st;
    private static ConnectionDB conn;

    public LibroDAOImpl() {
        conn = ConnectionDB.createInstance();
    }

    public Boolean insert(Libro libro) {
        Boolean result = false;
        final String SQL = "INSERT INTO Libro VALUES(?,?,?,?,?,?)";
        try {
            ps = conn.getConnection().prepareStatement(SQL);

            ps.setString(1, libro.getNombre());
            ps.setString(2, libro.getDescripcion());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getEditorial());
            ps.setDouble(5, libro.getPrecio());
            ps.setInt(6, libro.getStock());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        }
        catch (Exception e) {
            System.out.println("Error al insertar");
            e.printStackTrace();
        }
        finally {
            close();
        }
        return result;
    }

    public Boolean update(Libro libro) {
        Boolean result = false;
        final String SQL = "UPDATE Libro SET Nombre=?, Descripcion=?, Autor=?, Editorial=?, Precio=?, Stock=? WHERE Id=?";
        try {
            ps = conn.getConnection().prepareStatement(SQL);

            ps.setString(1, libro.getNombre());
            ps.setString(2, libro.getDescripcion());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getEditorial());
            ps.setDouble(5, libro.getPrecio());
            ps.setInt(6, libro.getStock());
            ps.setInt(7, libro.getId());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        }
        catch (Exception e) {
            System.out.println("Error al actualizar");
            e.printStackTrace();
        }
        finally {
            close();
        }
        return result;
    }

    public Libro selectById(Integer id) {
        Libro libro = null;
        final String SQL = "SELECT * FROM Libro WHERE Id=?";
        try {
            ps = conn.getConnection().prepareStatement(SQL);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()) {
                libro = new Libro( rs.getInt("Id"), rs.getString("Nombre"), rs.getString("Descripcion")
                        , rs.getString("Autor"), rs.getString("Editorial")
                        , rs.getDouble("Precio"), rs.getInt("Stock"));
            }
        }
        catch (Exception e) {
            System.out.println("Error al seleccionar por ID" + e.getMessage());
        }
        finally {
            close();
        }
        return libro;
    }

    public List<Libro> selectAll() {
        String SQL = "SELECT * FROM Producto";
        List<Libro> libros = new ArrayList<Libro>();
        try {
            st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                libros.add(new Libro( rs.getInt("Id"), rs.getString("Nombre"), rs.getString("Descripcion")
                        , rs.getString("Autor"), rs.getString("Editorial")
                        , rs.getDouble("Precio"), rs.getInt("Stock")));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            this.close();
        }
        return libros;
    }

    public void delete(final Object object) {
        final String SQL = "DELETE FROM Libro WHERE Id=?";
        try {
            ps = conn.getConnection().prepareStatement(SQL);
            Libro libro = (Libro)object;
            ps.setInt(1, libro.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("Error columna no affectada");
            }
        }
        catch (Exception e) {
            System.out.println("Error al eliminar" + e.getMessage());
        }
        finally {
            close();
        }
    }

    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        catch (Exception e) {
            System.out.println("Error al cerrar las interfaces :");
        }
    }
}