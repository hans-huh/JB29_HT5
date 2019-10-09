package by.ld.hw.arrays.matrix;

import java.util.Scanner;

public class Task26 {
    public static void main(String[] args) {
        int n;
        int m;
        int[][] matrix;
        int sumOfNegativeElements;

        System.out.println("Creating a matrix of size n x m...");
        System.out.println("Please enter the value of n: ");
        n = getNumber();
        System.out.println("Please enter the value of m: ");
        m = getNumber();

        matrix = createMatrix(n, m);

        fillMatrixWithUserInput(matrix);

        System.out.println("Here is your matrix: ");
        printMatrix(matrix);

        System.out.println("Calculating the sum of negative elements per row...");
        calculateNegativeSumPerRow(matrix);
        System.out.println("\nFinding the max element in each row...");
        findMaxElementPerRow(matrix);
        System.out.println("\nSwapping the min and the max elements in the matrix");
        swapMinMaxElements(matrix);
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


    public static int[][] createMatrix(int a, int b){
        int[][] matrix;

        matrix = new int[a][b];

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


    public static void fillMatrixWithUserInput(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            System.out.println("Please, fill row " + (i + 1) + "... ");
            for(int k = 0; k < matrix[i].length; k++){
                System.out.println("Please, enter a number:");
                matrix[i][k] = getUserInput();
            }
        }
    }


    public static int getUserInput(){
        int n;
        Scanner scanner;
        boolean isDigit;

        n = 0;
        scanner = new Scanner(System.in);
        isDigit = false;
        while (!isDigit){
            try{
                n = scanner.nextInt();
                isDigit = true;
            } catch (java.util.InputMismatchException e){
                System.out.println("Please enter a digit! ");
                scanner.next();
            }
        }
        return n;
    }


    public static void calculateNegativeSumPerRow(int[][] matrix){
        int sum;

        for(int i = 0; i < matrix.length; i++){
            sum = 0;
            for(int k = 0; k < matrix[i].length; k++){
                if(matrix[i][k] < 0){
                    sum += matrix[i][k];
                }
            }
            System.out.println("In row " + (i + 1) + ", the sum of negative elements is  " + sum);
        }
    }


    public static void findMaxElementPerRow(int[][] matrix){
        int max;

        for(int i = 0; i < matrix.length; i++){
            max = Integer.MIN_VALUE;
            for(int k = 0; k < matrix[i].length; k++){
                if(matrix[i][k] > max){
                    max = matrix[i][k];
                }
            }
            System.out.println("In row " + (i + 1) + ", max element is " + max);
        }
    }



    public static void swapMinMaxElements(int[][] matrix){
        int minRow;
        int minCol;
        int maxRow;
        int maxCol;
        int temp;
        int min;
        int max;

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        maxRow = 0;
        maxCol = 0;
        minRow = 0;
        minCol = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                if(matrix[i][k] > max){
                    max = matrix[i][k];
                    maxRow = i;
                    maxCol = k;
                }
                if(matrix[i][k] < min){
                    min = matrix[i][k];
                    minRow = i;
                    minCol = k;
                }
            }
        }

        temp = matrix[maxRow][maxCol];
        matrix[maxRow][maxCol] = matrix[minRow][minCol];
        matrix[minRow][minCol] = temp;
    }
}
