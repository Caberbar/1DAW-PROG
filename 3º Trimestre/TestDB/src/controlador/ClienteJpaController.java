/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
import controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Empleado;
import modelo.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cliente;
import modelo.Pago;

/**
 *
 * @author Usuario
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TestDBPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) throws PreexistingEntityException, Exception {
        if (cliente.getPedidoList() == null) {
            cliente.setPedidoList(new ArrayList<Pedido>());
        }
        if (cliente.getPagoList() == null) {
            cliente.setPagoList(new ArrayList<Pago>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado codigoEmpleadoRepVentas = cliente.getCodigoEmpleadoRepVentas();
            if (codigoEmpleadoRepVentas != null) {
                codigoEmpleadoRepVentas = em.getReference(codigoEmpleadoRepVentas.getClass(), codigoEmpleadoRepVentas.getCodigoEmpleado());
                cliente.setCodigoEmpleadoRepVentas(codigoEmpleadoRepVentas);
            }
            List<Pedido> attachedPedidoList = new ArrayList<Pedido>();
            for (Pedido pedidoListPedidoToAttach : cliente.getPedidoList()) {
                pedidoListPedidoToAttach = em.getReference(pedidoListPedidoToAttach.getClass(), pedidoListPedidoToAttach.getCodigoPedido());
                attachedPedidoList.add(pedidoListPedidoToAttach);
            }
            cliente.setPedidoList(attachedPedidoList);
            List<Pago> attachedPagoList = new ArrayList<Pago>();
            for (Pago pagoListPagoToAttach : cliente.getPagoList()) {
                pagoListPagoToAttach = em.getReference(pagoListPagoToAttach.getClass(), pagoListPagoToAttach.getPagoPK());
                attachedPagoList.add(pagoListPagoToAttach);
            }
            cliente.setPagoList(attachedPagoList);
            em.persist(cliente);
            if (codigoEmpleadoRepVentas != null) {
                codigoEmpleadoRepVentas.getClienteList().add(cliente);
                codigoEmpleadoRepVentas = em.merge(codigoEmpleadoRepVentas);
            }
            for (Pedido pedidoListPedido : cliente.getPedidoList()) {
                Cliente oldCodigoClienteOfPedidoListPedido = pedidoListPedido.getCodigoCliente();
                pedidoListPedido.setCodigoCliente(cliente);
                pedidoListPedido = em.merge(pedidoListPedido);
                if (oldCodigoClienteOfPedidoListPedido != null) {
                    oldCodigoClienteOfPedidoListPedido.getPedidoList().remove(pedidoListPedido);
                    oldCodigoClienteOfPedidoListPedido = em.merge(oldCodigoClienteOfPedidoListPedido);
                }
            }
            for (Pago pagoListPago : cliente.getPagoList()) {
                Cliente oldClienteOfPagoListPago = pagoListPago.getCliente();
                pagoListPago.setCliente(cliente);
                pagoListPago = em.merge(pagoListPago);
                if (oldClienteOfPagoListPago != null) {
                    oldClienteOfPagoListPago.getPagoList().remove(pagoListPago);
                    oldClienteOfPagoListPago = em.merge(oldClienteOfPagoListPago);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCliente(cliente.getCodigoCliente()) != null) {
                throw new PreexistingEntityException("Cliente " + cliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getCodigoCliente());
            Empleado codigoEmpleadoRepVentasOld = persistentCliente.getCodigoEmpleadoRepVentas();
            Empleado codigoEmpleadoRepVentasNew = cliente.getCodigoEmpleadoRepVentas();
            List<Pedido> pedidoListOld = persistentCliente.getPedidoList();
            List<Pedido> pedidoListNew = cliente.getPedidoList();
            List<Pago> pagoListOld = persistentCliente.getPagoList();
            List<Pago> pagoListNew = cliente.getPagoList();
            List<String> illegalOrphanMessages = null;
            for (Pedido pedidoListOldPedido : pedidoListOld) {
                if (!pedidoListNew.contains(pedidoListOldPedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pedido " + pedidoListOldPedido + " since its codigoCliente field is not nullable.");
                }
            }
            for (Pago pagoListOldPago : pagoListOld) {
                if (!pagoListNew.contains(pagoListOldPago)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pago " + pagoListOldPago + " since its cliente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codigoEmpleadoRepVentasNew != null) {
                codigoEmpleadoRepVentasNew = em.getReference(codigoEmpleadoRepVentasNew.getClass(), codigoEmpleadoRepVentasNew.getCodigoEmpleado());
                cliente.setCodigoEmpleadoRepVentas(codigoEmpleadoRepVentasNew);
            }
            List<Pedido> attachedPedidoListNew = new ArrayList<Pedido>();
            for (Pedido pedidoListNewPedidoToAttach : pedidoListNew) {
                pedidoListNewPedidoToAttach = em.getReference(pedidoListNewPedidoToAttach.getClass(), pedidoListNewPedidoToAttach.getCodigoPedido());
                attachedPedidoListNew.add(pedidoListNewPedidoToAttach);
            }
            pedidoListNew = attachedPedidoListNew;
            cliente.setPedidoList(pedidoListNew);
            List<Pago> attachedPagoListNew = new ArrayList<Pago>();
            for (Pago pagoListNewPagoToAttach : pagoListNew) {
                pagoListNewPagoToAttach = em.getReference(pagoListNewPagoToAttach.getClass(), pagoListNewPagoToAttach.getPagoPK());
                attachedPagoListNew.add(pagoListNewPagoToAttach);
            }
            pagoListNew = attachedPagoListNew;
            cliente.setPagoList(pagoListNew);
            cliente = em.merge(cliente);
            if (codigoEmpleadoRepVentasOld != null && !codigoEmpleadoRepVentasOld.equals(codigoEmpleadoRepVentasNew)) {
                codigoEmpleadoRepVentasOld.getClienteList().remove(cliente);
                codigoEmpleadoRepVentasOld = em.merge(codigoEmpleadoRepVentasOld);
            }
            if (codigoEmpleadoRepVentasNew != null && !codigoEmpleadoRepVentasNew.equals(codigoEmpleadoRepVentasOld)) {
                codigoEmpleadoRepVentasNew.getClienteList().add(cliente);
                codigoEmpleadoRepVentasNew = em.merge(codigoEmpleadoRepVentasNew);
            }
            for (Pedido pedidoListNewPedido : pedidoListNew) {
                if (!pedidoListOld.contains(pedidoListNewPedido)) {
                    Cliente oldCodigoClienteOfPedidoListNewPedido = pedidoListNewPedido.getCodigoCliente();
                    pedidoListNewPedido.setCodigoCliente(cliente);
                    pedidoListNewPedido = em.merge(pedidoListNewPedido);
                    if (oldCodigoClienteOfPedidoListNewPedido != null && !oldCodigoClienteOfPedidoListNewPedido.equals(cliente)) {
                        oldCodigoClienteOfPedidoListNewPedido.getPedidoList().remove(pedidoListNewPedido);
                        oldCodigoClienteOfPedidoListNewPedido = em.merge(oldCodigoClienteOfPedidoListNewPedido);
                    }
                }
            }
            for (Pago pagoListNewPago : pagoListNew) {
                if (!pagoListOld.contains(pagoListNewPago)) {
                    Cliente oldClienteOfPagoListNewPago = pagoListNewPago.getCliente();
                    pagoListNewPago.setCliente(cliente);
                    pagoListNewPago = em.merge(pagoListNewPago);
                    if (oldClienteOfPagoListNewPago != null && !oldClienteOfPagoListNewPago.equals(cliente)) {
                        oldClienteOfPagoListNewPago.getPagoList().remove(pagoListNewPago);
                        oldClienteOfPagoListNewPago = em.merge(oldClienteOfPagoListNewPago);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cliente.getCodigoCliente();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getCodigoCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pedido> pedidoListOrphanCheck = cliente.getPedidoList();
            for (Pedido pedidoListOrphanCheckPedido : pedidoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Pedido " + pedidoListOrphanCheckPedido + " in its pedidoList field has a non-nullable codigoCliente field.");
            }
            List<Pago> pagoListOrphanCheck = cliente.getPagoList();
            for (Pago pagoListOrphanCheckPago : pagoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Pago " + pagoListOrphanCheckPago + " in its pagoList field has a non-nullable cliente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empleado codigoEmpleadoRepVentas = cliente.getCodigoEmpleadoRepVentas();
            if (codigoEmpleadoRepVentas != null) {
                codigoEmpleadoRepVentas.getClienteList().remove(cliente);
                codigoEmpleadoRepVentas = em.merge(codigoEmpleadoRepVentas);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
