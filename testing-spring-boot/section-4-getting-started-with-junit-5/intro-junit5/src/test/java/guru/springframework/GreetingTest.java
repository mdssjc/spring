package guru.springframework;

import org.junit.jupiter.api.*;

/**
 * @author Marcelo dos Santos
 */
class GreetingTest {

    private Greeting greeting;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before - I'm only called once!!!");
    }

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

    @AfterEach
    void tearDown() {
        System.out.println("In after each...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After - I'm only called once!!!");
    }
}
