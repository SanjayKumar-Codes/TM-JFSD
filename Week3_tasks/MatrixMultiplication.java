package Consolidated_tasks.tasks2;

import java.util.Arrays;

// Thread for computing one element in the result matrix
class MatrixMultiplicationThread extends Thread {
    private final int[][] A, B, C;
    private final int row, col;

    // Constructor
    public MatrixMultiplicationThread(int[][] A, int[][] B, int[][] C, int row, int col) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.row = row;
        this.col = col;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int k = 0; k < A[0].length; k++) {
            sum += A[row][k] * B[k][col];
        }
        C[row][col] = sum;
    }
}

// Main class for matrix multiplication
public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix multiplication not possible. Columns of A must equal rows of B.");
        }

        int[][] C = new int[rowsA][colsB];
        Thread[][] threads = new Thread[rowsA][colsB];

        // Creating and starting threads
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                threads[i][j] = new MatrixMultiplicationThread(A, B, C, i, j);
                threads[i][j].start();
            }
        }

        // Waiting for all threads to complete
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                try {
                    threads[i][j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Printing the result matrix
        System.out.println("Resultant Matrix:");
        for (int[] row : C) {
            System.out.println(Arrays.toString(row));
        }
    }
}
