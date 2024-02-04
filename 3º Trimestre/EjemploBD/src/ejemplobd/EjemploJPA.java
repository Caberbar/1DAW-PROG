package ejemplobd;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EjemploJPA {

    public static void main(String[] args) {

        EntityManagerFactory emf;
        EntityManager em;
        EntityTransaction et;

        Contacto c1, c2;

        //Construimos los objetos para manejar la BD
        emf = Persistence.createEntityManagerFactory("EjemploBDPU");
        em = emf.createEntityManager();
        et = em.getTransaction();

//        //Transacción para almacenar nuevos objetos en la BD
//        c1 = new Contacto("paco", "111111111");
//        c2 = new Contacto("julian", "222222222");
//        
//        et.begin();
//        em.persist(c1);
//        em.persist(c2);
//        et.commit();
//        
//        System.out.println("Los contactos se han guardado correctamente");
        //Consultamos todos los contactos almacenados en la BD
        String jpql_selectAll = "SELECT c FROM Contacto c";
        Query consulta = em.createQuery(jpql_selectAll);

        List<Contacto> listaContactos = consulta.getResultList();
        for (Contacto c : listaContactos) {
            System.out.println("Contacto: " + c);
        }

        //Probamos una NamedQuery ya preparada en la clase Contacto
        Query consultaTelefono = em.createNamedQuery("Contacto.findByTelefono");
        consultaTelefono.setParameter("telefono", "111111111");
        List<Contacto> contactoTelefonos = consultaTelefono.getResultList();
        for (Contacto c : contactoTelefonos) {
            System.out.println("Contacto: " + c);
        }

        //Buscamos un objeto a través de su clave
        c1 = em.find(Contacto.class, "julian");
        if (c1 != null) {
            System.out.println("El teléfono de Julian es: " + c1.getTelefono());
            
            //em.detach(c1); //si quiero desacoplar el objeto de la base de datos
            
            //Modificamos el teléfono
            et.begin();
            //c1.setTelefono("444444444");
            em.remove(c1);
            et.commit();
            System.out.println("Se ha modificado el teléfono de Julian");
        }

    }

}
