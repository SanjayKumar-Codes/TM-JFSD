package Consolidated_tasks.tasks2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinMax {
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(45, 78, 12, 89, 34, 23, 99, 5, 67);

        // Find the maximum value
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);

        // Find the minimum value
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);

        // Display results
        System.out.println("List of numbers: " + numbers);
        System.out.println("Maximum Value: " + (max.isPresent() ? max.get() : "List is empty"));
        System.out.println("Minimum Value: " + (min.isPresent() ? min.get() : "List is empty"));
    }
}

