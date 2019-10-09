package by.ld.hw.arrays.matrix;

/**
 * Сформировать матрицу из чисел от 0 до 999, вывести ее на экран. Посчитать количество двузначных
 * чисел в ней.
 */

public class Task31 {
    public static void main(String[] args) {
        final int NUMBER_OF_ROWS = 50;
        final int NUMBER_OF_COLUMNS = 20;
        int[][] matrix;

        matrix = createMatrix(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
        fillMatrixWithValues(matrix);
        printMatrix(matrix);
        System.out.println("The number of two-digit numbers in the matrix is " + findDigits(matrix, 10, 99));

    }


    public static int[][] createMatrix(int a, int b){
        int[][] matrix;
        matrix = new int[a][b];

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

    public static void fillMatrixWithValues(int[][] matrix){
        int counter;

        counter = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = counter++;
            }
        }
    }

    public static int findDigits(int[][] matrix, int min, int max){
        int counter;

        counter = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] >= min && matrix[i][j] <= max){
                    counter++;
                }
            }
        }

        return counter;
    }


}
