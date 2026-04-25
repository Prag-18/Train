import java.util.*;
import java.util.stream.*;

public class UseCase9TrainConsistMgmt {

    // Bogie class
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

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("====================================\n");

        // Create list of bogies
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("Sleeper", 70),
                new Bogie("General", 90),
                new Bogie("AC Chair", 60)
        );

        // Group by bogie type
        Map<String, List<Bogie>> grouped =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        // Display result
        grouped.forEach((type, list) -> {
            System.out.println(type + ":");
            list.forEach(System.out::println);
            System.out.println();
        });
    }
}
