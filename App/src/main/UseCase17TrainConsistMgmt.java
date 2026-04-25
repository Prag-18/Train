import java.util.*;

public class UseCase17TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC17 - Sort Bogie Names using Arrays.sort()");
        System.out.println("====================================\n");

        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General"
        };

        System.out.println("Before Sorting:");
        printArray(bogieNames);

        // ---- BUILT-IN SORT ----
        Arrays.sort(bogieNames);

        System.out.println("\nAfter Sorting:");
        printArray(bogieNames);
    }

    static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
