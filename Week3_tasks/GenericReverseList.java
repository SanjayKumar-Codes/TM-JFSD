package Consolidated_tasks.tasks2;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class GenericReverseList {
    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        return reversed;
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        System.out.println("Reversed Words: " + reverseList(words));
        System.out.println("Reversed Numbers: " + reverseList(numbers));
    }
}
