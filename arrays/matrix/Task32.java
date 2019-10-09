package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */

public class Task32 {
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

        System.out.println("Matrix before sorting: ");
        printMatrix(matrix);

        System.out.println("\nMatrix after ascending sort (rows): ");
        sortRowsAsc(matrix);
        printMatrix(matrix);


        System.out.println("\nMatrix after descending sort (rows): ");
        sortRowDesc(matrix);
        printMatrix(matrix);
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

    public static void sortRowsAsc(int[][] matrix){
        int temp;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length - 1; j++){
                for(int k = 0; k < matrix[i].length - 1 - j; k++){
                    if(matrix[i][k] > matrix[i][k+1]){
                        temp = matrix[i][k];
                        matrix[i][k] = matrix[i][k+1];
                        matrix[i][k+1] = temp;
                    }
                }
            }
        }
    }

    public static void sortRowDesc(int[][] matrix){
        int temp;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length - 1; j++){
                for(int k = 0; k < matrix[i].length - 1 - j; k++){
                    if(matrix[i][k] < matrix[i][k+1]){
                        temp = matrix[i][k];
                        matrix[i][k] = matrix[i][k+1];
                        matrix[i][k+1] = temp;
                    }
                }
            }
        }
    }

}
