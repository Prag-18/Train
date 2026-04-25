public class UseCase14TrainConsistMgmt {

    // ---- CUSTOM EXCEPTION ----
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ---- BOGIE CLASS ----
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) throws InvalidCapacityException {

            // ---- VALIDATION ----
            if (capacity <= 0) {
                throw new InvalidCapacityException(
                        "Invalid capacity for bogie: " + name);
            }

            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC14 - Custom Exception (Invalid Capacity)");
        System.out.println("====================================\n");

        try {
            Bogie b1 = new Bogie("Sleeper", 72);
            Bogie b2 = new Bogie("AC Chair", -10); // invalid

            System.out.println(b1);
            System.out.println(b2);

        } catch (InvalidCapacityException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nUC14 execution completed...");
    }
}
