import java.util.Scanner;
public class SafeInput {
    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int userInput;
        while (true) {
            System.out.print(prompt);
            userInput = console.nextInt();
            if (userInput >= low && userInput <= high) {
                break;
            } else {
                System.out.println("Tje input is required to be between " + low + " and " + high);
            }
        }
        return userInput;
    }
    public static boolean getYNConfirm(Scanner console, String prompt) {
        String response;
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            response = console.next().toUpperCase();
            if (response.equals("Y")) {
                return true;
            } else if (response.equals("N")) {
                return false;
            } else {
                System.out.println("you must enter either Y or N, try again.");
            }
        }
    }
}
