/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import modelo.Adquisicion;
import modelo.AdquisicionPK;

/**
 *
 * @author Andres
 */
@Stateless
@Path("modelo.adquisicion")
public class AdquisicionFacadeREST extends AbstractFacade<Adquisicion> {

    @PersistenceContext(unitName = "TiendaGames4UPU")
    private EntityManager em;

    private AdquisicionPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idadquisicion=idadquisicionValue;videojuegoIdvideojuego=videojuegoIdvideojuegoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        modelo.AdquisicionPK key = new modelo.AdquisicionPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idadquisicion = map.get("idadquisicion");
        if (idadquisicion != null && !idadquisicion.isEmpty()) {
            key.setIdadquisicion(new java.lang.Integer(idadquisicion.get(0)));
        }
        java.util.List<String> videojuegoIdvideojuego = map.get("videojuegoIdvideojuego");
        if (videojuegoIdvideojuego != null && !videojuegoIdvideojuego.isEmpty()) {
            key.setVideojuegoIdvideojuego(new java.lang.Integer(videojuegoIdvideojuego.get(0)));
        }
        return key;
    }

    public AdquisicionFacadeREST() {
        super(Adquisicion.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Adquisicion entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Adquisicion entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        modelo.AdquisicionPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Adquisicion find(@PathParam("id") PathSegment id) {
        modelo.AdquisicionPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Adquisicion> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Adquisicion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
