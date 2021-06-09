package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Marcelo dos Santos
 */
class PersonTest {

    @Test
    void groupedAsertions() {
        // given
        Person person = new Person(1L, "Joe", "Buck");

        // then
        assertAll("Test Props Set",
                  () -> assertEquals(person.getFirstName(), "Joe"),
                  () -> assertEquals(person.getLastName(), "Buck"));
    }

    @Test
    void groupedAsertionMsgs() {
        // given
        Person person = new Person(1L, "Joe", "Buck");

        // then
        assertAll("Test Props Set",
                  () -> assertEquals(person.getFirstName(), "Joe", "First Name Failed"),
                  () -> assertEquals(person.getLastName(), "Buck", "Last Name Failed"));
    }
}
