package Consolidated_tasks.tasks2;

import java.util.Arrays;

// Multi-threaded Merge Sort
class MergeSortThread extends Thread {
    private int[] array;
    private int left, right;

    // Constructor
    public MergeSortThread(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Create two threads for sorting each half
            MergeSortThread leftSorter = new MergeSortThread(array, left, mid);
            MergeSortThread rightSorter = new MergeSortThread(array, mid + 1, right);

            leftSorter.start();
            rightSorter.start();

            try {
                leftSorter.join();
                rightSorter.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Merge function
    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(array, left, leftArr, 0, n1);
        System.arraycopy(array, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        // Merge the two sorted subarrays
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                array[k] = leftArr[i];
                i++;
            } else {
                array[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            array[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArr[j];
            j++;
            k++;
        }
    }
}

// Main class
public class ThreadSort {
    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original Array: " + Arrays.toString(numbers));

        // Create and start merge sort thread
        MergeSortThread sorter = new MergeSortThread(numbers, 0, numbers.length - 1);
        sorter.start();

        try {
            sorter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }
}
