/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "clientes_con_pagos_pendientes")
@NamedQueries({
    @NamedQuery(name = "ClientesConPagosPendientes.findAll", query = "SELECT c FROM ClientesConPagosPendientes c"),
    @NamedQuery(name = "ClientesConPagosPendientes.findByIdCliente", query = "SELECT c FROM ClientesConPagosPendientes c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "ClientesConPagosPendientes.findBySumaTotalPedidos", query = "SELECT c FROM ClientesConPagosPendientes c WHERE c.sumaTotalPedidos = :sumaTotalPedidos"),
    @NamedQuery(name = "ClientesConPagosPendientes.findBySumaTotalPagos", query = "SELECT c FROM ClientesConPagosPendientes c WHERE c.sumaTotalPagos = :sumaTotalPagos"),
    @NamedQuery(name = "ClientesConPagosPendientes.findByPendienteDePago", query = "SELECT c FROM ClientesConPagosPendientes c WHERE c.pendienteDePago = :pendienteDePago")})
public class ClientesConPagosPendientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "suma_total_pedidos")
    private Double sumaTotalPedidos;
    @Column(name = "suma_total_pagos")
    private Double sumaTotalPagos;
    @Column(name = "pendiente_de_pago")
    private Boolean pendienteDePago;

    public ClientesConPagosPendientes() {
    }

    public ClientesConPagosPendientes(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Double getSumaTotalPedidos() {
        return sumaTotalPedidos;
    }

    public void setSumaTotalPedidos(Double sumaTotalPedidos) {
        this.sumaTotalPedidos = sumaTotalPedidos;
    }

    public Double getSumaTotalPagos() {
        return sumaTotalPagos;
    }

    public void setSumaTotalPagos(Double sumaTotalPagos) {
        this.sumaTotalPagos = sumaTotalPagos;
    }

    public Boolean getPendienteDePago() {
        return pendienteDePago;
    }

    public void setPendienteDePago(Boolean pendienteDePago) {
        this.pendienteDePago = pendienteDePago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientesConPagosPendientes)) {
            return false;
        }
        ClientesConPagosPendientes other = (ClientesConPagosPendientes) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ClientesConPagosPendientes[ idCliente=" + idCliente + " ]";
    }
    
}
