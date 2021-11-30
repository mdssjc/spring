package guru.sfg.brewery.inventoryfailover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marcelo dos Santos
 */
@SpringBootTest
class SfgBreweryInventoryFailoverApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> SfgBreweryInventoryFailoverApplication.main(new String[]{}));
    }
}
