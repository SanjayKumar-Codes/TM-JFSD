package Consolidated_tasks;

import java.io.File;
import java.util.Scanner;

public class FileName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for directory path
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        // Create a File object
        File directory = new File(directoryPath);

        // Check if the given path is a valid directory
        if (directory.exists() && directory.isDirectory()) {
            // Get list of files and directories
            File[] filesList = directory.listFiles();

            System.out.println("\nFiles and Directories in: " + directoryPath);

            if (filesList != null) {
                for (File file : filesList) {
                    if (file.isFile()) {
                        System.out.println("[File]  " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("[Dir]   " + file.getName());
                    }
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("Invalid directory path! Please enter a valid directory.");
        }
        scanner.close();
    }
}
