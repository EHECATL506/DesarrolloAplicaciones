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
public class AdquisicionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idadquisicion")
    private int idadquisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "videojuego_idvideojuego")
    private int videojuegoIdvideojuego;

    public AdquisicionPK() {
    }

    public AdquisicionPK(int idadquisicion, int videojuegoIdvideojuego) {
        this.idadquisicion = idadquisicion;
        this.videojuegoIdvideojuego = videojuegoIdvideojuego;
    }

    public int getIdadquisicion() {
        return idadquisicion;
    }

    public void setIdadquisicion(int idadquisicion) {
        this.idadquisicion = idadquisicion;
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
        hash += (int) idadquisicion;
        hash += (int) videojuegoIdvideojuego;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdquisicionPK)) {
            return false;
        }
        AdquisicionPK other = (AdquisicionPK) object;
        if (this.idadquisicion != other.idadquisicion) {
            return false;
        }
        if (this.videojuegoIdvideojuego != other.videojuegoIdvideojuego) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AdquisicionPK[ idadquisicion=" + idadquisicion + ", videojuegoIdvideojuego=" + videojuegoIdvideojuego + " ]";
    }
    
}
