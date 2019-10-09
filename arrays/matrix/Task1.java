package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 *  Cоздать матрицу 3 x 4, заполнить ее числами 0 и 1 так, чтобы в одной строке была ровно одна единица, и вывести на экран.
 */

public class Task1 {
    public static void main(String[] args) {
        int[][] matrix;

        matrix = createMatrix(3, 4);

        // fill matrix with specific values (0 and 1)
        fillMatrix(matrix);

        // print the resulted matrix
        printMatrix(matrix);
    }


    public static int[][] createMatrix(int a, int b){
        int[][] matrix;
        matrix = new int[a][b];

        return matrix;
    }


    public static void fillMatrix(int[][] matrix){
        boolean hasOne;
        int candidate;

        for(int i = 0; i < matrix.length; i++){
            hasOne = false;

            // Randomly generates 1 or 0. After that, checks if 1 is already present in a row.
            // If true, replaces 1 with 0
            // if no 1 were generated at the end of the row, start's the for loop again
            do{
                for(int k = 0; k < matrix[i].length; k++){
                    candidate = randomGenerator(1);
                    if(candidate == 1 && !hasOne){
                        matrix[i][k] = candidate;
                        hasOne = true;
                    } else if(candidate == 1 && hasOne){
                        matrix[i][k] = 0;
                    } else {
                        matrix[i][k] = candidate;
                    }
                }
            } while(!hasOne);
        }
    }


    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
    }

    public static int randomGenerator(int range) {
        int temp = 0;
        temp = (int) ((Math.random() * (range + 1)));
        System.out.println(temp);
        return temp;
    }
}
