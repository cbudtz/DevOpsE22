import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestFail {

    @Test
    public void throwError(){
        fail("Fail as expected");
    }
}
