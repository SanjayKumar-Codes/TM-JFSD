package Consolidated_tasks.tasks2;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageUsingStream {
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Using streams to calculate the average
        OptionalDouble average = numbers.stream()
                                        .mapToInt(Integer::intValue) 
                                        .average(); 

        // Display the result
        if (average.isPresent()) {
            System.out.printf("The average is: %.2f%n", average.getAsDouble());
        } else {
            System.out.println("The list is empty. Cannot calculate the average.");
        }
    }
}

