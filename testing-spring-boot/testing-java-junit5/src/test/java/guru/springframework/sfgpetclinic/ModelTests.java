package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Marcelo dos Santos
 */
@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void beforeEachPrint(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }
}
