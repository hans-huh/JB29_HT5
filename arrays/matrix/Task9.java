package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */

public class Task9 {
    public static void main(String[] args) {
        int n;
        int[][] matrix;
        final int RANGE = 50; // using this to create a random number between 0 and RANGE

        // create a square matrix
        System.out.println("Creating a matrix...");
        System.out.println("Enter the number of rows in the square matrix: ");
        n = getNumber();

        matrix = createMatrix(n, n);

        // fill the matrix with random values
        fillWithRandoms(matrix, RANGE);

        // print matrix diagonals
        System.out.println("Given the matrix");
        printMatrix(matrix);
        System.out.println("Diagonals of the matrix are: \n");
        printMatrixDiagonal(matrix);

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


    public static void printMatrixDiagonal(int[][] matrix){
        int begin = 0;
        int end = matrix.length - 1;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                if(k == begin || k == end){
                    System.out.print(" " + matrix[i][k]);
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
            begin++;
            end--;
        }
    }
}
