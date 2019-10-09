package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 */

public class Task35 {
    public static void main(String[] args) {
        int m;
        int n;
        int[][] matrix;
        int maxValue;

        System.out.println("Creating a matrix...");
        System.out.println("PLease enter the number of rows: ");
        m = getNumber();
        System.out.println("Please enter the number of columns: ");
        n = getNumber();

        matrix = createMatrix(m, n);
        fillWithRandoms(matrix);

        System.out.println("Matrix before replacements: \n");
        printMatrix(matrix);

        maxValue = findMax(matrix);
        System.out.println("\nMax value is " + maxValue);
        replaceOddsWithMaxValue(matrix, maxValue);

        System.out.println("\nMatrix after replacements: \n");
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


    public static int findMax(int[][] matrix){
        int max;

        max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }


    public static void replaceOddsWithMaxValue(int[][] matrix, int maxValue){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] % 2 != 0){
                    matrix[i][j] = maxValue;
                }
            }
        }
    }
}
