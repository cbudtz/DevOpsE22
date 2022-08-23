package service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("hello")
public class HelloService {
    @GET
    public String getHello(){
        return "Hello Devops-API!";
    }
}
