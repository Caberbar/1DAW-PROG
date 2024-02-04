/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "detalle_pedido")
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d"),
    @NamedQuery(name = "DetallePedido.findByCodigoPedido", query = "SELECT d FROM DetallePedido d WHERE d.detallePedidoPK.codigoPedido = :codigoPedido"),
    @NamedQuery(name = "DetallePedido.findByCodigoProducto", query = "SELECT d FROM DetallePedido d WHERE d.detallePedidoPK.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "DetallePedido.findByCantidad", query = "SELECT d FROM DetallePedido d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetallePedido.findByPrecioUnidad", query = "SELECT d FROM DetallePedido d WHERE d.precioUnidad = :precioUnidad"),
    @NamedQuery(name = "DetallePedido.findByNumeroLinea", query = "SELECT d FROM DetallePedido d WHERE d.numeroLinea = :numeroLinea")})
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePedidoPK detallePedidoPK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio_unidad")
    private BigDecimal precioUnidad;
    @Basic(optional = false)
    @Column(name = "numero_linea")
    private short numeroLinea;
    @JoinColumn(name = "codigo_pedido", referencedColumnName = "codigo_pedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedido pedido;
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public DetallePedido() {
    }

    public DetallePedido(DetallePedidoPK detallePedidoPK) {
        this.detallePedidoPK = detallePedidoPK;
    }

    public DetallePedido(DetallePedidoPK detallePedidoPK, int cantidad, BigDecimal precioUnidad, short numeroLinea) {
        this.detallePedidoPK = detallePedidoPK;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.numeroLinea = numeroLinea;
    }

    public DetallePedido(int codigoPedido, String codigoProducto) {
        this.detallePedidoPK = new DetallePedidoPK(codigoPedido, codigoProducto);
    }

    public DetallePedidoPK getDetallePedidoPK() {
        return detallePedidoPK;
    }

    public void setDetallePedidoPK(DetallePedidoPK detallePedidoPK) {
        this.detallePedidoPK = detallePedidoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(BigDecimal precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public short getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(short numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallePedidoPK != null ? detallePedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedido)) {
            return false;
        }
        DetallePedido other = (DetallePedido) object;
        if ((this.detallePedidoPK == null && other.detallePedidoPK != null) || (this.detallePedidoPK != null && !this.detallePedidoPK.equals(other.detallePedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetallePedido[ detallePedidoPK=" + detallePedidoPK + " ]";
    }
    
}
