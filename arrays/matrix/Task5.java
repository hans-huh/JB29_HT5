package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Дана матрица. Вывести на экран все четные строки, то есть с четными номерами.
 */

public class Task5 {
    public static void main(String[] args) {
        int[][] matrix;
        int m;
        int n;

        // creating the matrix
        System.out.println("Creating a matrix...");
        System.out.println("Enter the number of rows:");
        m = getNumber();
        System.out.println("Enter the number of columns: ");
        n = getNumber();

        matrix = createMatrix(m, n);

        // fill the matrix with random values
        fillWithRandoms(matrix);

        // print the generated matrix
        printMatrix(matrix);

        // print even rows
        printEvenRows(matrix);
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


    public static void fillWithRandoms(int[][] matrix){
        final int RANGE = 200;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                matrix[i][k] = (int) (Math.random() * (RANGE + 1));
            }
        }
    }


    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int i : row){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void printEvenRows(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            if(i % 2 != 0){
                for(int k = 0; k < matrix[i].length; k++){
                    System.out.print(matrix[i][k] + " ");
                }
                System.out.println();
            }
        }
    }
}
