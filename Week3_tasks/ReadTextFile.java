package Consolidated_tasks;

import java.io.*;
import java.util.Scanner;

public class ReadTextFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file path from user
        System.out.print("Enter the text file path: ");
        String filePath = scanner.nextLine();

        // Create File object
        File file = new File(filePath);

        // Check if file exists
        if (file.exists() && file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                System.out.println("\nFile Content:");
                while ((line = reader.readLine()) != null) { // Read line by line
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("The specified file does NOT exist or is not a valid text file.");
        }

        scanner.close();
    }
}
