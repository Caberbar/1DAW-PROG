/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "oficina")
@NamedQueries({
    @NamedQuery(name = "Oficina.findAll", query = "SELECT o FROM Oficina o"),
    @NamedQuery(name = "Oficina.findByCodigoOficina", query = "SELECT o FROM Oficina o WHERE o.codigoOficina = :codigoOficina"),
    @NamedQuery(name = "Oficina.findByCiudad", query = "SELECT o FROM Oficina o WHERE o.ciudad = :ciudad"),
    @NamedQuery(name = "Oficina.findByPais", query = "SELECT o FROM Oficina o WHERE o.pais = :pais"),
    @NamedQuery(name = "Oficina.findByRegion", query = "SELECT o FROM Oficina o WHERE o.region = :region"),
    @NamedQuery(name = "Oficina.findByCodigoPostal", query = "SELECT o FROM Oficina o WHERE o.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "Oficina.findByTelefono", query = "SELECT o FROM Oficina o WHERE o.telefono = :telefono"),
    @NamedQuery(name = "Oficina.findByLineaDireccion1", query = "SELECT o FROM Oficina o WHERE o.lineaDireccion1 = :lineaDireccion1"),
    @NamedQuery(name = "Oficina.findByLineaDireccion2", query = "SELECT o FROM Oficina o WHERE o.lineaDireccion2 = :lineaDireccion2")})
public class Oficina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_oficina")
    private String codigoOficina;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;
    @Column(name = "region")
    private String region;
    @Basic(optional = false)
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "linea_direccion1")
    private String lineaDireccion1;
    @Column(name = "linea_direccion2")
    private String lineaDireccion2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoOficina")
    private List<Empleado> empleadoList;

    public Oficina() {
    }

    public Oficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public Oficina(String codigoOficina, String ciudad, String pais, String codigoPostal, String telefono, String lineaDireccion1) {
        this.codigoOficina = codigoOficina;
        this.ciudad = ciudad;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
        this.lineaDireccion1 = lineaDireccion1;
    }

    public String getCodigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLineaDireccion1() {
        return lineaDireccion1;
    }

    public void setLineaDireccion1(String lineaDireccion1) {
        this.lineaDireccion1 = lineaDireccion1;
    }

    public String getLineaDireccion2() {
        return lineaDireccion2;
    }

    public void setLineaDireccion2(String lineaDireccion2) {
        this.lineaDireccion2 = lineaDireccion2;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOficina != null ? codigoOficina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oficina)) {
            return false;
        }
        Oficina other = (Oficina) object;
        if ((this.codigoOficina == null && other.codigoOficina != null) || (this.codigoOficina != null && !this.codigoOficina.equals(other.codigoOficina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Oficina[ codigoOficina=" + codigoOficina + " ]";
    }
    
}
