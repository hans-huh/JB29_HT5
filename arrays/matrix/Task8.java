package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Дан двухмерный массив n×m элементов. Определить, сколько раз встречается число 7 среди элементов массива.
 */

public class Task8 {
    public static void main(String[] args) {
        int n;
        int m;
        int result;
        int[][] matrix;
        final int RANGE = 20; // used to randomly generate integers from 0 to RANGE
        final int NUMBER_TO_COUNT = 7;

        // Creating the matrix
        System.out.println("Creating a n x m matrix...");
        System.out.println("Enter the number of rows: ");
        n = getNumber();
        System.out.println("Enter the number of columns: ");
        m = getNumber();

        matrix = createMatrix(n, m);

        // fill the matrix with random values
        fillWithRandoms(matrix, RANGE);


        // counting the occurrences of number 7 in the matrix
        result = countOccurrenceInMatrix(matrix, NUMBER_TO_COUNT);

        System.out.println("Given the matrix");
        printMatrix(matrix);
        System.out.println("The number of occurrences of " + NUMBER_TO_COUNT + " is " + result);
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


    public static int countOccurrenceInMatrix(int[][] matrix, int number){
        int counter = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                if(matrix[i][k] == number){
                    counter++;
                }
            }
        }

        return counter;
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

}
