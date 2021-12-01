package guru.sfg.brewery.configserver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marcelo dos Santos
 */
@SpringBootTest
class MsscConfigServerApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> MsscConfigServerApplication.main(new String[]{}));
    }
}
