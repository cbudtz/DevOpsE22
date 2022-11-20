package filter;

import data.User;
import jakarta.annotation.Priority;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

import static jakarta.ws.rs.core.Response.Status.UNAUTHORIZED;

@Provider
@Priority(1000)
@Log4j2
public class AuthFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        System.out.println(context.getUriInfo().getPath());
        var token = context.getHeaderString("Authorization");
        log.error("Token: " + token);
//        if ("login".equals(context.getUriInfo().getPath())) return ;
//        if (token==null){ //TODO Real validation!
//            context.abortWith(Response.status(UNAUTHORIZED).build());
//        }
    }
}
