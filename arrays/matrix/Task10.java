package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */

public class Task10 {
    public static void main(String[] args) {
        int n;
        int m;
        int k;
        int p;
        int[][] matrix;
        final int RANGE = 20; // used to randomly generate integers from 0 to RANGE

        // Creating the matrix
        System.out.println("Creating a matrix...");
        System.out.println("Enter the number of rows: ");
        n = getNumber();
        System.out.println("Enter the number of columns: ");
        m = getNumber();
        System.out.println("Enter the row you want to print: ");
        k = getNumber();
        System.out.println("Enter the column you want to print: ");
        p = getNumber();


        matrix = createMatrix(n, m);

        // fill the matrix with random values
        fillWithRandoms(matrix, RANGE);

        System.out.println("Given the matrix: ");
        printMatrix(matrix);
        System.out.println("\nPrinting row " + k);
        printSpecificRow(matrix, k);
        System.out.println("\nPrinting column " + p);
        printSpecificColumn(matrix, p);

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
            if(n < 1){
                System.out.println("Number cannot be less than one. Please try again!");
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


    public static void fillWithRandoms(int[][] matrix, int range){

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                matrix[i][k] = (int) (Math.random() * (range + 1));
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


    public static void printSpecificRow(int[][] matrix, int row) {
        for(int i = 0; i < matrix.length; i++){
            if(i == (row - 1)){
                for(int k = 0; k < matrix[i].length; k++){
                    System.out.print(matrix[i][k] + " ");
                }
            }
        }
        System.out.println();
    }


    public static void printSpecificColumn(int[][] matrix, int column){
        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                if(k == column - 1){
                    System.out.println(matrix[i][k]);
                }
            }
        }
        System.out.println();
    }
}
