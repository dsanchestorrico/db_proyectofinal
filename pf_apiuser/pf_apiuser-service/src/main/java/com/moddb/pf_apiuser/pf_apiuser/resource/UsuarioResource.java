/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.pf_apiuser.pf_apiuser.resource;

import com.moddb.pf_apiuser.pf_apiuser.model.Usuario;
import com.moddb.pf_apiuser.pf_apiuser.model.UsuarioDAO;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author daniel.sanchez
 */
@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioResource.class);
    private UsuarioDAO usuarioDAO;

    public UsuarioResource(final UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @GET
    public Response all() throws IOException, TimeoutException {
        LOGGER.info("Listando todos los usuarios.");
        final List<Usuario> usuarioFind = usuarioDAO.getAll();
        return Response.ok(usuarioFind).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@ApiParam(value = "id") @PathParam("id") @NotNull final ObjectId id) throws IOException, TimeoutException {
        LOGGER.info("Listando un usuario de la colleccion con identificador: " + id.toString());
        Usuario usuarioFind = usuarioDAO.get(id);
        return Response.ok(usuarioFind).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(final Usuario usuario) throws IOException, TimeoutException {
        LOGGER.info("Creando un usuario", usuario);
        usuarioDAO.save(usuario);
        return Response.status(Response.Status.CREATED).build();
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operation success.")
    })
    @DELETE
    @Path("/{id}")
    public Response delete(@ApiParam(value = "id") @PathParam("id") @NotNull final ObjectId id) {
        LOGGER.info("Eliminando un usuario de la colleccion con identificador: " + id.toString());
        usuarioDAO.delete(id);
        return Response.ok().build();
    }
}
