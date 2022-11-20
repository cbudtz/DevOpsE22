package service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("giraffes")
public class GiraffeService {
    static List<String> giraffes = new ArrayList<>(Arrays.asList("Melman","Elmer"));
    @GET
    public List<String> getGiraffes(){
        return giraffes;
    }

}
