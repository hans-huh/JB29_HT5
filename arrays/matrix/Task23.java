package by.ld.hw.arrays.matrix;

import java.util.Scanner;

public class Task23 {
    public static void main(String[] args) {
        int n;
        double[][] matrix;
        int positiveNums;

        System.out.println("Creating a square matrix of size n...");
        System.out.println("Please enter the value of n: ");
        n = getNumber();

        matrix = createSquareMatrix(n);

        fillMatrixPerSample(matrix);

        positiveNums = countPositive(matrix);

        System.out.println("In the matrix:");
        printMatrix(matrix);
        System.out.println("\nThe number of positive elements is: " + positiveNums);
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


    public static void fillMatrixPerSample(double[][] matrix){
        double temp;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                temp = Math.sin( (Math.pow(i, 2) - Math.pow(k, 2)) / matrix.length );
                temp = Math.floor(temp * 100) / 100;
                matrix[i][k] = temp;
            }
        }
    }


    public static int countPositive(double[][] matrix){
        int counter;
        int tempResult;

        counter = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                tempResult = Double.compare(matrix[i][k], 0);
                if(tempResult <= 0){
                    continue;
                } else {
                    counter++;
                }
            }
        }

        return counter;
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
