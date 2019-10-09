package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 * Операция сглаживания матрицы дает новую матрицу того же размера, каждый элемент которой
 * получается как среднее арифметическое соседей соответствующего элемента исходной матрицы.
 * Построить результат сглаживания заданной матрицы
 */

public class Task36 {
    public static void main(String[] args) {
        int m;
        int n;
        int[][] matrix;
        int[][] smoothedMatrix;

        System.out.println("Creating a matrix...");
        System.out.println("PLease enter the number of rows: ");
        m = getNumber();
        System.out.println("Please enter the number of columns: ");
        n = getNumber();

        matrix = createMatrix(m, n);
        fillWithRandoms(matrix);

        System.out.println("Matrix before smoothing: \n");
        printMatrix(matrix);

        smoothedMatrix = smoothMatrix(matrix);

        System.out.println("\nMatrix after smoothing: \n");
        printMatrix(smoothedMatrix);

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
        final int RANGE = 99;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                matrix[i][k] = (int) (Math.random() * (RANGE + 1));
            }
        }
    }


    public static int[][] smoothMatrix(int[][] matrix){
        int x;
        int y;
        int numOfColumns;
        int numOfRows;
        int[][] smoothedMatrix;

        numOfRows = matrix.length;
        numOfColumns = matrix[0].length;
        smoothedMatrix = new int[numOfRows][numOfColumns];

        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < numOfColumns; j++){
                smoothedMatrix[i][j] = getArithmeticMeanOfNeighbors(matrix, i, j);
            }
        }

        return smoothedMatrix;
    }


    public static int getArithmeticMeanOfNeighbors(int[][] matrix, int x, int y){
        int numOfRows;
        int numOfColumns;
        int sum;
        int counter;

        numOfRows = matrix.length;
        numOfColumns = matrix[0].length;
        sum = 0;
        counter = 0;

        if( (x - 1) >= 0 ){
            sum += matrix[x-1][y];
            counter++;

            if( (y - 1) >= 0){
                sum += matrix[x-1][y-1];
                counter++;
            }

            if( (y + 1) < numOfColumns){
                sum += matrix[x-1][y + 1];
                counter++;
            }
        }

        if( (x + 1) < numOfRows){
            sum += matrix[x+1][y];
            counter++;

            if( (y - 1) >= 0){
                sum += matrix[x+1][y-1];
                counter++;
            }

            if( (y + 1) < numOfColumns){
                sum += matrix[x+1][y + 1];
                counter++;
            }
        }


        if( (y - 1) >= 0){
            sum += matrix[x][y-1];
            counter++;
        }

        if( (y + 1) < numOfColumns){
            sum += matrix[x][y + 1];
            counter++;
        }

        return (int) Math.round(sum / counter);
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
}
