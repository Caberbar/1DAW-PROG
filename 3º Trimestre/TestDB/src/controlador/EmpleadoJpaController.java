/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Empleado;
import modelo.Oficina;
import modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TestDBPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) throws PreexistingEntityException, Exception {
        if (empleado.getClienteList() == null) {
            empleado.setClienteList(new ArrayList<Cliente>());
        }
        if (empleado.getEmpleadoList() == null) {
            empleado.setEmpleadoList(new ArrayList<Empleado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado codigoJefe = empleado.getCodigoJefe();
            if (codigoJefe != null) {
                codigoJefe = em.getReference(codigoJefe.getClass(), codigoJefe.getCodigoEmpleado());
                empleado.setCodigoJefe(codigoJefe);
            }
            Oficina codigoOficina = empleado.getCodigoOficina();
            if (codigoOficina != null) {
                codigoOficina = em.getReference(codigoOficina.getClass(), codigoOficina.getCodigoOficina());
                empleado.setCodigoOficina(codigoOficina);
            }
            List<Cliente> attachedClienteList = new ArrayList<Cliente>();
            for (Cliente clienteListClienteToAttach : empleado.getClienteList()) {
                clienteListClienteToAttach = em.getReference(clienteListClienteToAttach.getClass(), clienteListClienteToAttach.getCodigoCliente());
                attachedClienteList.add(clienteListClienteToAttach);
            }
            empleado.setClienteList(attachedClienteList);
            List<Empleado> attachedEmpleadoList = new ArrayList<Empleado>();
            for (Empleado empleadoListEmpleadoToAttach : empleado.getEmpleadoList()) {
                empleadoListEmpleadoToAttach = em.getReference(empleadoListEmpleadoToAttach.getClass(), empleadoListEmpleadoToAttach.getCodigoEmpleado());
                attachedEmpleadoList.add(empleadoListEmpleadoToAttach);
            }
            empleado.setEmpleadoList(attachedEmpleadoList);
            em.persist(empleado);
            if (codigoJefe != null) {
                codigoJefe.getEmpleadoList().add(empleado);
                codigoJefe = em.merge(codigoJefe);
            }
            if (codigoOficina != null) {
                codigoOficina.getEmpleadoList().add(empleado);
                codigoOficina = em.merge(codigoOficina);
            }
            for (Cliente clienteListCliente : empleado.getClienteList()) {
                Empleado oldCodigoEmpleadoRepVentasOfClienteListCliente = clienteListCliente.getCodigoEmpleadoRepVentas();
                clienteListCliente.setCodigoEmpleadoRepVentas(empleado);
                clienteListCliente = em.merge(clienteListCliente);
                if (oldCodigoEmpleadoRepVentasOfClienteListCliente != null) {
                    oldCodigoEmpleadoRepVentasOfClienteListCliente.getClienteList().remove(clienteListCliente);
                    oldCodigoEmpleadoRepVentasOfClienteListCliente = em.merge(oldCodigoEmpleadoRepVentasOfClienteListCliente);
                }
            }
            for (Empleado empleadoListEmpleado : empleado.getEmpleadoList()) {
                Empleado oldCodigoJefeOfEmpleadoListEmpleado = empleadoListEmpleado.getCodigoJefe();
                empleadoListEmpleado.setCodigoJefe(empleado);
                empleadoListEmpleado = em.merge(empleadoListEmpleado);
                if (oldCodigoJefeOfEmpleadoListEmpleado != null) {
                    oldCodigoJefeOfEmpleadoListEmpleado.getEmpleadoList().remove(empleadoListEmpleado);
                    oldCodigoJefeOfEmpleadoListEmpleado = em.merge(oldCodigoJefeOfEmpleadoListEmpleado);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpleado(empleado.getCodigoEmpleado()) != null) {
                throw new PreexistingEntityException("Empleado " + empleado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getCodigoEmpleado());
            Empleado codigoJefeOld = persistentEmpleado.getCodigoJefe();
            Empleado codigoJefeNew = empleado.getCodigoJefe();
            Oficina codigoOficinaOld = persistentEmpleado.getCodigoOficina();
            Oficina codigoOficinaNew = empleado.getCodigoOficina();
            List<Cliente> clienteListOld = persistentEmpleado.getClienteList();
            List<Cliente> clienteListNew = empleado.getClienteList();
            List<Empleado> empleadoListOld = persistentEmpleado.getEmpleadoList();
            List<Empleado> empleadoListNew = empleado.getEmpleadoList();
            if (codigoJefeNew != null) {
                codigoJefeNew = em.getReference(codigoJefeNew.getClass(), codigoJefeNew.getCodigoEmpleado());
                empleado.setCodigoJefe(codigoJefeNew);
            }
            if (codigoOficinaNew != null) {
                codigoOficinaNew = em.getReference(codigoOficinaNew.getClass(), codigoOficinaNew.getCodigoOficina());
                empleado.setCodigoOficina(codigoOficinaNew);
            }
            List<Cliente> attachedClienteListNew = new ArrayList<Cliente>();
            for (Cliente clienteListNewClienteToAttach : clienteListNew) {
                clienteListNewClienteToAttach = em.getReference(clienteListNewClienteToAttach.getClass(), clienteListNewClienteToAttach.getCodigoCliente());
                attachedClienteListNew.add(clienteListNewClienteToAttach);
            }
            clienteListNew = attachedClienteListNew;
            empleado.setClienteList(clienteListNew);
            List<Empleado> attachedEmpleadoListNew = new ArrayList<Empleado>();
            for (Empleado empleadoListNewEmpleadoToAttach : empleadoListNew) {
                empleadoListNewEmpleadoToAttach = em.getReference(empleadoListNewEmpleadoToAttach.getClass(), empleadoListNewEmpleadoToAttach.getCodigoEmpleado());
                attachedEmpleadoListNew.add(empleadoListNewEmpleadoToAttach);
            }
            empleadoListNew = attachedEmpleadoListNew;
            empleado.setEmpleadoList(empleadoListNew);
            empleado = em.merge(empleado);
            if (codigoJefeOld != null && !codigoJefeOld.equals(codigoJefeNew)) {
                codigoJefeOld.getEmpleadoList().remove(empleado);
                codigoJefeOld = em.merge(codigoJefeOld);
            }
            if (codigoJefeNew != null && !codigoJefeNew.equals(codigoJefeOld)) {
                codigoJefeNew.getEmpleadoList().add(empleado);
                codigoJefeNew = em.merge(codigoJefeNew);
            }
            if (codigoOficinaOld != null && !codigoOficinaOld.equals(codigoOficinaNew)) {
                codigoOficinaOld.getEmpleadoList().remove(empleado);
                codigoOficinaOld = em.merge(codigoOficinaOld);
            }
            if (codigoOficinaNew != null && !codigoOficinaNew.equals(codigoOficinaOld)) {
                codigoOficinaNew.getEmpleadoList().add(empleado);
                codigoOficinaNew = em.merge(codigoOficinaNew);
            }
            for (Cliente clienteListOldCliente : clienteListOld) {
                if (!clienteListNew.contains(clienteListOldCliente)) {
                    clienteListOldCliente.setCodigoEmpleadoRepVentas(null);
                    clienteListOldCliente = em.merge(clienteListOldCliente);
                }
            }
            for (Cliente clienteListNewCliente : clienteListNew) {
                if (!clienteListOld.contains(clienteListNewCliente)) {
                    Empleado oldCodigoEmpleadoRepVentasOfClienteListNewCliente = clienteListNewCliente.getCodigoEmpleadoRepVentas();
                    clienteListNewCliente.setCodigoEmpleadoRepVentas(empleado);
                    clienteListNewCliente = em.merge(clienteListNewCliente);
                    if (oldCodigoEmpleadoRepVentasOfClienteListNewCliente != null && !oldCodigoEmpleadoRepVentasOfClienteListNewCliente.equals(empleado)) {
                        oldCodigoEmpleadoRepVentasOfClienteListNewCliente.getClienteList().remove(clienteListNewCliente);
                        oldCodigoEmpleadoRepVentasOfClienteListNewCliente = em.merge(oldCodigoEmpleadoRepVentasOfClienteListNewCliente);
                    }
                }
            }
            for (Empleado empleadoListOldEmpleado : empleadoListOld) {
                if (!empleadoListNew.contains(empleadoListOldEmpleado)) {
                    empleadoListOldEmpleado.setCodigoJefe(null);
                    empleadoListOldEmpleado = em.merge(empleadoListOldEmpleado);
                }
            }
            for (Empleado empleadoListNewEmpleado : empleadoListNew) {
                if (!empleadoListOld.contains(empleadoListNewEmpleado)) {
                    Empleado oldCodigoJefeOfEmpleadoListNewEmpleado = empleadoListNewEmpleado.getCodigoJefe();
                    empleadoListNewEmpleado.setCodigoJefe(empleado);
                    empleadoListNewEmpleado = em.merge(empleadoListNewEmpleado);
                    if (oldCodigoJefeOfEmpleadoListNewEmpleado != null && !oldCodigoJefeOfEmpleadoListNewEmpleado.equals(empleado)) {
                        oldCodigoJefeOfEmpleadoListNewEmpleado.getEmpleadoList().remove(empleadoListNewEmpleado);
                        oldCodigoJefeOfEmpleadoListNewEmpleado = em.merge(oldCodigoJefeOfEmpleadoListNewEmpleado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleado.getCodigoEmpleado();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
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
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getCodigoEmpleado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            Empleado codigoJefe = empleado.getCodigoJefe();
            if (codigoJefe != null) {
                codigoJefe.getEmpleadoList().remove(empleado);
                codigoJefe = em.merge(codigoJefe);
            }
            Oficina codigoOficina = empleado.getCodigoOficina();
            if (codigoOficina != null) {
                codigoOficina.getEmpleadoList().remove(empleado);
                codigoOficina = em.merge(codigoOficina);
            }
            List<Cliente> clienteList = empleado.getClienteList();
            for (Cliente clienteListCliente : clienteList) {
                clienteListCliente.setCodigoEmpleadoRepVentas(null);
                clienteListCliente = em.merge(clienteListCliente);
            }
            List<Empleado> empleadoList = empleado.getEmpleadoList();
            for (Empleado empleadoListEmpleado : empleadoList) {
                empleadoListEmpleado.setCodigoJefe(null);
                empleadoListEmpleado = em.merge(empleadoListEmpleado);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
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

    public Empleado findEmpleado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
