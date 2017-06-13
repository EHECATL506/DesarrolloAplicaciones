/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "videojuego")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Videojuego.findAll", query = "SELECT v FROM Videojuego v")
    , @NamedQuery(name = "Videojuego.findByIdVideojuego", query = "SELECT v FROM Videojuego v WHERE v.idvideojuego = :idvideojuego")
    , @NamedQuery(name = "Videojuego.findByDisponibilidad", query = "SELECT v FROM Videojuego v WHERE v.disponibilidad = :disponibilidad")
    , @NamedQuery(name = "Videojuego.findByFechaDePublicacion", query = "SELECT v FROM Videojuego v WHERE v.fechaDePublicacion = :fechaDePublicacion")
    , @NamedQuery(name = "Videojuego.findByGenero", query = "SELECT v FROM Videojuego v WHERE v.genero = :genero")
    , @NamedQuery(name = "Videojuego.findByNombre", query = "SELECT v FROM Videojuego v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Videojuego.findByClasificacion", query = "SELECT v FROM Videojuego v WHERE v.clasificacion = :clasificacion")
    , @NamedQuery(name = "Videojuego.findByPrecioDeVenta", query = "SELECT v FROM Videojuego v WHERE v.precioDeVenta = :precioDeVenta")
    , @NamedQuery(name = "Videojuego.findByPrecioDeCompra", query = "SELECT v FROM Videojuego v WHERE v.precioDeCompra = :precioDeCompra")})
public class Videojuego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvideojuego")
    private Integer idvideojuego;
    @Column(name = "disponibilidad")
    private Short disponibilidad;
    @Column(name = "fecha_de_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaDePublicacion;
    @Size(max = 45)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2)
    @Column(name = "clasificacion")
    private String clasificacion;
    @Column(name = "precio_de_venta")
    private BigInteger precioDeVenta;
    @Column(name = "precio_de_compra")
    private BigInteger precioDeCompra;

    public Videojuego() {
    }

    public Videojuego(Integer idVideojuego) {
        this.idvideojuego = idVideojuego;
    }

    public Videojuego(Integer idVideojuego, String nombre) {
        this.idvideojuego = idVideojuego;
        this.nombre = nombre;
    }

    public Integer getIdvideojuego() {
        return idvideojuego;
    }

    public void setIdvideojuego(Integer idvideojuego) {
        this.idvideojuego = idvideojuego;
    }

    public Short getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Short disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Date getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(Date fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public BigInteger getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(BigInteger precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public BigInteger getPrecioDeCompra() {
        return precioDeCompra;
    }

    public void setPrecioDeCompra(BigInteger precioDeCompra) {
        this.precioDeCompra = precioDeCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvideojuego != null ? idvideojuego.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videojuego)) {
            return false;
        }
        Videojuego other = (Videojuego) object;
        if ((this.idvideojuego == null && other.idvideojuego != null) || (this.idvideojuego != null && !this.idvideojuego.equals(other.idvideojuego))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Videojuego[ idvideojuego=" + idvideojuego + " ]";
    }
    
}
