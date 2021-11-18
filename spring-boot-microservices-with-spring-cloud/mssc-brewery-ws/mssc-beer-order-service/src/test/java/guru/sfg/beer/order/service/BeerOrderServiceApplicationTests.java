package guru.sfg.beer.order.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marcelo dos Santos
 */
@SpringBootTest
class BeerOrderServiceApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> BeerOrderServiceApplication.main(new String[]{}));
    }
}
