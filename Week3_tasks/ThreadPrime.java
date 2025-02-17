package Consolidated_tasks.tasks2;

import java.util.Scanner;


class PrimeSumThread extends Thread {
    private int start, end;
    private long sum = 0;

  
    public PrimeSumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

 
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
    }

  
    public long getSum() {
        return sum;
    }
}

public class ThreadPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter the limit: ");
        int limit = scanner.nextInt();
        scanner.close();

        int numThreads = 4; 
        PrimeSumThread[] threads = new PrimeSumThread[numThreads];
        int range = limit / numThreads;
        int start = 1;
        long totalSum = 0;

       
        for (int i = 0; i < numThreads; i++) {
            int end = (i == numThreads - 1) ? limit : start + range;
            threads[i] = new PrimeSumThread(start, end);
            threads[i].start();
            start = end + 1;
        }

    
        for (PrimeSumThread thread : threads) {
            try {
                thread.join();
                totalSum += thread.getSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       
        System.out.println("Sum of prime numbers up to " + limit + " is: " + totalSum);
    }
}
