package Consolidated_tasks;

import java.io.*;
import java.util.Scanner;

public class FileNotFoundExcep {
    // Method to read a file and throw an exception if not found
    public static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);

        // Check if file exists before proceeding
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("Error: The file '" + filePath + "' was not found.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("\nFile Content:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get file path from user
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();

            // Call method to read file
            readFile(filePath);

        } catch (FileNotFoundException e) { // Catch file not found exception
            System.out.println(e.getMessage());
        } catch (Exception e) { // Catch other exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Program execution completed.");
        }
    }
}

