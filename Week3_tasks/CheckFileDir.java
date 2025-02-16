package Consolidated_tasks;

import java.io.File;
import java.util.Scanner;

public class CheckFileDir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file/directory path from user
        System.out.print("Enter the file or directory path: ");
        String path = scanner.nextLine();

        // Create File object
        File file = new File(path);

        // Check if the path exists
        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("The path exists and it is a FILE.");
            } else if (file.isDirectory()) {
                System.out.println("The path exists and it is a DIRECTORY.");
            }
        } else {
            System.out.println("The specified path does NOT exist.");
        }

        scanner.close();
    }
}

