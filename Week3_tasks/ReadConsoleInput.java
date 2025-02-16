package Consolidated_tasks;

import java.util.Scanner;

public class ReadConsoleInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompting user for input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();  // Read string input

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();  // Read integer input

        System.out.print("Enter your salary: ");
        double salary = scanner.nextDouble();  // Read double input

        // Displaying the input values
        System.out.println("\nUser Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);

        scanner.close();  // Close the scanner
    }
}
