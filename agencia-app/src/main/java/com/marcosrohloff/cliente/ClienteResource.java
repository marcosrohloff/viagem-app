package com.marcosrohloff.cliente;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cliente")
public class ClienteResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> get() {
        return Cliente.listAll();
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente findById(@QueryParam("id") long id) {
        return Cliente.findById(id);
    }

    @Transactional
    @DELETE
    @Path("deleteById")
    public void deleteById(@QueryParam("id") long id) {
        Cliente.deleteById(id);
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCliente(Cliente cliente) {
        cliente.id = null;
        cliente.persist();
        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }

}
