package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
 */

public class Task33 {
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

        System.out.println("\nMatrix after ascending sort (columns): ");
        sortColumnAsc(matrix);
        printMatrix(matrix);


        System.out.println("\nMatrix after descending sort (columns): ");
        sortColumnDesc(matrix);
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

    public static void sortColumnAsc(int[][] matrix){
        int temp;
        int numOfColumns;
        int numOfRows;

        numOfRows = matrix.length;
        numOfColumns = matrix[0].length;

        for(int i = 0; i < numOfColumns; i++){
            for(int j = 0; j < numOfRows - 1; j++){
                for(int k = 0; k < numOfRows - j - 1; k++){
                    if(matrix[k][i] > matrix[k+1][i]){
                        temp = matrix[k][i];
                        matrix[k][i] = matrix[k+1][i];
                        matrix[k+1][i] = temp;
                    }
                }
            }
        }
    }

    public static void sortColumnDesc(int[][] matrix){
        int temp;
        int numOfColumns;
        int numOfRows;

        numOfRows = matrix.length;
        numOfColumns = matrix[0].length;

        for(int i = 0; i < numOfColumns; i++){
            for(int j = 0; j < numOfRows - 1; j++){
                for(int k = 0; k < numOfRows - j - 1; k++){
                    if(matrix[k][i] < matrix[k+1][i]){
                        temp = matrix[k][i];
                        matrix[k][i] = matrix[k+1][i];
                        matrix[k+1][i] = temp;
                    }
                }
            }
        }
    }

}