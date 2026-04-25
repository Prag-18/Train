import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmtTest {

    // Helper methods
    private boolean isValidTrainId(String id) {
        return Pattern.matches("TRN-\\d{4}", id);
    }

    private boolean isValidCargoCode(String code) {
        return Pattern.matches("CG-\\d{4}", code);
    }

    // ---- TRAIN ID TESTS ----

    @Test
    public void testTrainId_Valid() {
        assertTrue(isValidTrainId("TRN-1234"));
    }

    @Test
    public void testTrainId_InvalidFormat() {
        assertFalse(isValidTrainId("TRAIN1234"));
    }

    @Test
    public void testTrainId_InvalidCharacters() {
        assertFalse(isValidTrainId("TRN-12A4"));
    }

    @Test
    public void testTrainId_ShortLength() {
        assertFalse(isValidTrainId("TRN-123"));
    }

    @Test
    public void testTrainId_LongLength() {
        assertFalse(isValidTrainId("TRN-12345"));
    }

    // ---- CARGO CODE TESTS ----

    @Test
    public void testCargoCode_Valid() {
        assertTrue(isValidCargoCode("CG-5678"));
    }

    @Test
    public void testCargoCode_InvalidFormat() {
        assertFalse(isValidCargoCode("CARGO5678"));
    }

    @Test
    public void testCargoCode_InvalidCharacters() {
        assertFalse(isValidCargoCode("CG-56A8"));
    }

    @Test
    public void testCargoCode_ShortLength() {
        assertFalse(isValidCargoCode("CG-123"));
    }

    @Test
    public void testCargoCode_LongLength() {
        assertFalse(isValidCargoCode("CG-12345"));
    }
}
