package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionJDBC {
    
    String bd = "jardineria";
    String ip = "localhost";
    String puerto = "5432";
    
    public Connection getConexion(){
        Connection conexion = null;
        
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
            conexion = DriverManager.getConnection(url, "postgres", "dawb");
            System.out.println("Conexión establecida");
            
            Statement sentencia = conexion.createStatement();
            
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM empleado");
            while (resultado.next()) {
                System.out.println(resultado.getString("nombre"));
            }
        }catch(Exception e){
            System.err.println("Ha ocurrido un error");
        }
        return null;
    }
}
