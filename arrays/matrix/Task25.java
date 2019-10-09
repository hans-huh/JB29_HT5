package by.ld.hw.arrays.matrix;

import java.util.Scanner;

public class Task25 {
    public static void main(String[] args) {
        int n;
        int[][] matrix;

        System.out.println("Creating a square matrix of size n...");
        System.out.println("Please enter the value of n: ");
        n = getNumber();

        matrix = createSquareMatrix(n);

        fillMatrixPerSample(matrix);

        printMatrix(matrix);
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


    public static void fillMatrixPerSample(int[][] matrix) {
        int n = matrix.length;
        int value = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                matrix[i][k] = ++value;
            }
        }
    }
}
