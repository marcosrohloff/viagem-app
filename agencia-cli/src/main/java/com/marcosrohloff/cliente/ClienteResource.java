package com.marcosrohloff.cliente;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/cliente-cli")
public class ClienteResource {

    @Inject
    @RestClient
    ClienteService clienteService;

    @GET
    @Path("newCliente")
    public String newCliente(){
        Cliente cliente = Cliente.of(99, "Remoto");
        return clienteService.newCliente(cliente);
    }

}
