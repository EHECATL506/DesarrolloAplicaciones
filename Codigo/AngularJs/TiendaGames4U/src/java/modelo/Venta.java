/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdventa", query = "SELECT v FROM Venta v WHERE v.ventaPK.idventa = :idventa")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Venta.findByMonto", query = "SELECT v FROM Venta v WHERE v.monto = :monto")
    , @NamedQuery(name = "Venta.findByVideojuegoIdvideojuego", query = "SELECT v FROM Venta v WHERE v.ventaPK.videojuegoIdvideojuego = :videojuegoIdvideojuego")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentaPK ventaPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "monto")
    private BigInteger monto;

    public Venta() {
    }

    public Venta(VentaPK ventaPK) {
        this.ventaPK = ventaPK;
    }

    public Venta(int idventa, int videojuegoIdvideojuego) {
        this.ventaPK = new VentaPK(idventa, videojuegoIdvideojuego);
    }

    public VentaPK getVentaPK() {
        return ventaPK;
    }

    public void setVentaPK(VentaPK ventaPK) {
        this.ventaPK = ventaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getMonto() {
        return monto;
    }

    public void setMonto(BigInteger monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaPK != null ? ventaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.ventaPK == null && other.ventaPK != null) || (this.ventaPK != null && !this.ventaPK.equals(other.ventaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Venta[ ventaPK=" + ventaPK + " ]";
    }
    
}
