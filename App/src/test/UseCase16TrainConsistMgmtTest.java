import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase16TrainConsistMgmtTest {

    // Helper method for bubble sort
    private int[] bubbleSort(int[] arr) {
        int[] a = arr.clone(); // avoid modifying original

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    @Test
    public void testSort_NormalCase() {
        int[] arr = {72, 56, 24, 90};

        int[] sorted = bubbleSort(arr);

        assertArrayEquals(new int[]{24, 56, 72, 90}, sorted);
    }

    @Test
    public void testSort_AlreadySorted() {
        int[] arr = {10, 20, 30};

        int[] sorted = bubbleSort(arr);

        assertArrayEquals(new int[]{10, 20, 30}, sorted);
    }

    @Test
    public void testSort_ReverseOrder() {
        int[] arr = {90, 70, 50};

        int[] sorted = bubbleSort(arr);

        assertArrayEquals(new int[]{50, 70, 90}, sorted);
    }

    @Test
    public void testSort_SingleElement() {
        int[] arr = {50};

        int[] sorted = bubbleSort(arr);

        assertArrayEquals(new int[]{50}, sorted);
    }

    @Test
    public void testSort_EmptyArray() {
        int[] arr = {};

        int[] sorted = bubbleSort(arr);

        assertArrayEquals(new int[]{}, sorted);
    }
}
