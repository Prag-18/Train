import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmtTest {

    static class Bogie {
        int capacity;

        Bogie(int capacity) {
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    private List<Bogie> generateData(int size) {
        List<Bogie> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            list.add(new Bogie(i));
        }
        return list;
    }

    private int sumUsingLoop(List<Bogie> list) {
        int sum = 0;
        for (Bogie b : list) {
            sum += b.getCapacity();
        }
        return sum;
    }

    private int sumUsingStream(List<Bogie> list) {
        return list.stream().mapToInt(Bogie::getCapacity).sum();
    }

    @Test
    public void testSumEquality_SmallData() {
        List<Bogie> list = generateData(10);

        assertEquals(sumUsingLoop(list), sumUsingStream(list));
    }

    @Test
    public void testSumEquality_LargeData() {
        List<Bogie> list = generateData(1000);

        assertEquals(sumUsingLoop(list), sumUsingStream(list));
    }

    @Test
    public void testEmptyList() {
        List<Bogie> list = new ArrayList<>();

        assertEquals(0, sumUsingLoop(list));
        assertEquals(0, sumUsingStream(list));
    }

    @Test
    public void testSingleElement() {
        List<Bogie> list = Arrays.asList(new Bogie(50));

        assertEquals(50, sumUsingLoop(list));
        assertEquals(50, sumUsingStream(list));
    }
}
