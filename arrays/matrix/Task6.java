package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 */

public class Task6 {
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

        // print columns where first element is greater than the last one
        printLastLessFirstColumns(matrix);
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


    public static void printLastLessFirstColumns(int[][] matrix){
        int first;
        int last;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                first = matrix[0][k];
                last = matrix[matrix.length - 1][k];
                if(first > last){
                    System.out.print(matrix[i][k] + " ");
                }
            }
            System.out.println();
        }


    }
}
