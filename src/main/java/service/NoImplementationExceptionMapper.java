package service;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NoImplementationExceptionMapper implements ExceptionMapper<NoImplementationException> {

    @Override
    public Response toResponse(NoImplementationException e) {
        return Response.status(Response.Status.NOT_IMPLEMENTED).entity(e.getMessage()).build();
    }
}