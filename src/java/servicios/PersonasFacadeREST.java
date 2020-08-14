/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import java.util.Scanner;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import modelo.Personas;
import static modelo.Personas_.idpersonas;

/**
 *
 * @author Alexander
 */
@Stateless
@Path("modelo.personas")
public class PersonasFacadeREST extends AbstractFacade<Personas> {

    @PersistenceContext(unitName = "ejemploPrimePU")
    private EntityManager em;

    public PersonasFacadeREST() {
        super(Personas.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Personas entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Personas entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Personas find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Personas> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Personas> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("idpersonas") Integer idpersonas, @FormParam("nombre") String nombre,
            @FormParam("apellido") String apellido, @FormParam("telefono") String telefono) {
        Personas e = new Personas(idpersonas, nombre, apellido, telefono);
        super.create(e);
        return "el objeto se creo con exito";
    }

    @POST
    @Path("read")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Personas> leeraplellido(@FormParam("apellido") String apellido) {
        TypedQuery consulta = getEntityManager().createQuery("SELECT p FROM Personas p WHERE p.apellido = :apellido", Personas.class);
        consulta.setParameter("apellido", apellido);
        return consulta.getResultList();
    }
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("idpersonas") Integer idpersonas, @FormParam("nombre") String nombre,
            @FormParam("apellido") String apellido, @FormParam("telefono") String telefono) {
        Personas e = super.find(idpersonas);
//        e.setIdpersonas(idpersonas);
        e.setNombre(nombre);
        e.setApellido(apellido);
        e.setTelefono(telefono);
        super.create(e);
        return "el objeto se edito con exito";
    }
 @Path("eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String eliminar(@FormParam("idpersonas") Integer idpersonaso) {
        Personas e = super.find(idpersonas);
        
        if(e == null){
            return ("no se econtro objeto");
        }else{
            super.remove(e);
            return ("se elimino");
        }
        
    }

    @GET
    @Path("suma")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String suma(@QueryParam("a") int a, @QueryParam("b") int b) {
        int c;
        c = a + b;
        System.out.println(c);
        return "" + c;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    //1,3,5,7,9
    @GET
    @Path("serie")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String serie(@QueryParam("n") int n) {
        int a,b;
                int c = 0;
        
       
        a=-1;
        b=1;
        for (int i = 0; i <=n; i++) {
            c=a+b;
            a=b;
            b=c;
            
                    }
        return ""+c;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
