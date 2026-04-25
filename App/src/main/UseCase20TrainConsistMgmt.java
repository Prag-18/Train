public class UseCase20TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("====================================\n");

        // Bogie IDs (try empty and non-empty cases)
        String[] bogieIds = {};   // empty case

        String searchKey = "BG101";

        try {
            // ---- FAIL-FAST VALIDATION ----
            if (bogieIds.length == 0) {
                throw new IllegalStateException(
                        "No bogies available. Cannot perform search.");
            }

            // ---- SEARCH LOGIC (Linear Search) ----
            boolean found = false;

            for (String id : bogieIds) {
                if (id.equals(searchKey)) {
                    found = true;
                    break;
                }
            }

            // ---- RESULT ----
            if (found) {
                System.out.println("Bogie Found: " + searchKey);
            } else {
                System.out.println("Bogie NOT Found: " + searchKey);
            }

        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nUC20 execution completed...");
    }
}
