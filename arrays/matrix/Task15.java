package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

public class Task15 {
    public static void main(String[] args) {
        int n;
        int[][] matrix;

        System.out.println("Enter the value of n (even digit): ");
        n = getNumber();

        matrix = createSquareMatrix(n);

        // fill the matrix per the sample
        fillMatrixPerSample(matrix);

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
            }
            else if(n % 2 != 0){
                System.out.println("Please enter the even number!");
                meetCondition = false;
            }
            else {
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


    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int i : row){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    public static void fillMatrixPerSample(int[][] matrix){
        int number;

        number = matrix.length;
        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                if(k != i){
                    matrix[i][k] = 0;
                    continue;
                }
                matrix[i][k] = number;
                number--;
            }
        }
    }

}
