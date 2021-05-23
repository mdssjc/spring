package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Marcelo dos Santos
 */
class FooTest {

    @Test
    void getBar() {
        Foo foo = new Foo();

        String result = foo.getBar();

        assertEquals("Foobar", result);
    }
}
