package filter;

import data.User;
import jakarta.annotation.Priority;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Cookie;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

import static jakarta.ws.rs.core.Response.Status.UNAUTHORIZED;

@Provider
@Priority(1000)
public class AuthFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        System.out.println(context.getUriInfo().getPath());
        var token = context.getHeaderString("Authorization");
        System.out.println("Token: " + token);

//        if ("login".equals(context.getUriInfo().getPath())) return ;
//        Cookie giraf = context.getCookies().get("giraf");
//        System.out.println(giraf.getName());
//        if (token==null){ //TODO Real validation!
//            context.abortWith(Response.status(UNAUTHORIZED).build());
//        }
        //Else - Everything is Awesome!
    }
}
