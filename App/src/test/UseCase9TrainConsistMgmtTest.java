import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmtTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }
    }

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("Sleeper", 70),
                new Bogie("General", 90),
                new Bogie("AC Chair", 60)
        );
    }

    @Test
    public void testGrouping_BasicGrouping() {
        Map<String, List<Bogie>> result =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(3, result.size()); // Sleeper, AC Chair, General
    }

    @Test
    public void testGrouping_SleeperCount() {
        Map<String, List<Bogie>> result =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    public void testGrouping_ACChairCount() {
        Map<String, List<Bogie>> result =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    public void testGrouping_SingleCategory() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("Sleeper", 60)
        );

        Map<String, List<Bogie>> result =
                list.stream().collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(1, result.size());
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    public void testGrouping_EmptyList() {
        List<Bogie> list = new ArrayList<>();

        Map<String, List<Bogie>> result =
                list.stream().collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGrouping_AllDifferentTypes() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 50),
                new Bogie("General", 90)
        );

        Map<String, List<Bogie>> result =
                list.stream().collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(3, result.size());
    }
}
