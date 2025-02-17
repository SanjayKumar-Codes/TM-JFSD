package Consolidated_tasks.tasks2;

import java.util.List;
import java.util.ArrayList;

public class GenericMergeLists {
    public static <T> List<T> mergeAlternately(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() || j < list2.size()) {
            if (i < list1.size()) mergedList.add(list1.get(i++));
            if (j < list2.size()) mergedList.add(list2.get(j++));
        }

        return mergedList;
    }

    public static void main(String[] args) {
        List<String> list1 = List.of("apple", "banana", "cherry");
        List<String> list2 = List.of("orange", "grape", "melon", "kiwi");

        List<Integer> nums1 = List.of(1, 3, 5);
        List<Integer> nums2 = List.of(2, 4, 6, 8, 10);

        System.out.println("Merged Strings: " + mergeAlternately(list1, list2));
        System.out.println("Merged Numbers: " + mergeAlternately(nums1, nums2));
    }
}

