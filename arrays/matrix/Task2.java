package by.ld.hw.arrays.matrix;

/**
 * Создать и вывести на экран матрицу 2 x 3, заполненную случайными числами из [0, 9].
 */

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix;
        int m;
        int n;
        int min;
        int max;


        // Create a matrix
        m = 2;
        n = 3;
        matrix = createMatrix(m, n);

        // fill the matrix with random numbers from 0 to 9
        min = 0; // minimum value in the range
        max = 9; // maximal value in the range
        fillMatrixWithRandoms(matrix, min, max);

        // print the matrix
        printMatrix(matrix);
    }


    public static int[][] createMatrix(int a, int b){
        int[][] matrix;
        matrix = new int[a][b];

        return matrix;
    }


    public static void fillMatrixWithRandoms(int[][] matrix, int minBoundary, int maxBoundary){
        int range;
        int generated;

        range = maxBoundary - minBoundary + 1;
        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                generated = (int) (Math.random() * range);
                matrix[i][k] = generated;
            }
        }
    }


    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int k : row){
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

}
