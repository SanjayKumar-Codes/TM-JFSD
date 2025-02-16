package Consolidated_tasks;

import java.io.*;

import java.io.*;

// Custom exception inside the same file
class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

public class ReadFileCheckEmpty {
    public static void readFile(String filePath) throws FileNotFoundException, EmptyFileException, IOException {
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("Error: The file '" + filePath + "' was not found.");
        }

        if (file.length() == 0) {
            throw new EmptyFileException("Error: The file '" + filePath + "' is empty.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("\nFile Content:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter the file path: ");
            String filePath = consoleReader.readLine();
            readFile(filePath);

        } catch (FileNotFoundException | EmptyFileException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } finally {
            System.out.println("Program execution completed.");
        }
    }
}

