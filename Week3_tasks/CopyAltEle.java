package Consolidated_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyAltEle {
    public static void main(String[] args) { 
        List<Integer> list1 = Arrays.asList(45, 67, 89, 23, 56, 73, 89);
        List<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < list1.size(); i = i + 2) { 
            list2.add(list1.get(i)); 
        }

        System.out.println(list2); 
    }
}
