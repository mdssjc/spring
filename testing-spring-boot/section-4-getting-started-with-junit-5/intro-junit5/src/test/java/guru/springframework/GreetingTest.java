package guru.springframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Marcelo dos Santos
 */
class GreetingTest {

    private Greeting greeting;

    @BeforeEach
    void setUp() {
        System.out.println("In before each...");

        greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        System.out.println(greeting.helloWorld());
    }

    @Test
    void testHelloWorld() {
        System.out.println(greeting.helloWorld("Marcelo"));
    }
}
