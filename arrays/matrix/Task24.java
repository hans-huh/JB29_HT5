package by.ld.hw.arrays.matrix;

import java.util.Scanner;

public class Task24 {
    public static void main(String[] args) {
        int n;
        double[] initialArray;
        double[][] matrix;

        System.out.println("Creating a matrix of size n...");
        System.out.println("Enter the value of n: ");
        n = getNumber();

        initialArray = createInitialArray(n);

        matrix = createSquareMatrix(n);

        fillMatrixPerSample(matrix, initialArray);

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


    public static double[][] createSquareMatrix(int n){
        double[][] matrix;

        matrix = new double[n][n];

        return matrix;
    }


    public static double[] createInitialArray(int n){
        final double FIRST_ELEMENT = 1; // used to create an array x1, x2... xn
        double[] array;

        array = new double[n];
        for(int i = 0; i < array.length; i++){
            array[i] = FIRST_ELEMENT * (i + 1);
        }

        return array;
    }

    public static void fillMatrixPerSample(double[][] matrix, double[] array){
        int power;

        for(int i = 0; i < matrix.length; i++){
            power = i + 1;
            for(int k = 0; k < matrix[i].length; k++){
                matrix[i][k] = Math.pow(array[k], power);
            }
        }
    }


    public static void printMatrix(double[][] matrix){
        for(double[] row : matrix){
            for(double cell : row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
