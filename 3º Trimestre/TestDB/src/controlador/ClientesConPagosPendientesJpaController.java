/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.ClientesConPagosPendientes;

/**
 *
 * @author Usuario
 */
public class ClientesConPagosPendientesJpaController implements Serializable {

    public ClientesConPagosPendientesJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TestDBPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ClientesConPagosPendientes clientesConPagosPendientes) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clientesConPagosPendientes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClientesConPagosPendientes(clientesConPagosPendientes.getIdCliente()) != null) {
                throw new PreexistingEntityException("ClientesConPagosPendientes " + clientesConPagosPendientes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ClientesConPagosPendientes clientesConPagosPendientes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clientesConPagosPendientes = em.merge(clientesConPagosPendientes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = clientesConPagosPendientes.getIdCliente();
                if (findClientesConPagosPendientes(id) == null) {
                    throw new NonexistentEntityException("The clientesConPagosPendientes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ClientesConPagosPendientes clientesConPagosPendientes;
            try {
                clientesConPagosPendientes = em.getReference(ClientesConPagosPendientes.class, id);
                clientesConPagosPendientes.getIdCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clientesConPagosPendientes with id " + id + " no longer exists.", enfe);
            }
            em.remove(clientesConPagosPendientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ClientesConPagosPendientes> findClientesConPagosPendientesEntities() {
        return findClientesConPagosPendientesEntities(true, -1, -1);
    }

    public List<ClientesConPagosPendientes> findClientesConPagosPendientesEntities(int maxResults, int firstResult) {
        return findClientesConPagosPendientesEntities(false, maxResults, firstResult);
    }

    private List<ClientesConPagosPendientes> findClientesConPagosPendientesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ClientesConPagosPendientes.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ClientesConPagosPendientes findClientesConPagosPendientes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ClientesConPagosPendientes.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientesConPagosPendientesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ClientesConPagosPendientes> rt = cq.from(ClientesConPagosPendientes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
