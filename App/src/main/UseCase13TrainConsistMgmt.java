import java.util.*;

public class UseCase13TrainConsistMgmt {

    static class Bogie {
        int capacity;

        Bogie(int capacity) {
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC13 - Performance Comparison (Loop vs Stream)");
        System.out.println("====================================\n");

        // Create large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            bogies.add(new Bogie(i));
        }

        // ---- LOOP APPROACH ----
        long startLoop = System.nanoTime();

        int sumLoop = 0;
        for (Bogie b : bogies) {
            sumLoop += b.getCapacity();
        }

        long endLoop = System.nanoTime();

        // ---- STREAM APPROACH ----
        long startStream = System.nanoTime();

        int sumStream = bogies.stream()
                .mapToInt(Bogie::getCapacity)
                .sum();

        long endStream = System.nanoTime();

        // ---- OUTPUT ----
        System.out.println("Loop Sum: " + sumLoop);
        System.out.println("Stream Sum: " + sumStream);

        System.out.println("\nLoop Time (ns): " + (endLoop - startLoop));
        System.out.println("Stream Time (ns): " + (endStream - startStream));
    }
}
