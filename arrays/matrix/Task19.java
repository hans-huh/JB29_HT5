package by.ld.hw.arrays.matrix;

import java.util.Scanner;

public class Task19 {
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
        int n = 0;
        Scanner scanner;
        boolean isDigit;
        boolean meetCondition;

        scanner = new Scanner(System.in);
        do{
            isDigit = false;
            while(!isDigit){
                try{
                    n = scanner.nextInt();
                    isDigit = true;
                } catch(java.util.InputMismatchException e){
                    System.out.println("Please enter a digit!");
                    scanner.next();
                }
            }
            if(n < 2){
                System.out.println("Your matrix should have at least two rows / two columns. Please try again!");
                meetCondition = false;
            } else if(n % 2 != 0){
                System.out.println("Please enter an even digit!");
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


    public static void fillMatrixPerSample(int[][] matrix){
        int left;
        int right;

        for(int i = 0; i < matrix.length; i++){
            left = i;
            right = matrix.length - 1 - i;
            for(int k = 0; k < matrix[i].length; k++){
                if( (k >= left && k <= right) || (k <= left && k >= right) ){
                    matrix[i][k] = 1;
                } else {
                    matrix[i][k] = 0;
                }
            }
        }
    }


    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int cell : row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
