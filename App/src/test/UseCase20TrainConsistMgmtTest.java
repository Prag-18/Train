import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase20TrainConsistMgmtTest {

    // Helper method
    private boolean search(String[] arr, String key) {

        // ---- FAIL-FAST CHECK ----
        if (arr.length == 0) {
            throw new IllegalStateException("No bogies available");
        }

        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testSearch_EmptyArray_ShouldThrowException() {
        String[] arr = {};
        assertThrows(IllegalStateException.class, () -> search(arr, "BG101"));
    }

    @Test
    public void testSearch_BogieFound() {
        String[] arr = {"BG101", "BG205", "BG309"};

        assertTrue(search(arr, "BG205"));
    }

    @Test
    public void testSearch_BogieNotFound() {
        String[] arr = {"BG101", "BG205", "BG309"};

        assertFalse(search(arr, "BG999"));
    }

    @Test
    public void testSearch_SingleElement() {
        String[] arr = {"BG101"};

        assertTrue(search(arr, "BG101"));
    }

    @Test
    public void testSearch_MultipleElements() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412"};

        assertTrue(search(arr, "BG412"));
    }
}
