package Consolidated_tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFiletoArray{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file path from user
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        // Create File object
        File file = new File(filePath);

        // Check if the file exists
        if (file.exists() && file.isFile()) {
            try {
                // Read file into byte array
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] fileBytes = new byte[(int) file.length()]; // Allocate array
                fileInputStream.read(fileBytes); // Read into byte array
                fileInputStream.close(); // Close the stream

                // Display byte array length (File size in bytes)
                System.out.println("\nFile successfully read into a byte array.");
                System.out.println("File size: " + fileBytes.length + " bytes");

                // Optionally, print the first few bytes as hex values
                System.out.print("First 10 bytes (Hex): ");
                for (int i = 0; i < Math.min(10, fileBytes.length); i++) {
                    System.out.printf("%02X ", fileBytes[i]);
                }
                System.out.println();

            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("The specified file does NOT exist or is not a valid file.");
        }

        scanner.close();
    }
}

