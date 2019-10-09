package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Дана матрица размера m x n. Вывести ее элементы в следующем порядке: первая строка справа налево, вторая строка слева направо, третья строка справа налево и так далее.
 */

public class Task11 {
    public static void main(String[] args) {
        int m;
        int n;
        int matrix[][];

        // create matrix
        System.out.println("Creating a matrix...");
        System.out.println("Please enter the number of rows: ");
        m = getNumber();
        System.out.println("Please enter the number of columns: ");
        n = getNumber();

        matrix = createMatrix(m, n);

        // populate it with random values
        fillWithRandoms(matrix);

        // print the original matrix
        System.out.println("Here's the original matrix:");
        printMatrix(matrix);
        System.out.println("\n\n");

        // print in the order it was requested: first row - right to left, second row - left to right
        System.out.println("And here's the matrix printed in the requested order");
        printMatrixInRequestedOrder(matrix);
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


    public static void printMatrixInRequestedOrder(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            if(i % 2 != 0){
                for(int k = 0; k < matrix[i].length; k++){
                    System.out.print(matrix[i][k] + " ");
                }
            } else {
                for(int k = matrix[i].length - 1; k >= 0; k--){
                    System.out.print(matrix[i][k] + " ");
                }
            }
            System.out.println();
        }
    }


    public static void fillWithRandoms(int[][] matrix){
        final int RANGE = 200;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                matrix[i][k] = (int) (Math.random() * (RANGE + 1) * negativeGenerator());
            }
        }
    }


    public static int negativeGenerator(){
        int temp;

        temp = (int) (Math.random() * 2);
        if(temp == 0){
            return -1;
        } else {
            return 1;
        }
    }



}
