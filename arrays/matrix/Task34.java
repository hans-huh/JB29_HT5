package by.ld.hw.arrays.matrix;

import java.util.Arrays;

/**
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце
 * число единиц равно номеру столбца.
 */

public class Task34 {
    public static void main(String[] args) {
        int m;
        int n;
        int[][] matrix;

        System.out.println("Creating a random matrix m x n");
        m = getRandom();
        n = getRandom();
        while(n > m){
            n = getRandom();
        }

        matrix = createMatrix(m, n);

        fillWithSpecificValues(matrix);

        printMatrix(matrix);
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

    public static int getRandom(){
        final int RANGE = 15;
        int result;

        result = (int) (Math.random() * (RANGE + 1));

        // using recursion until we get a random number >= 2
        if(result < 2){
            return getRandom();
        } else {
            return result;
        }
    }

    public static void fillWithSpecificValues(int[][] matrix){
        int numOfRows;
        int numOfColumns;
        int[] randomizedValues;
        int oneCounter;
        int arrayCounter;

        numOfColumns = matrix[0].length;
        numOfRows = matrix.length;
        randomizedValues = new int[numOfRows];

        for(int i = 0; i < numOfColumns; i++){
            arrayCounter = 0;
            oneCounter = i + 1;
            Arrays.fill(randomizedValues, 0);
            shuffle(randomizedValues, oneCounter);
            for(int j = 0; j < numOfRows; j++){
                matrix[j][i] = randomizedValues[arrayCounter++];
            }
        }
    }

    public static void shuffle(int[] array, int numberOfOnes){
        int temp;
        int index;
        int arrayLength;

        arrayLength = array.length;
        for(int i = arrayLength - 1; i >= 0; i--){
            if(numberOfOnes > 0){
                array[i] = 1;
                numberOfOnes--;
            } else {
                array[i] = 0;
            }
        }

        for(int i = arrayLength - 1; i > 0; i--){
            index = (int) (Math.random() * arrayLength);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
