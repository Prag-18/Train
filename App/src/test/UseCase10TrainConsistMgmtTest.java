import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmtTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    // Helper method
    private int calculateTotal(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    @Test
    public void testTotalSeats_NormalCase() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        assertEquals(152, calculateTotal(list));
    }

    @Test
    public void testTotalSeats_EmptyList() {
        List<Bogie> list = new ArrayList<>();

        assertEquals(0, calculateTotal(list));
    }

    @Test
    public void testTotalSeats_SingleBogie() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70)
        );

        assertEquals(70, calculateTotal(list));
    }

    @Test
    public void testTotalSeats_MultipleSameType() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("Sleeper", 70)
        );

        assertEquals(140, calculateTotal(list));
    }

    @Test
    public void testTotalSeats_ZeroCapacity() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 0),
                new Bogie("AC Chair", 50)
        );

        assertEquals(50, calculateTotal(list));
    }
}
