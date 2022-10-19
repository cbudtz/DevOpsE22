package service;


import data.UserLogin;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("login")
public class LoginService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String login(UserLogin userLogin){
        if (userLogin!=null && "brian".equals(userLogin.username) && "kodeord".equals(userLogin.getPassword())) {
            return "very secret token!";
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
}
