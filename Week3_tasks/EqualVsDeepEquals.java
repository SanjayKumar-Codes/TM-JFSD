package Consolidated_tasks;

import java.util.Arrays;
import java.util.Objects;

public class EqualVsDeepEquals {
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3};

        // Using equals() method
        //  While comparing with Arrays package it gives result as True
        boolean equals_comp = Objects.equals(array1, array2);
        
        System.out.println("Using equals(): " + equals_comp); 

        // Using deepEquals() method
        boolean deepEquals_comp = Objects.deepEquals(array1, array2);
        System.out.println("Using deepEquals(): " + deepEquals_comp); 

        // Additional check using Arrays.equals() (which also does deep comparison for 1D arrays)
        //  While comparing with Arrays package it gives result as True
        System.out.println("Using Arrays.equals(): " + Objects.equals(array1, array2)); // true
    }
}

