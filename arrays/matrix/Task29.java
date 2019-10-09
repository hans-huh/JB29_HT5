package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Найти положительные элементы главной диагонали квадратной матрицы.
 */

public class Task29 {
    public static void main(String[] args) {
        int n;
        int[][] matrix;
        int[] positiveElements;

        System.out.println("Creating a square matrix of size n...");
        System.out.println("Please enter the value of n: ");
        n = getNumber();

        matrix = createSquareMatrix(n);

        fillWithRandoms(matrix);

        System.out.println("In the matrix: ");
        printMatrix(matrix);

        positiveElements = findPositiveElementsOfMainDiagonal(matrix);
        System.out.println("\nThe positive elements of the main diagonal are: ");
        for(int i : positiveElements){
            System.out.print(i + " ");
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


    public static int[][] createSquareMatrix(int n){
        int[][] matrix;

        matrix = new int[n][n];

        return matrix;
    }


    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int cell : row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


    public static int[] findPositiveElementsOfMainDiagonal(int[][] matrix){
        int[] array;
        int matrixLength;
        int counter;

        counter = 0;
        matrixLength = matrix.length;
        for(int i = 0; i < matrixLength; i++){
            for(int j = 0; j < matrixLength; j++){
                if(i == j) {
                    if (matrix[i][j] > 0) {
                        counter++;
                    }
                }
            }
        }

        array = new int[counter];
        counter = 0;
        for(int i = 0; i < matrixLength; i++){
            for(int j = 0; j < matrixLength; j++){
                if(i == j){
                    if(matrix[i][j] > 0){
                        array[counter++] = matrix[i][j];
                    }
                }
            }
        }

        return array;
    }

    public static void fillWithRandoms(int[][] matrix){
        final int RANGE = 99;

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
