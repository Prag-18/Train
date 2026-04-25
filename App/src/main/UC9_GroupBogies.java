import java.util.*;
import java.util.stream.*;

public class UC9_GroupBogies {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("Sleeper", 70),
                new Bogie("General", 90)
        );

        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.name));

        grouped.forEach((k, v) -> {
            System.out.println(k + " -> " + v.size());
        });
    }
}