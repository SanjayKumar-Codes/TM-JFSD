package Consolidated_tasks;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class FileWithSpeExe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get directory path from user
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        // Get the desired file extension
        System.out.print("Enter the file extension (e.g., .txt, .java, .pdf): ");
        String extension = scanner.nextLine();

        // Create File object
        File directory = new File(directoryPath);

        // Validate if directory exists
        if (directory.exists() && directory.isDirectory()) {
            // Use FilenameFilter to filter by extension
            File[] filteredFiles = directory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(extension.toLowerCase());
                }
            });

            // Display the filtered files
            System.out.println("\nFiles with extension '" + extension + "' in " + directoryPath + ":");
            if (filteredFiles != null && filteredFiles.length > 0) {
                for (File file : filteredFiles) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("No files found with the given extension.");
            }
        } else {
            System.out.println("Invalid directory path! Please enter a valid directory.");
        }

        scanner.close();
    }
}

