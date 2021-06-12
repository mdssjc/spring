package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Marcelo dos Santos
 */
class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L, "Joe", "Buck");

        // then
        assertAll("Test Props Set",
                  () -> assertEquals(person.getFirstName(), "Joe"),
                  () -> assertEquals(person.getLastName(), "Buck"));
    }

    @Test
    void groupedAssertionMsgs() {
        // given
        Person person = new Person(1L, "Joe", "Buck");

        // then
        assertAll("Test Props Set",
                  () -> assertEquals(person.getFirstName(), "Joe", "First Name Failed"),
                  () -> assertEquals(person.getLastName(), "Buck", "Last Name Failed"));
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {

    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }
}
