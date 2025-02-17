package Consolidated_tasks.tasks2;

import java.util.Arrays;

public class GenericArrayComparison {
    public static <T> boolean areArraysEqual(T[] array1, T[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4};
        Integer[] arr2 = {1, 2, 3, 4};
        String[] strArr1 = {"apple", "banana", "cherry"};
        String[] strArr2 = {"apple", "banana", "mango"};

        System.out.println("Integer arrays equal? " + areArraysEqual(arr1, arr2)); // true
        System.out.println("String arrays equal? " + areArraysEqual(strArr1, strArr2)); // false
    }
}
