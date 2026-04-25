public class UseCase18TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("====================================\n");

        // Array of bogie IDs (unsorted)
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchKey = "BG309";

        boolean found = false;

        // ---- LINEAR SEARCH ----
        for (String id : bogieIds) {
            if (id.equals(searchKey)) {
                found = true;
                break; // early termination
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
