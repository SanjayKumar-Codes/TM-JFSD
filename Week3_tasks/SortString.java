package Consolidated_tasks.tasks2;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortString {
    public static void main(String[] args) {
        // List of strings
        List<String> words = Arrays.asList("banana", "apple", "cherry", "date", "elderberry", "fig", "grape");

        // Sort in ascending order (A-Z)
        List<String> ascendingOrder = words.stream()
                                           .sorted() // Default sorting (A-Z)
                                           .collect(Collectors.toList());

        // Sort in descending order (Z-A)
        List<String> descendingOrder = words.stream()
                                            .sorted(Comparator.reverseOrder()) // Sorting in reverse order
                                            .collect(Collectors.toList());

        // Display results
        System.out.println("Original List: " + words);
        System.out.println("Sorted List (Ascending): " + ascendingOrder);
        System.out.println("Sorted List (Descending): " + descendingOrder);
    }
}

