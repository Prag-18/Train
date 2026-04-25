import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase18TrainConsistMgmtTest {

    // Helper method
    private boolean linearSearch(String[] arr, String key) {
        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testSearch_BogieFound() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412"};

        assertTrue(linearSearch(arr, "BG309"));
    }

    @Test
    public void testSearch_BogieNotFound() {
        String[] arr = {"BG101", "BG205", "BG309"};

        assertFalse(linearSearch(arr, "BG999"));
    }

    @Test
    public void testSearch_FirstElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309"};

        assertTrue(linearSearch(arr, "BG101"));
    }

    @Test
    public void testSearch_LastElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309"};

        assertTrue(linearSearch(arr, "BG309"));
    }

    @Test
    public void testSearch_SingleElement() {
        String[] arr = {"BG101"};

        assertTrue(linearSearch(arr, "BG101"));
    }

    @Test
    public void testSearch_EmptyArray() {
        String[] arr = {};

        assertFalse(linearSearch(arr, "BG101"));
    }
}
