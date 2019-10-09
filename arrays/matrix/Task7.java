package by.ld.hw.arrays.matrix;

/**
 * Дан двухмерный массив 5×5. Найти сумму модулей отрицательных нечетных элементов.
 */

public class Task7 {
    public static void main(String[] args) {
        final int NUMBER_OF_ROWS = 5;
        final int NUMBER_OF_COLUMNS = 5;
        int sum;
        int[][] matrix;

        // create a matrix
        matrix = createMatrix(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);

        // fill it with random positive and negative integers
        fillWithRandoms(matrix);

        // find the sum of the absolute values of negative elements in the matrix
        sum = findAbsSumOfNegative(matrix);

        // print the result
        System.out.println("Given the matrix: ");
        printMatrix(matrix);
        System.out.println("\nThe sum of the absolute values of negative odd elements in " + sum);
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


    public static void fillWithRandoms(int[][] matrix){
        final int RANGE = 200;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                matrix[i][k] = (int) (Math.random() * (RANGE + 1) * negativeGenerator());
            }
        }
    }


    public static int negativeGenerator(){
        int temp;

        temp = (int) (Math.random() * 2);
        if(temp == 0){
            return -1;
        } else {
            return 1;
        }
    }


    public static int findAbsSumOfNegative(int[][] matrix){
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                if(k % 2 == 0 && matrix[i][k] < 0){
                    sum = sum + Math.abs(matrix[i][k]);
                }
            }
        }

        return sum;
    }
}
