import java.util.*;

public class UseCase19TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("====================================\n");

        // Sorted bogie IDs (IMPORTANT)
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchKey = "BG309";

        int low = 0;
        int high = bogieIds.length - 1;

        boolean found = false;

        // ---- BINARY SEARCH ----
        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = bogieIds[mid].compareTo(searchKey);

            if (cmp == 0) {
                found = true;
                break;
            } else if (cmp < 0) {
                low = mid + 1;   // search right
            } else {
                high = mid - 1;  // search left
            }
        }

        // ---- RESULT ----
        if (found) {
            System.out.println("Bogie Found: " + searchKey);
        } else {
            System.out.println("Bogie NOT Found: " + searchKey);
        }
    }
}
