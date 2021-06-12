package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Marcelo dos Santos
 */
@Tag("model")
public interface ModelRepeatedTests {

    @BeforeEach
    default void beforeEachPrint(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " :: " + repetitionInfo.getCurrentRepetition() + " - " + repetitionInfo
                .getTotalRepetitions());
    }
}
