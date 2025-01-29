package com.cultodeportivo.backendpruebaperalta.services;

import com.cultodeportivo.backendpruebaperalta.business.GestionBinomio;
import com.cultodeportivo.backendpruebaperalta.models.Binomio;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/binomios")
public class BinomioService {

    @Inject
    private GestionBinomio gestionBinomio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBinomios() {
        List<Binomio> binomios = gestionBinomio.getBinomios();
        return Response.ok(binomios).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBinomioById(@PathParam("id") Long id) {
        Binomio binomio = gestionBinomio.getBinomio(id);
        if (binomio != null) {
            return Response.ok().entity(binomio).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBinomio(Binomio binomio) {
        binomio.setId(null);
        try{
            gestionBinomio.guardarBinomio(binomio);
            return Response.status(Response.Status.CREATED)
                    .entity(binomio)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error al crear el usuario: " + e.getMessage())
                    .build();
        }

    }
}
