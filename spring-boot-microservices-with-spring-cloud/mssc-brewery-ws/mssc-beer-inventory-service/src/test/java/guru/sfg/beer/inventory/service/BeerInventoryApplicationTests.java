package guru.sfg.beer.inventory.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marcelo dos Santos
 */
@SpringBootTest
public class BeerInventoryApplicationTests {

    @Test
    public void contextLoads() {
        Assertions.assertDoesNotThrow(() -> BeerInventoryApplication.main(new String[]{}));
    }
}
