package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Задана матрица неотрицательных чисел.
 * Посчитать сумму элементов в каждом столбце.
 * Определить, какой столбец содержит максимальную сумму
 */

public class Task28 {
    public static void main(String[] args) {
        int m;
        int n;
        int[][] matrix;

        System.out.println("Creating a matrix...");
        System.out.println("Please enter the number of rows: ");
        m = getNumber();
        System.out.println("Please enter the number of columns: ");
        n = getNumber();

        matrix = createMatrix(m, n);

        // generating random numbers
        fillWithRandoms(matrix);

        System.out.println("In the matrix: ");
        printMatrix(matrix);

        findColumnWithMaxSum(matrix);

    }

    public static int getNumber(){
        int n;
        Scanner scanner;
        boolean meetCondition;
        boolean isDigit;

        n = 0;
        scanner = new Scanner(System.in);
        do{
            isDigit = false;
            while(!isDigit){
                try{
                    n = scanner.nextInt();
                    isDigit = true;
                } catch (java.util.InputMismatchException e){
                    System.out.println("Please enter an integer!");
                    scanner.next();
                }
            }
            if(n < 2){
                System.out.println("Your matrix should have at least 2 rows / columns in it. Please try again!");
                meetCondition = false;
            } else {
                meetCondition = true;
            }
        } while (!meetCondition);

        return n;
    }

    public static int[][] createMatrix(int a, int b){
        int[][] matrix;
        matrix = new int[a][b];

        return matrix;
    }


    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int i : row){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void fillWithRandoms(int[][] matrix){
        final int RANGE = 99;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                matrix[i][k] = (int) (Math.random() * (RANGE + 1));
            }
        }
    }

    public static void findColumnWithMaxSum(int[][] matrix){
        int tempSum;
        int maxSum;
        int numRows;
        int numColumns;
        int columnNumber;


        maxSum = Integer.MIN_VALUE;
        numRows = matrix.length;
        numColumns = matrix[0].length;
        columnNumber = 0;

        for(int i = 0; i < numColumns; i++){
            tempSum = 0;
            for(int j = 0; j < numRows; j++){
                tempSum += matrix[j][i];
            }
            if(tempSum > maxSum){
                maxSum = tempSum;
                columnNumber = i + 1;
            }
        }

        System.out.println("The column with the max sum is " + columnNumber + " with the max sum of " + maxSum);
    }
}
