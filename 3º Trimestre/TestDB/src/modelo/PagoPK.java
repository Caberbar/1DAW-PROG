/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Usuario
 */
@Embeddable
public class PagoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo_cliente")
    private int codigoCliente;
    @Basic(optional = false)
    @Column(name = "id_transaccion")
    private String idTransaccion;

    public PagoPK() {
    }

    public PagoPK(int codigoCliente, String idTransaccion) {
        this.codigoCliente = codigoCliente;
        this.idTransaccion = idTransaccion;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoCliente;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoPK)) {
            return false;
        }
        PagoPK other = (PagoPK) object;
        if (this.codigoCliente != other.codigoCliente) {
            return false;
        }
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PagoPK[ codigoCliente=" + codigoCliente + ", idTransaccion=" + idTransaccion + " ]";
    }
    
}
