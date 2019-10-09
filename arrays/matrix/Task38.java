package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Найдите сумму двух матриц
 */

public class Task38 {
    public static void main(String[] args) {
        int m;
        int n;
        int[][] firstMatrix;
        int[][] secondMatrix;
        int[][] sum;

        System.out.println("Creating matrices...");
        System.out.println("PLease enter the number of rows: ");
        m = getNumber();
        System.out.println("Please enter the number of columns: ");
        n = getNumber();

        firstMatrix = createMatrix(m, n);
        fillWithRandoms(firstMatrix);

        secondMatrix = createMatrix(m, n);
        fillWithRandoms(secondMatrix);

        sum = addMatrices(firstMatrix, secondMatrix);
        if(sum.length != 0){
            System.out.println("The addition of the matrix A: \n");
            printMatrix(firstMatrix);
            System.out.println("\nto the matrix B: \n");
            printMatrix(secondMatrix);
            System.out.println("\ngets \n");
            printMatrix(sum);
        }
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
        final int RANGE = 30;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                matrix[i][k] = (int) (Math.random() * (RANGE + 1));
            }
        }
    }

    public static int[][] addMatrices(int[][] first, int[][] second){
        int[][] sum;
        int numOfRows;
        int numOfColumns;

        // if the user tries to add matrices of different dimensions, the warning message is printed and the method
        // will return a matrix of size 0;
        if(first.length != second.length || first[0].length != second[0].length){
            System.out.println("Cannot add matrices of different dimensions");
            sum = new int[0][0];
            return sum;
        }

        numOfRows = first.length;
        numOfColumns = first[0].length;
        sum = new int[numOfRows][numOfColumns];

        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < numOfColumns; j++){
                sum[i][j] = first[i][j] + second[i][j];
            }
        }

        return sum;
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
