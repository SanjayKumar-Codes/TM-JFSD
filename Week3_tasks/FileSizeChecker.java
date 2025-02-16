package Consolidated_tasks;

import java.io.File;
import java.util.Scanner;

public class FileSizeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file path from user
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        // Create File object
        File file = new File(filePath);

        // Check if file exists
        if (file.exists() && file.isFile()) {
            // Get file size in bytes
            long fileSizeBytes = file.length();

            // Convert to KB and MB
            double fileSizeKB = fileSizeBytes / 1024.0;
            double fileSizeMB = fileSizeKB / 1024.0;

            // Display file sizes
            System.out.println("\nFile Size Details:");
            System.out.println("Size in Bytes: " + fileSizeBytes + " B");
            System.out.printf("Size in KB: %.2f KB%n", fileSizeKB);
            System.out.printf("Size in MB: %.2f MB%n", fileSizeMB);
        } else {
            System.out.println("The specified file does NOT exist or is not a valid file.");
        }

        scanner.close();
    }
}
