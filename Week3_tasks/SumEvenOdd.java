package Consolidated_tasks.tasks2;

import java.util.Arrays;
import java.util.List;

public class SumEvenOdd {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35, 40, 45, 50);

        // Calculate sum of even numbers
        int evenSum = numbers.stream()
                             .filter(n -> n % 2 == 0) 
                             .mapToInt(Integer::intValue) 
                             .sum(); 

        // Calculate sum of odd numbers
        int oddSum = numbers.stream()
                            .filter(n -> n % 2 != 0)
                            .mapToInt(Integer::intValue) 
                            .sum(); 

        // Display results
        System.out.println("List of numbers: " + numbers);
        System.out.println("Sum of even numbers: " + evenSum);
        System.out.println("Sum of odd numbers: " + oddSum);
    }
}
