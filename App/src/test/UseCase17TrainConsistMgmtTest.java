import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase17TrainConsistMgmtTest {

    // Helper method
    private String[] sortArray(String[] arr) {
        String[] copy = arr.clone(); // avoid modifying original
        Arrays.sort(copy);
        return copy;
    }

    @Test
    public void testSort_NormalCase() {
        String[] arr = {"Sleeper", "AC Chair", "General"};

        String[] sorted = sortArray(arr);

        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper"}, sorted);
    }

    @Test
    public void testSort_AlreadySorted() {
        String[] arr = {"AC Chair", "General", "Sleeper"};

        String[] sorted = sortArray(arr);

        assertArrayEquals(arr, sorted);
    }

    @Test
    public void testSort_ReverseOrder() {
        String[] arr = {"Sleeper", "General", "AC Chair"};

        String[] sorted = sortArray(arr);

        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper"}, sorted);
    }

    @Test
    public void testSort_SingleElement() {
        String[] arr = {"Sleeper"};

        String[] sorted = sortArray(arr);

        assertArrayEquals(new String[]{"Sleeper"}, sorted);
    }

    @Test
    public void testSort_EmptyArray() {
        String[] arr = {};

        String[] sorted = sortArray(arr);

        assertArrayEquals(new String[]{}, sorted);
    }
}
