package Consolidated_tasks.tasks2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountStringByLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List of strings
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "avocado", "blueberry", "almond");

        // Get user input for the starting letter
        System.out.print("Enter the starting letter: ");
        char letter = scanner.next().toLowerCase().charAt(0); // Convert to lowercase for case insensitivity

        // Count strings that start with the specified letter
        long count = words.stream()
                          .filter(word -> word.toLowerCase().startsWith(String.valueOf(letter))) // Filter matching words
                          .count(); // Count matching elements

        // Display results
        System.out.println("Words starting with '" + letter + "': " + count);

        scanner.close();
    }
}
