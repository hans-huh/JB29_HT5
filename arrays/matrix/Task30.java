package by.ld.hw.arrays.matrix;

/**
 * Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк,
 * в которых число 5 встречается три и более раз.
 */

public class Task30 {
    public static void main(String[] args) {
        final int MATRIX_ROWS = 10;
        final int MATRIX_COLUMNS = 20;
        int[][] matrix;

        matrix = createMatrix(MATRIX_ROWS, MATRIX_COLUMNS);

        fillWithRandoms(matrix);

        System.out.println("The " + MATRIX_ROWS + "x" + MATRIX_COLUMNS + " matrix with random values from 0 to 15: ");
        printMatrix(matrix);

        printSpecificString(matrix);


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
        final int RANGE = 15;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                matrix[i][k] = (int) (Math.random() * (RANGE + 1));
            }
        }
    }

    public static void printSpecificString(int[][] matrix){
        String tempStr;
        int counter;

        System.out.println("String where digit 5 can be found more than 2 times is: ");
        for(int i = 0; i < matrix.length; i++){
            counter = 0;
            for(int j = 0; j < matrix[i].length; j++){
                tempStr = Integer.toString(matrix[i][j]);
                if(tempStr.contains("5")){
                    counter++;
                    if(counter == 3){
                        System.out.print((i + 1) + " ");
                        break;
                    }
                }
            }
        }
    }
}
