package daos;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pilaproductos.Producto;
import connectiondb.ConnectionDB;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ProductoDAOImpl implements IProductoDao{
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static Statement st;
    private static ConnectionDB conn;
    
    public ProductoDAOImpl() {
        conn = ConnectionDB.createInstance();
    }
    
    public Boolean insert(Producto producto) {
        Boolean result = false;
        final String SQL = "INSERT INTO Producto VALUES(?,?,?,?)";
        try {
            ps = conn.getConnection().prepareStatement(SQL);
            
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
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
    
    public Boolean update(Producto producto) {
        Boolean result = false;
        final String SQL = "UPDATE Producto SET Nombre=?, Descripcion=?, Precio=?, Stock=? WHERE Id=?";
        try {
            ps = conn.getConnection().prepareStatement(SQL);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getId());
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
    
    public Producto selectById(Integer id) {
        Producto producto = null;
        final String SQL = "SELECT * FROM Producto WHERE Id=?";
        try {
            ps = conn.getConnection().prepareStatement(SQL);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto( rs.getInt("Id"), rs.getString("Nombre"), rs.getString("Descripcion"), rs.getDouble("Precio"), rs.getInt("Stock"));
            }
        }
        catch (Exception e) {
            System.out.println("Error al seleccionar por ID" + e.getMessage());
        }
        finally {
            close();
        }
        return producto;
    }
    
    public List<Producto> selectAll() {
        String SQL = "SELECT * FROM Producto";
        List<Producto> productos = new ArrayList<Producto>();
        try {
            st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                productos.add(new Producto(rs.getInt("Id"), rs.getString("Nombre"), rs.getString("Descripcion"), rs.getDouble("Precio"), rs.getInt("Stock")));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            this.close();
        }
        return productos;
    }
    
    public void delete(final Object object) {
        final String SQL = "DELETE FROM Producto WHERE id=?";
        try {
            ps = conn.getConnection().prepareStatement(SQL);
            Producto producto = (Producto)object;
            ps.setInt(1, producto.getId());
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