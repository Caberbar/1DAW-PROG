package Aplicación;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

/**
 * Esta clase manejara la base de datos y los objetos TarjetaCredito y Movimientos. Es una versi�n
 * inicial que he creado sobre el trabajo de Tarjetas de Cr�dito en base de
 * datos.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class TarjetaCreditoDAO {

    private static boolean vacio = false;

    /**
     * Verifica si el array de tarjetas está vacío.
     *
     * @return true si el array está vacío, false en caso contrario.
     */
    public static boolean isVacio() {
        return vacio;
    }

    /**
     * Establece una conexión con la base de datos.
     *
     * @return La conexión establecida.
     */
    private static Connection conectar() {
        Connection conexion = null; //Declarar variable conexion de tipo connection;
        try {
            Class.forName("org.postgresql.Driver"); //Carga el controlador de PostgreSQL
            String url = "jdbc:postgresql://" + "localhost" + ":" + "5432" + "/" + "GestionTarjetas"; //Cadena de conexión URL a la base de datos
            conexion = DriverManager.getConnection(url, "postgres", "dawb"); //Establece la conexion con la base de datos con los datos de login especificados
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error");
        }
        return conexion; //Devuelve la conexión.
    }

    /**
     * Crea una nueva tarjeta de crédito en la base de datos.
     *
     * @param tarjeta La tarjeta de crédito a crear.
     * @return true si se crea la tarjeta exitosamente, false si no se puede
     * crear.
     */
    public static boolean crearTarjeta(TarjetaCredito tarjeta) {
        boolean esValido = false;
        if (tarjeta != null) {
            Connection conexion = conectar(); //Obtener una conexión a la base de datos.
            String consulta = "INSERT INTO Tarjetas (numero_tarjeta, nombre, documento_identidad, pin, limite_credito, fecha_caducidad) " //Consulta SQL para insertar los datos de la tarjeta en la tabla "Tarjetas"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            try {

                LocalDate fechaActual = LocalDate.now();
                LocalDate fechaCaducidad = fechaActual.plusYears(4);
                Date fechaCaducidadSQL = Date.valueOf(fechaCaducidad); //Pasar de caducidad a Date

                PreparedStatement sentencia = conexion.prepareStatement(consulta); //Preparamos la consulta SQL

                sentencia.setString(1, tarjeta.getNumero()); //Establecemos los valores
                sentencia.setString(2, tarjeta.getNombre());
                sentencia.setString(3, tarjeta.getNif());
                sentencia.setString(4, tarjeta.getPin());
                sentencia.setDouble(5, tarjeta.getLimite());
                sentencia.setDate(6, fechaCaducidadSQL);

                sentencia.executeUpdate(); //Ejecutamos la sentencia de inserción
                esValido = true;
                conexion.close(); //Cerramos la conexion
            } catch (SQLException ex) {
                System.out.println("Error al insertar.");
            }
        }
        return esValido;
    }

    /**
     * Elimina una tarjeta de crédito de la base de datos.
     *
     * @param numeroTarjeta El número de tarjeta de crédito a eliminar.
     * @return true si se elimina la tarjeta exitosamente, false si no se puede
     * eliminar.
     */
    public static boolean eliminarTarjeta(String numeroTarjeta) {
        boolean esValido = false;
        String consulta = "DELETE FROM Tarjetas WHERE numero_tarjeta = ?"; //Consulta SQL para eliminar una tarjeta por su numero
        try {
            Connection conexion = conectar(); //Obtener una conexión a la base de datos.
            PreparedStatement sentencia = conexion.prepareStatement(consulta); //Preparamos la consulta SQL
            sentencia.setString(1, numeroTarjeta); //Establecemos los valores
            sentencia.executeUpdate(); //Ejecutamos la sentencia de inserción
            conexion.close(); //Cerramos la conexion
            esValido = true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la tarjeta.");
        }
        return esValido;
    }

    /**
     * Cambia el PIN de una tarjeta de crédito en la base de datos.
     *
     * @param pin El nuevo PIN a establecer.
     * @param numeroTarjeta El número de tarjeta de crédito a modificar.
     * @return true si se cambia el PIN exitosamente, false si no se puede
     * cambiar.
     */
    public static boolean cambiarPin(String pin, String numeroTarjeta) {
        boolean cambiado = false;
        String consulta = "UPDATE Tarjetas SET pin = ? WHERE numero_tarjeta = ?"; //Consulta SQL para actualizar el pin de una tarjeta
        try {
            Connection conexion = conectar(); //Obtener una conexión a la base de datos.
            PreparedStatement sentencia = conexion.prepareStatement(consulta); //Preparamos la consulta SQL
            sentencia.setString(1, pin); //Establecemos los valores
            sentencia.setString(2, numeroTarjeta);
            int filasActualizadas = sentencia.executeUpdate(); //Ejecutamos la sentencia de inserción
            if (filasActualizadas > 0) { 
                cambiado = true;
            }
            conexion.close(); //Cerramos la conexion
        } catch (SQLException ex) {
            System.out.println("Error al actualizar una tarjeta");
        }
        return cambiado;
    }

    /**
     * Lee una tarjeta de crédito de la base de datos.
     *
     * @param numeroTarjeta El número de tarjeta de crédito a leer.
     * @return La tarjeta de crédito leída, o null si no se encuentra.
     */
    public static TarjetaCredito leer(String numeroTarjeta) {
        TarjetaCredito tarjeta = null;
        String consulta = "SELECT * FROM Tarjetas WHERE numero_tarjeta = ?"; //Consulta SQL para leer una tarjeta por su numero
        try {
            Connection conexion = conectar(); //Obtener una conexión a la base de datos.
            PreparedStatement sentencia = conexion.prepareStatement(consulta); //Preparamos la consulta SQL
            sentencia.setString(1, numeroTarjeta); //Establecemos los valores

            ResultSet rs = sentencia.executeQuery(); //Ejecutamos la sentencia de inserción
            if (rs.next()) { //Recorremos los resultados y extraemos los datos de la tarjeta
                String nombre = rs.getString("nombre");
                String dni = rs.getString("documento_identidad");
                String pin = rs.getString("pin");
                int limite = rs.getInt("limite_credito");
                String numero = rs.getString("numero_tarjeta");
                Date fecha = rs.getDate("fecha_caducidad");

                tarjeta = new TarjetaCredito(nombre, dni, pin, limite, numero); //Creamos una tarjeta nueva con los datos extraidos
                conexion.close(); //Cerramos la conexion
            }
        } catch (SQLException ex) {
            System.out.println("Error al leer una tarjeta");
        }
        return tarjeta;
    }

    /**
     * Busca una tarjeta de crédito en la base de datos.
     *
     * @param numeroTarjeta El número de tarjeta de crédito a buscar.
     * @return true si se encuentra la tarjeta, false si no se encuentra.
     */
    public static boolean buscarTarjeta(String numeroTarjeta) {
        boolean existe = false;
        String consulta = "SELECT COUNT(*) FROM Tarjetas WHERE numero_tarjeta = ?"; //Consulta SQL para contar las tarjetas con el mismo numero
        try {
            Connection conexion = conectar(); //Obtener una conexión a la base de datos.
            PreparedStatement sentencia = conexion.prepareStatement(consulta); //Preparamos la consulta SQL
            sentencia.setString(1, numeroTarjeta);  //Establecemos los valores
            ResultSet rs = sentencia.executeQuery(); //Ejecutamos la sentencia de inserción
            if (rs.next()) {//Recorremos los resultados
                if (rs.getInt(1) > 0) { //En caso de ser mayor de 0 quiere decir que encontro la tarjeta
                    existe = true;
                }
            }
            conexion.close(); //Cerramos la conexion
        } catch (SQLException ex) {
            System.out.println("Error al buscar la tarjeta");
        }
        return existe; // Si ocurre alguna excepción, retornar false
    }

    /**
     * Añade los movimientos de una tarjeta de crédito al array de movimientos.
     *
     * @param numeroTarjeta El número de tarjeta de crédito para obtener los
     * movimientos.
     * @return El array de movimientos de la tarjeta de crédito.
     */
    public static ArrayList<Movimiento> añadirMovimientosArray(String numeroTarjeta) {
        ArrayList<Movimiento> movimientos = new ArrayList<>();

        String consulta = "SELECT fecha, concepto, cantidad FROM movimientos WHERE numero_tarjeta = ?"; //Consulta SQL para extraer los movimientos de una tarjeta en especifico

        try {
            Connection conexion = conectar(); //Obtener una conexión a la base de datos.
            PreparedStatement sentencia = conexion.prepareStatement(consulta); //Preparamos la consulta SQL
            sentencia.setString(1, numeroTarjeta); //Establecemos los valores

            ResultSet resultSet = sentencia.executeQuery(); //Ejecutamos la sentencia de inserción

            while (resultSet.next()) { //Recorremos los resultados y extraemos los datos de un movimiento
                Date fecha = resultSet.getDate("fecha");
                String concepto = resultSet.getString("concepto");
                int cantidad = resultSet.getInt("cantidad");

                Movimiento movimiento = new Movimiento(cantidad, concepto); //Creamos un movimiento nuevo con los datos extraidos
                movimientos.add(movimiento); //Añadimos el movimiento al arrayList
                vacio = true;
            }
            conexion.close(); //Cerramos la conexion
        } catch (SQLException ex) {
            vacio = false;
            System.err.println("Error al leer los movimientos");
        }

        return movimientos;
    }

    /**
     * Añade las tarjetas de crédito existentes en la base de datos al array de
     * tarjetas.
     *
     * @return El array de tarjetas de crédito.
     */
    public static ArrayList<TarjetaCredito> añadirTarjetaArray() {
        ArrayList<TarjetaCredito> tarjetas = new ArrayList<>();

        String consulta = "SELECT * FROM tarjetas"; //Consulta SQL para extraer todas las tarjetas

        try {
            Connection conexion = conectar(); //Obtener una conexión a la base de datos.
            PreparedStatement sentencia = conexion.prepareStatement(consulta); //Preparamos la consulta SQL

            ResultSet rs = sentencia.executeQuery(); //Ejecutamos la sentencia de inserción

            // Recorrer los resultados y crear objetos Movimiento
            while (rs.next()) { //Recorremos los resultados y extraemos los datos de las tarjetas y sus movimientos
                String nombre = rs.getString("nombre");
                String dni = rs.getString("documento_identidad");
                String pin = rs.getString("pin");
                int limite = rs.getInt("limite_credito");
                String numero = rs.getString("numero_tarjeta");
                Date fecha = rs.getDate("fecha_caducidad");
                
                TarjetaCredito tarjeta = new TarjetaCredito(nombre, dni, pin, limite, numero); //Creamos una tarjeta nueva con los datos extraidos

                tarjeta.setMovimientos(añadirMovimientosArray(numero)); //Añadimos sus movimietnos con el anterior metodo

                tarjeta.setMes(fecha.toLocalDate().getMonthValue());
                tarjeta.setAnno(fecha.toLocalDate().getYear());
                tarjetas.add(tarjeta); //Añadimos la tarjeta al AraryList
            }
            conexion.close(); //Cerramos la conexion
        } catch (SQLException ex) {
            System.err.println("Error al leer las tarjetas.");
        }
        return tarjetas;
    }

    /**
     * Comprueba si existen movimientos para una tarjeta de crédito en la base
     * de datos.
     *
     * @param numeroTarjeta El número de tarjeta de crédito para comprobar los
     * movimientos.
     * @return true si existen movimientos, false si no existen.
     */
    public static boolean exisMovimientos(String numeroTarjeta) {
        boolean existe = false;
        String consulta = "SELECT COUNT(*) FROM movimientos WHERE numero_tarjeta = ?"; //Consulta SQL para comprobar si una tarjeta tienemovimientos
        try {
            Connection conexion = conectar(); //Obtener una conexión a la base de datos.
            PreparedStatement sentencia = conexion.prepareStatement(consulta); //Preparamos la consulta SQL
            sentencia.setString(1, numeroTarjeta); //Establecemos los valores
            ResultSet rs = sentencia.executeQuery(); //Ejecutamos la sentencia de inserción
            if (rs.next()) { //Recorremos los resultados
                if (rs.getInt(1) > 0) { //En caso de ser mayor de 0 quiere decir que encontro movimientos
                    existe = true;
                }
            }
            conexion.close(); //Cerramos la conexion
        } catch (SQLException ex) {
            System.err.println("Error al leer los movimientos.");
        }
        return existe; // Si ocurre alguna excepción, retornar false
    }

    /**
     * Realiza un pago en una tarjeta de crédito y registra el movimiento en la
     * base de datos.
     *
     * @param tarjeta La tarjeta de crédito en la que se realiza el cobro.
     * @param cantidad La cantidad a cobrar.
     * @param concepto El concepto del cobro.
     * @return true si el cobro se realiza correctamente, false si no se puede
     * realizar.
     */
    public static Movimiento realizarPago(TarjetaCredito tarjeta, String concepto, int cantidad) {
        Movimiento movimiento = null;
        String consulta = "INSERT INTO movimientos (numero_tarjeta, concepto, cantidad, fecha) VALUES (?, ?, ?, ?)"; //Consulta SQL para inserta un movimiento en la tabla

        try {
            Connection conexion = conectar(); //Obtener una conexión a la base de datos.

            PreparedStatement preparedStatement = conexion.prepareStatement(consulta); //Preparamos la consulta SQL
            preparedStatement.setString(1, tarjeta.getNumero()); //Establecemos los valores
            preparedStatement.setString(2, concepto);
            preparedStatement.setInt(3, cantidad);
            preparedStatement.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            preparedStatement.executeUpdate(); //Ejecutamos la sentencia de inserción

            movimiento = new Movimiento(cantidad, concepto); //Creamos un movimietno con los datos extraidos.
            tarjeta.pagar(movimiento); //Realizamos un pago con el metodo pagar().
            
            conexion.close(); //Cerramos la conexion
        } catch (SQLException ex) {
            System.err.println("Error al realizar pago.");
        }
        return movimiento;
    }
}
