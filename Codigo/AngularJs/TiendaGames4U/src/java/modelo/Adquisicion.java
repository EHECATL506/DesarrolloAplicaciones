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
@Table(name = "adquisicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adquisicion.findAll", query = "SELECT a FROM Adquisicion a")
    , @NamedQuery(name = "Adquisicion.findByIdadquisicion", query = "SELECT a FROM Adquisicion a WHERE a.adquisicionPK.idadquisicion = :idadquisicion")
    , @NamedQuery(name = "Adquisicion.findByFecha", query = "SELECT a FROM Adquisicion a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Adquisicion.findByMonto", query = "SELECT a FROM Adquisicion a WHERE a.monto = :monto")
    , @NamedQuery(name = "Adquisicion.findByVideojuegoIdvideojuego", query = "SELECT a FROM Adquisicion a WHERE a.adquisicionPK.videojuegoIdvideojuego = :videojuegoIdvideojuego")})
public class Adquisicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdquisicionPK adquisicionPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "monto")
    private BigInteger monto;

    public Adquisicion() {
    }

    public Adquisicion(AdquisicionPK adquisicionPK) {
        this.adquisicionPK = adquisicionPK;
    }

    public Adquisicion(int idadquisicion, int videojuegoIdvideojuego) {
        this.adquisicionPK = new AdquisicionPK(idadquisicion, videojuegoIdvideojuego);
    }

    public AdquisicionPK getAdquisicionPK() {
        return adquisicionPK;
    }

    public void setAdquisicionPK(AdquisicionPK adquisicionPK) {
        this.adquisicionPK = adquisicionPK;
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
        hash += (adquisicionPK != null ? adquisicionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adquisicion)) {
            return false;
        }
        Adquisicion other = (Adquisicion) object;
        if ((this.adquisicionPK == null && other.adquisicionPK != null) || (this.adquisicionPK != null && !this.adquisicionPK.equals(other.adquisicionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Adquisicion[ adquisicionPK=" + adquisicionPK + " ]";
    }
    
}
