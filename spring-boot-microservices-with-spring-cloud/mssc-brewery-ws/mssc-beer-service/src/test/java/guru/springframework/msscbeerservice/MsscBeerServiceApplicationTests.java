package guru.springframework.msscbeerservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marcelo dos Santos
 */
@SpringBootTest
public class MsscBeerServiceApplicationTests {

    @Test
    public void contextLoads() {
        Assertions.assertDoesNotThrow(() -> MsscBeerServiceApplication.main(new String[]{}));
    }
}
