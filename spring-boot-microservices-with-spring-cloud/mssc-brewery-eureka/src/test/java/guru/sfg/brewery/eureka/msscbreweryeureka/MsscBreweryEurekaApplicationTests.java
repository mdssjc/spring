package guru.sfg.brewery.eureka.msscbreweryeureka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marcelo dos Santos
 */
@SpringBootTest
class MsscBreweryEurekaApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> MsscBreweryEurekaApplication.main(new String[]{}));
    }
}
