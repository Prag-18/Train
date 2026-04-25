import java.util.regex.*;

public class UseCase11TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC11 - Validate Train ID & Cargo Code");
        System.out.println("====================================\n");

        String trainId = "TRN-1234";
        String cargoCode = "CG-5678";

        // Regex patterns
        String trainPattern = "TRN-\\d{4}";
        String cargoPattern = "CG-\\d{4}";

        boolean isTrainValid = Pattern.matches(trainPattern, trainId);
        boolean isCargoValid = Pattern.matches(cargoPattern, cargoCode);

        System.out.println("Train ID: " + trainId + " -> " +
                (isTrainValid ? "Valid" : "Invalid"));

        System.out.println("Cargo Code: " + cargoCode + " -> " +
                (isCargoValid ? "Valid" : "Invalid"));
    }
}
