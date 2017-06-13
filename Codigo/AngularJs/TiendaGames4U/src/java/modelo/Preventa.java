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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "preventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preventa.findAll", query = "SELECT p FROM Preventa p")
    , @NamedQuery(name = "Preventa.findByIdpreventa", query = "SELECT p FROM Preventa p WHERE p.idpreventa = :idpreventa")
    , @NamedQuery(name = "Preventa.findByMontoAdelantado", query = "SELECT p FROM Preventa p WHERE p.montoAdelantado = :montoAdelantado")
    , @NamedQuery(name = "Preventa.findByFecha", query = "SELECT p FROM Preventa p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Preventa.findByVentaIdventa", query = "SELECT p FROM Preventa p WHERE p.ventaIdventa = :ventaIdventa")
    , @NamedQuery(name = "Preventa.findByVentaVideojuegoIdvideojuego", query = "SELECT p FROM Preventa p WHERE p.ventaVideojuegoIdvideojuego = :ventaVideojuegoIdvideojuego")})
public class Preventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpreventa")
    private Integer idpreventa;
    @Column(name = "monto_adelantado")
    private BigInteger montoAdelantado;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_idventa")
    private int ventaIdventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_videojuego_idvideojuego")
    private int ventaVideojuegoIdvideojuego;

    public Preventa() {
    }

    public Preventa(Integer idpreventa) {
        this.idpreventa = idpreventa;
    }

    public Preventa(Integer idpreventa, int ventaIdventa, int ventaVideojuegoIdvideojuego) {
        this.idpreventa = idpreventa;
        this.ventaIdventa = ventaIdventa;
        this.ventaVideojuegoIdvideojuego = ventaVideojuegoIdvideojuego;
    }

    public Integer getIdpreventa() {
        return idpreventa;
    }

    public void setIdpreventa(Integer idpreventa) {
        this.idpreventa = idpreventa;
    }

    public BigInteger getMontoAdelantado() {
        return montoAdelantado;
    }

    public void setMontoAdelantado(BigInteger montoAdelantado) {
        this.montoAdelantado = montoAdelantado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getVentaIdventa() {
        return ventaIdventa;
    }

    public void setVentaIdventa(int ventaIdventa) {
        this.ventaIdventa = ventaIdventa;
    }

    public int getVentaVideojuegoIdvideojuego() {
        return ventaVideojuegoIdvideojuego;
    }

    public void setVentaVideojuegoIdvideojuego(int ventaVideojuegoIdvideojuego) {
        this.ventaVideojuegoIdvideojuego = ventaVideojuegoIdvideojuego;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpreventa != null ? idpreventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preventa)) {
            return false;
        }
        Preventa other = (Preventa) object;
        if ((this.idpreventa == null && other.idpreventa != null) || (this.idpreventa != null && !this.idpreventa.equals(other.idpreventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Preventa[ idpreventa=" + idpreventa + " ]";
    }
    
}
