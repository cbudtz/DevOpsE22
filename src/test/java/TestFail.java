import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.platform.commons.function.Try.success;

public class TestFail {

    @Test
    public void throwError(){
        success("Everything as expected");
    }
}
