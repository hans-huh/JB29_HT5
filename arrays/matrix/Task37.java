package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Переставить строки матрицы случайным образом.
 */

public class Task37 {
    public static void main(String[] args) {
        int m;
        int n;
        int[][] matrix;

        System.out.println("Creating a matrix...");
        System.out.println("PLease enter the number of rows: ");
        m = getNumber();
        System.out.println("Please enter the number of columns: ");
        n = getNumber();

        matrix = createMatrix(m, n);
        fillWithRandoms(matrix);

        System.out.println("Matrix before random row swap: \n");
        printMatrix(matrix);

        randomRowSwap(matrix);

        System.out.println("\nMatrix after random row swap: \n");
        printMatrix(matrix);
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


    public static void randomRowSwap(int[][] matrix){
        int numOfColumns;
        int numOfRows;
        int randomRow;
        int temp;

        numOfRows = matrix.length;
        numOfColumns = matrix[0].length;

        for(int i = numOfRows - 1; i > 0; i--){
            randomRow = (int) (Math.random() * (i + 1));

            for(int j = 0; j < numOfColumns; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[randomRow][j];
                matrix[randomRow][j] = temp;
            }
        }
    }

    public static int getNumber(){
        int n;
        Scanner scanner;
        boolean isDigit;
        boolean meetCondition;

        n = 0;
        scanner = new Scanner(System.in);
        do{
            isDigit = false;
            while (!isDigit){
                try{
                    n = scanner.nextInt();
                    isDigit = true;
                } catch (java.util.InputMismatchException e){
                    System.out.println("Please enter a digit!");
                    scanner.next();
                }
            }
            if(n < 2){
                System.out.println("Your matrix should have at least 2 rows / columns. Please try again!");
                meetCondition = false;
            } else {
                meetCondition = true;
            }
        } while (!meetCondition);

        return n;
    }
}
