package service;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;

@Path("hello")
public class HelloService {
    @Context
    ServletContext ctx;
    @GET
    public String getHello(){
        return "Hello Devops-API!";
    }
    @GET
    @Path("echo")
    public String getEcho(@NotNull(message = "Must not be Null") @QueryParam("echo") String echoString)
            throws CustomException {
        if ("homer".equals(echoString)) throw new CustomException("Duh");

        return echoString;
    }
}
