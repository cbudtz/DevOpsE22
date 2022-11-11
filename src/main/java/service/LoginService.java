package service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import data.LoginData;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;

import java.util.Calendar;


@Path("login")
public class LoginService {
    private static final int TOKEN_EXPIRY = 2880;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginData userLogin){
        if (userLogin!=null && "brian".equals(userLogin.username) && "kodeord".equals(userLogin.getPassword())) {
            Calendar expiry = Calendar.getInstance();
            expiry.add(Calendar.MINUTE, TOKEN_EXPIRY);
            String token = JWT.create()
                    .withIssuer("girafbutikken")
                    .withExpiresAt(expiry.getTime())
                    .withClaim("user",userLogin.username)
                    .sign(Algorithm.HMAC512("secret"));
            return Response.ok().cookie(new NewCookie.Builder("giraf")
                    .httpOnly(true)
                    .build()).build();
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
}
