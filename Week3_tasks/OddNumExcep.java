package Consolidated_tasks;

import java.util.Scanner;

public class OddNumExcep {
    
    public static void checkEven(int num) {
        if (num % 2 != 0) {
            throw new IllegalArgumentException("Error: " + num + " is an odd number!");
        }
        System.out.println("Success: " + num + " is an even number.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get user input
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();

            // Check if the number is even or throw an exception
            checkEven(number);

        } catch (IllegalArgumentException e) { // Catch odd number exception
            System.out.println(e.getMessage());
        } catch (Exception e) { // Catch any other unexpected exception
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close(); // Ensure scanner is closed
            System.out.println("Program execution completed.");
        }
    }
}
