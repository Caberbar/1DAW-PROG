package ejemplojdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecturateclado.LeerDatosTeclado;

public class EjemploJDBC {

    public static String url = "jdbc:derby://localhost:1527/ejemplo";
    public static Connection dbConnection;
    public static Statement sentencias;
    public static String sqlSelectAll = "SELECT * FROM ejemplo";
    
    public static void main(String[] args) {

        try {
            //Creamos la conexión a la base de datos
            dbConnection = DriverManager.getConnection(url, "jose", "jose");
            sentencias = dbConnection.createStatement();
            
            //hacemos un select y mostramos los resultados
            ResultSet listaTelefonos = sentencias.executeQuery(sqlSelectAll);
            String nombre, telefono;
            while(listaTelefonos.next()){
                nombre = listaTelefonos.getString("nombre");
                telefono = listaTelefonos.getString("telefono");
                System.out.println("Nombre: "+nombre+"\tTelefono: "+telefono);
            }
            
            //TODO: solicitar datos al usuario y añadir un nuevo elemento a la tabla
            //TODO: Sustituir la sentencia vulnerable a SQLi por un PreparedStatement
            nombre = LeerDatosTeclado.leerString("Introduzca un nombre: ");
            telefono = LeerDatosTeclado.leerString("Introduzca un teléfono: ");
            String sqlInsertTelefono = "INSERT INTO ejemplo VALUES ('"+ nombre + "', '"+ telefono + "')";
            
            if(sentencias.executeUpdate(sqlInsertTelefono) > 0){
                System.out.println("Se ha guardado el teléfono correctamente");
            }
            
            //Cerramos la conexión con la base de datos
            dbConnection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EjemploJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
