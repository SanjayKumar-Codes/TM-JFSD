package Consolidated_tasks.tasks2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicate {
    public static void main(String[] args) {
        // List with duplicate elements
        List<Integer> numbers = Arrays.asList(10, 20, 30, 10, 40, 50, 20, 60, 30, 70, 80);

        // Remove duplicates using streams
        List<Integer> uniqueNumbers = numbers.stream()
                                             .distinct() // Removes duplicate elements
                                             .collect(Collectors.toList());

        // Display results
        System.out.println("Original List: " + numbers);
        System.out.println("List without Duplicates: " + uniqueNumbers);
    }
}
