package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 *  Получить квадратную матрицу порядка n:
 *
 */

public class Task12 {
    public static void main(String[] args) {
        int n;
        int matrix[][];

        // get n
        System.out.println("Enter the value of n: ");
        n = getNumber();

        // create matrix
        matrix = createSquareMatrix(n);

        // fill it according to the example
        fillMatrix(matrix);

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


    public static int[][] createSquareMatrix(int a){
        int[][] matrix;
        matrix = new int[a][a];

        return matrix;
    }


    public static void fillMatrix(int[][] matrix){
        int temp;
        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                if(i != k){
                    matrix[i][k] = 0;
                } else {
                    matrix[i][k] = i;
                }
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
    }



}
