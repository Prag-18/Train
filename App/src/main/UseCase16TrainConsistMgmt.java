import java.util.*;

public class UseCase16TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC16 - Bubble Sort (Bogie Capacity)");
        System.out.println("====================================\n");

        int[] capacities = {72, 56, 24, 90, 60};

        System.out.println("Before Sorting:");
        printArray(capacities);

        // ---- BUBBLE SORT ----
        for (int i = 0; i < capacities.length - 1; i++) {
            for (int j = 0; j < capacities.length - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {
                    // swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        System.out.println("\nAfter Sorting:");
        printArray(capacities);
    }

    static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
