package service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import data.LoginData;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Calendar;


@Path("login")
public class LoginService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String login(LoginData userLogin){
        if (userLogin!=null && "brian".equals(userLogin.username) && "kodeord".equals(userLogin.getPassword())) {
            String token = JWT.create()
                    .withIssuer("girafbutikken")
                    .withExpiresAt(Calendar.getInstance().getTime())
                    .withClaim("user",userLogin.username)
                    .sign(Algorithm.HMAC512("secret"));
            return token;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
}
