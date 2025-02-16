package Consolidated_tasks;

import java.util.Arrays;

public class ArrayCopyRange {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70};

        int[] newArray = Arrays.copyOfRange(numbers, 2, 5);

        // Printing the new array
        System.out.println("Original Array: " + Arrays.toString(numbers));
        System.out.println("Copied Range Array: " + Arrays.toString(newArray));
    }
}
