package Consolidated_tasks.tasks2;

import java.util.List;

public class GenericFindElement {
    public static <T> int findFirstOccurrence(List<T> list, T target) {
        return list.indexOf(target);
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry", "banana");
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);

        System.out.println("Index of 'banana': " + findFirstOccurrence(words, "banana")); // 1
        System.out.println("Index of 30: " + findFirstOccurrence(numbers, 30)); // 2
        System.out.println("Index of 'grape': " + findFirstOccurrence(words, "grape")); // -1
    }
}
