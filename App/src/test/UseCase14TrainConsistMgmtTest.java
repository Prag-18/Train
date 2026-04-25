import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgmtTest {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String msg) {
            super(msg);
        }
    }

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0)
                throw new InvalidCapacityException("Invalid capacity");
            this.name = name;
            this.capacity = capacity;
        }
    }

    @Test
    public void testValidCapacity() throws Exception {
        Bogie b = new Bogie("Sleeper", 72);
        assertEquals(72, b.capacity);
    }

    @Test
    public void testNegativeCapacity() {
        assertThrows(InvalidCapacityException.class, () -> new Bogie("AC Chair", -10));
    }

    @Test
    public void testZeroCapacity() {
        assertThrows(InvalidCapacityException.class, () -> new Bogie("General", 0));
    }

    @Test
    public void testMultipleValidBogies() throws Exception {
        Bogie b1 = new Bogie("Sleeper", 70);
        Bogie b2 = new Bogie("AC Chair", 50);

        assertEquals(70, b1.capacity);
        assertEquals(50, b2.capacity);
    }

    @Test
    public void testExceptionMessage() {
        InvalidCapacityException e = assertThrows(
                InvalidCapacityException.class,
                () -> new Bogie("First Class", -5)
        );
        assertTrue(e.getMessage().contains("Invalid"));
    }
}
