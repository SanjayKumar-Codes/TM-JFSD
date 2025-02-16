package Consolidated_tasks.tasks2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertStringsCase {
    public static void main(String[] args) {
        // List of strings
        List<String> words = Arrays.asList("hello", "world", "java", "streams");

        // Convert to uppercase
        List<String> upperCaseWords = words.stream()
                                           .map(String::toUpperCase) // Convert each word to uppercase
                                           .collect(Collectors.toList());

        // Convert to lowercase
        List<String> lowerCaseWords = words.stream()
                                           .map(String::toLowerCase) // Convert each word to lowercase
                                           .collect(Collectors.toList());

        // Display results
        System.out.println("Original List: " + words);
        System.out.println("Uppercase List: " + upperCaseWords);
        System.out.println("Lowercase List: " + lowerCaseWords);
    }
}

