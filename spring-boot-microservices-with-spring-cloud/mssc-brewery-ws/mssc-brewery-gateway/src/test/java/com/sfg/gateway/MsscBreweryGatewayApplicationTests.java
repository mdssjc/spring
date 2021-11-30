package com.sfg.gateway;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marcelo dos Santos
 */
@SpringBootTest
class MsscBreweryGatewayApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> MsscBreweryGatewayApplication.main(new String[]{}));
    }
}
