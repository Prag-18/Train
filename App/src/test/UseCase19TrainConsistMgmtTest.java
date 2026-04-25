import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase19TrainConsistMgmtTest {

    // Helper method
    private boolean binarySearch(String[] arr, String key) {
        Arrays.sort(arr); // ensure sorted

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].compareTo(key);

            if (cmp == 0) return true;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    @Test
    public void testSearch_BogieFound() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412"};

        assertTrue(binarySearch(arr, "BG309"));
    }

    @Test
    public void testSearch_BogieNotFound() {
        String[] arr = {"BG101", "BG205", "BG309"};

        assertFalse(binarySearch(arr, "BG999"));
    }

    @Test
    public void testSearch_FirstElement() {
        String[] arr = {"BG101", "BG205", "BG309"};

        assertTrue(binarySearch(arr, "BG101"));
    }

    @Test
    public void testSearch_LastElement() {
        String[] arr = {"BG101", "BG205", "BG309"};

        assertTrue(binarySearch(arr, "BG309"));
    }

    @Test
    public void testSearch_SingleElement() {
        String[] arr = {"BG101"};

        assertTrue(binarySearch(arr, "BG101"));
    }

    @Test
    public void testSearch_EmptyArray() {
        String[] arr = {};

        assertFalse(binarySearch(arr, "BG101"));
    }

    @Test
    public void testSearch_UnsortedInput() {
        String[] arr = {"BG309", "BG101", "BG205"};

        assertTrue(binarySearch(arr, "BG205")); // sorting handled inside
    }
}
