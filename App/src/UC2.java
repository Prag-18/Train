import java.util.*;
public class UC2 {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("    === UC2-Add Passenger Bogies to Train ===    ");
        System.out.println("=================================================");
        System.out.println("");
        List<String> trainConsist = new ArrayList<String>();
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        System.out.println("After Adding Bogies");
        System.out.println(trainConsist);
        System.out.println("");
        trainConsist.remove("AC Chair");
        System.out.println("After Removing 'AC Chair':");
        System.out.println(trainConsist);
        System.out.println("");
        System.out.println("Checking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? :" + trainConsist.contains("Sleeper"));
        System.out.println("");
        System.out.println("Final Train Passenger Consist:");
        System.out.println(trainConsist);
        System.out.println();
        System.out.println("UC2 operations completed successfully...");
    }
}