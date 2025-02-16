package Consolidated_tasks;

import java.io.File;
import java.util.Scanner;

public class CheckFilePer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file/directory path from user
        System.out.print("Enter the file or directory path: ");
        String path = scanner.nextLine();

        // Create File object
        File file = new File(path);

        // Check if the file/directory exists
        if (file.exists()) {
            System.out.println("The specified path exists.");

            // Check if it is a file or directory
            if (file.isFile()) {
                System.out.println("It is a FILE.");
            } else if (file.isDirectory()) {
                System.out.println("It is a DIRECTORY.");
            }

            // Check read and write permissions
            System.out.println("Read Permission: " + (file.canRead() ? "Yes" : "No"));
            System.out.println("Write Permission: " + (file.canWrite() ? "Yes" : "No"));
        } else {
            System.out.println("The specified path does NOT exist.");
        }

        scanner.close();
    }
}
