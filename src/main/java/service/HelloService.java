package service;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;

@Path("hello")
public class HelloService {
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
