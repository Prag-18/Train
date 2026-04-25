import java.util.*;

public class UseCase12TrainConsistMgmt {

    // Goods Bogie class
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape, String cargo) {
            this.shape = shape;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return shape + " -> " + cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC12 - Safety Compliance Check");
        System.out.println("====================================\n");

        // Create goods bogies
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Cylindrical", "Gas")
        );

        // ---- SAFETY RULE ----
        // Rectangular bogie should NOT carry Petroleum
        boolean isSafe = bogies.stream().allMatch(b ->
                !(b.shape.equals("Rectangular") && b.cargo.equals("Petroleum"))
        );

        // Display result
        bogies.forEach(System.out::println);

        System.out.println("\nSafety Status: " +
                (isSafe ? "SAFE" : "UNSAFE"));
    }
}
