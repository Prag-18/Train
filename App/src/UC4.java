import java.util.*;
public class UC4 {
    public static void main(String[] args){
        System.out.println("====================================================");
        System.out.println("    === UC4 - Maintain Ordered Bogie Consist ===    ");
        System.out.println("====================================================");
        System.out.println("");
        List<String> trainConsist = new LinkedList<>();
        trainConsist.addLast("Engine");
        trainConsist.addLast("Sleeper");
        trainConsist.addLast("AC");
        trainConsist.addLast("Cargo");
        trainConsist.addLast("Guard");
        System.out.println("Initial Tain Consist:");
        System.out.println(trainConsist);
        System.out.println("");
        trainConsist.add(2,"Pantry Car");
        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);
        System.out.println("");
        System.out.println("After Removing First and Last Bogie");
        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println(trainConsist);
        System.out.println("");
        System.out.println("UC4 ordered consist operations completed...");
    }
}