package Aplicación;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Esta clase manejara la base de datos y los objetos TarjetaCredito y
 * Movimientos. Es una versi�n inicial que he creado sobre el trabajo de
 * Tarjetas de Cr�dito en base de datos.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class TarjetaCreditoJPAController {

    //Porque es final la variable
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_Base_DatosPU"); //Clase que abrira la conexion con la base de datos.

    /**
     * Obtiene todas las tarjetas de crédito almacenadas en la base de datos.
     *
     * @return Lista de todas las tarjetas de crédito.
     */
    public static List<TarjetaCredito> obtenerTodasTarjetas() {
        EntityManager em = emf.createEntityManager(); //Creamos una instancia para extraer todas las tarjetas
        try {
            Query query = em.createQuery("SELECT t FROM TarjetaCredito t"); //Creamos una consulta para coger todas las tarjetas
            List<TarjetaCredito> tarjetas = query.getResultList(); //Guardamos el resultado de la consulta enuna lista de tarjetas.
            return tarjetas; //Devolvemos la lista.
        } finally {
            em.close(); //Cerramos la conexion
        }
    }

    /**
     * Crea una nueva tarjeta de crédito y la persiste en la base de datos.
     *
     * @param tarjeta La tarjeta de crédito a crear.
     * @return true si la tarjeta se crea correctamente, false en caso
     * contrario.
     */
    public static boolean crearTarjeta(TarjetaCredito tarjeta) { //Terminado
        boolean creada = false;
        EntityManager em = emf.createEntityManager(); //Creamos una instancia para poder inserta la tarjeta en la base de datos.
        EntityTransaction tx = em.getTransaction(); //Creamos una instancia para controlar que l tarjeta se creo correctamente

        try {
            tx.begin(); //Comenzar transaccion
            em.persist(tarjeta); //Guardamos la tarjeta en la base de datos.
            creada = true;
            tx.commit(); //Aplicar los cambios en la base de datos.
        } catch (Exception e) {
            if (tx.isActive()) { //En caso de que la transacción  no se haya confirmado deshacemos los cambios
                tx.rollback();
            }
        } finally {
            em.close(); //Cerramos la conexion
        }
        return creada;
    }

    /**
     * Elimina una tarjeta de crédito de la base de datos.
     *
     * @param numeroTarjeta El número de tarjeta de crédito a eliminar.
     * @return true si la tarjeta se elimina correctamente, false en caso
     * contrario.
     */
    public static boolean eliminarTarjeta(String numeroTarjeta) { // Terminado
        boolean eliminada = false;
        EntityManager em = emf.createEntityManager(); //Creamos una instancia para poder inserta la tarjeta en la base de datos.
        EntityTransaction tx = em.getTransaction(); //Creamos una instancia para controlar que l tarjeta se creo correctamente

        try {
            tx.begin(); //Comenzar transaccion
            TarjetaCredito tarjeta = em.find(TarjetaCredito.class, numeroTarjeta); //Cogera la tarjeta que encunetre con el mismo número de tarjeta y lo guardara en un objeto
            if (tarjeta != null) {
                em.remove(tarjeta); //Eliminamos la tarjeta en la base ded atos
                eliminada = true;
            }
            tx.commit(); //Aplicar los cambios en la base de datos.
        } catch (Exception e) {
            if (tx.isActive()) {  //En caso de que la transacción  no se haya confirmado deshacemos los cambios
                tx.rollback();
            }
        } finally {
            em.close(); //Cerramos la conexion
        }
        return eliminada;
    }

    /**
     * Obtiene una tarjeta de crédito de la base de datos por su número de
     * tarjeta.
     *
     * @param numeroTarjeta El número de tarjeta de crédito.
     * @return La tarjeta de crédito correspondiente al número especificado, o
     * null si no se encuentra ninguna tarjeta con ese número.
     */
    public static TarjetaCredito obtenerTarjeta(String numeroTarjeta) { //Terminado
        EntityManager em = emf.createEntityManager(); //Creamos una instancia para poder inserta la tarjeta en la base de datos.
        TarjetaCredito tarjeta = em.find(TarjetaCredito.class, numeroTarjeta); //Cogera la tarjeta que encunetre con el mismo número de tarjeta y lo guardara en un objeto
        em.close(); //Cerramos la conexion
        return tarjeta;
    }

    /**
     * Cambia el PIN de una tarjeta de crédito.
     *
     * @param numeroTarjeta El número de tarjeta de crédito.
     * @param nuevoPin El nuevo PIN a asignar a la tarjeta.
     * @return true si el cambio de PIN se realiza correctamente, false en caso
     * contrario.
     */
    public static boolean cambiarPinTarjeta(String numeroTarjeta, String nuevoPin) {
        boolean cambiado = false;
        EntityManager em = emf.createEntityManager(); //Creamos una instancia para poder inserta la tarjeta en la base de datos.
        EntityTransaction tx = null; //Creamos una instancia para controlar que l tarjeta se creo correctamente

        try {
            tx = em.getTransaction();
            tx.begin(); //Comenzar transaccion

            TarjetaCredito tarjeta = em.find(TarjetaCredito.class, numeroTarjeta); //Cogera la tarjeta que encunetre con el mismo número de tarjeta y lo guardara en un objeto
            if (tarjeta != null) {
                tarjeta.setPin(nuevoPin); //Asignamos el nuevo pin a la tarjeta.
                em.merge(tarjeta); //Actualizamos los valores tarjeta
                tx.commit(); //Aplicar los cambios en la base de datos.
                cambiado = true;
            }
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {  //En caso de que la transacción  no se haya confirmado o sea nula deshacemos los cambios
                tx.rollback();
            }
        } finally {
            if (em != null) {
                em.close(); //Cerramos la conexion
            }
        }
        return cambiado;
    }

    /**
     * Realiza un pago asociado a una tarjeta de crédito.
     *
     * @param numeroTarjeta El número de tarjeta de crédito.
     * @param movimiento El movimiento de pago a realizar.
     * @return El movimiento de pago actualizado con la fecha y la tarjeta de
     * crédito asociada, o null si no se encuentra ninguna tarjeta con el número
     * especificado.
     */
    public static Movimiento realizarPago(String numeroTarjeta, Movimiento movimiento) {
        EntityManager em = emf.createEntityManager(); //Creamos una instancia para poder inserta la tarjeta en la base de datos.
        EntityTransaction et = em.getTransaction(); //Creamos una instancia para controlar que l tarjeta se creo correctamente

        try {
            et.begin(); //Comenzar transaccion
            TarjetaCredito tarjeta = em.find(TarjetaCredito.class, numeroTarjeta); //Cogera la tarjeta que encunetre con el mismo número de tarjeta y lo guardara en un objeto
            if (tarjeta != null) {
                movimiento.setFecha(new Date()); //Asignamos la fecha al movimiento
                movimiento.setTarjetaCredito(tarjeta); //Asiganamos la tarjeta al movimiento
                tarjeta.pagar(movimiento); //Realizamos el pago en la tarjeta
                em.persist(movimiento); //Guardamos movimiento en la base de datos
            } else {
                System.err.println("Tarjeta no encontrada");
            }
            et.commit(); //Aplicar los cambios en la base de datos.
        } catch (Exception e) {
            if (et.isActive()) {  //En caso de que la transacción  no se haya confirmado deshacemos los cambios
                et.rollback();
            }
            System.err.println("Error al realizar el pago.");
        } finally {
            em.close(); //Cerramos la conexion
        }

        return movimiento; //Devolvemos el movimiento
    }
}
