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
public class CompraPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idcompra")
    private int idcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "videojuego_idvideojuego")
    private int videojuegoIdvideojuego;

    public CompraPK() {
    }

    public CompraPK(int idcompra, int videojuegoIdvideojuego) {
        this.idcompra = idcompra;
        this.videojuegoIdvideojuego = videojuegoIdvideojuego;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
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
        hash += (int) idcompra;
        hash += (int) videojuegoIdvideojuego;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraPK)) {
            return false;
        }
        CompraPK other = (CompraPK) object;
        if (this.idcompra != other.idcompra) {
            return false;
        }
        if (this.videojuegoIdvideojuego != other.videojuegoIdvideojuego) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CompraPK[ idcompra=" + idcompra + ", videojuegoIdvideojuego=" + videojuegoIdvideojuego + " ]";
    }
    
}
