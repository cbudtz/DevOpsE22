import data.User;
import org.junit.jupiter.api.Test;
import service.JWTHandler;

import static org.junit.jupiter.api.Assertions.*;

class JWTHandlerTest {

    @Test
    void generateJwtToken() {
        User melman = User.builder().username("melman").build();
        String s = JWTHandler.generateJwtToken(melman);
        User retrieved = JWTHandler.validate(s);
        System.out.println(retrieved);

    }
}