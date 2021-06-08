package guru.springframework;

import org.junit.jupiter.api.Test;

/**
 * @author Marcelo dos Santos
 */
class GreetingTest {

    @Test
    void helloWorld() {
        Greeting greeting = new Greeting();

        System.out.println(greeting.helloWorld());
    }

    @Test
    void testHelloWorld() {
        Greeting greeting = new Greeting();

        System.out.println(greeting.helloWorld("Marcelo"));
    }
}
