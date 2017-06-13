/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andres
 */
@Embeddable
public class VentaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idventa")
    private int idventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "videojuego_idvideojuego")
    private int videojuegoIdvideojuego;

    public VentaPK() {
    }

    public VentaPK(int idventa, int videojuegoIdvideojuego) {
        this.idventa = idventa;
        this.videojuegoIdvideojuego = videojuegoIdvideojuego;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getVideojuegoIdvideojuego() {
        return videojuegoIdvideojuego;
    }

    public void setVideojuegoIdvideojuego(int videojuegoIdvideojuego) {
        this.videojuegoIdvideojuego = videojuegoIdvideojuego;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idventa;
        hash += (int) videojuegoIdvideojuego;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaPK)) {
            return false;
        }
        VentaPK other = (VentaPK) object;
        if (this.idventa != other.idventa) {
            return false;
        }
        if (this.videojuegoIdvideojuego != other.videojuegoIdvideojuego) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.VentaPK[ idventa=" + idventa + ", videojuegoIdvideojuego=" + videojuegoIdvideojuego + " ]";
    }
    
}
