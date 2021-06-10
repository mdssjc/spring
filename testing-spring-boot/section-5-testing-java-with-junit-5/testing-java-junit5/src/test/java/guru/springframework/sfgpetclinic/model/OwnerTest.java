package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Marcelo dos Santos
 */
class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                  () -> assertAll("Person Properties",
                                  () -> assertEquals("Joe", owner.getFirstName(), "First Name Did Not Match"),
                                  () -> assertEquals("Buck", owner.getLastName())),
                  () -> assertAll("Owner Properties",
                                  () -> assertEquals("Key West", owner.getCity(), "City Did Not Match"),
                                  () -> assertEquals("1231231234", owner.getTelephone())));
    }
}
