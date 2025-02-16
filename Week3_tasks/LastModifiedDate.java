package Consolidated_tasks;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LastModifiedDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file path from user
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        // Create File object
        File file = new File(filePath);

        // Check if file exists
        if (file.exists() && file.isFile()) {
            // Get last modified timestamp
            long lastModifiedTimestamp = file.lastModified();

            // Convert timestamp to readable date format
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String formattedDate = sdf.format(new Date(lastModifiedTimestamp));

            // Display last modified date
            System.out.println("Last Modified Date: " + formattedDate);
        } else {
            System.out.println("The specified file does NOT exist or is not a file.");
        }

        scanner.close();
    }
}

