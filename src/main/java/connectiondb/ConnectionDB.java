package connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static ConnectionDB instance=null;
    private static Connection conn = null;
    private  final String URL="jdbc:sqlserver://localhost:1433;databaseName=IsilDb";
    private  final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private  final String USER="sa";
    private final String PASS="1234";

    //CONSTRUCTOR PRIVADO
    private  ConnectionDB(){
        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Conectado a mi base de datos");
        } catch (Exception ex) {
            System.out.println("Error de conexion"+ex.getMessage());
            ex.printStackTrace();
        }
    }
    public synchronized static ConnectionDB createInstance(){
        if(instance==null){
            instance = new ConnectionDB();
        }
        return instance;
    }
    public Connection getConnection(){
        return conn;
    }
    public void close(){
        instance=null;
    }
}
