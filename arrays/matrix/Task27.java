package by.ld.hw.arrays.matrix;

import java.util.Scanner;

/**
 *  В числовой матрице поменять местами
 *  два столбца любых столбца, т. е. все элементы одного столбца поставить на соответствующие им позиции другого,
 *  а его элементы второго переместить в первый. Номера столбцов вводит пользователь с клавиатуры
 */

public class Task27 {
    public static void main(String[] args) {
        int m;
        int n;
        int firstColumn;
        int secondColumn;
        int[][] matrix;

        System.out.println("Creating a matrix...");
        System.out.println("Please enter the number of rows: ");
        m = getNumber();
        System.out.println("Please enter the number of columns: ");
        n = getNumber();

        matrix = createMatrix(m, n);

        // generating random numbers
        fillWithRandoms(matrix);

        System.out.println("Matrix before column swap");
        printMatrix(matrix);

        System.out.println("Please enter the first column to swap: ");
        firstColumn = getNumber(matrix);
        System.out.println("Please enter the second column to swap: ");
        secondColumn = getNumber(matrix);

        swapColumns(matrix, firstColumn, secondColumn);

        System.out.println("Matrix after column swap: ");
        printMatrix(matrix);

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

    public static int getNumber(int[][] matrix){
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
            n -= 1; // reduce by 1 to match the array indexes
            if(n >= 0 && n < matrix[0].length){
                meetCondition = true;
            } else {
                System.out.println("Incorrect column number! Try again...");
                meetCondition = false;
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

    public static void swapColumns(int[][] matrix, int firstColumn, int secondColumn){
        int totalColumns;
        int totalRows;
        int temp;

        totalRows = matrix.length;
        totalColumns = matrix[0].length;
        for(int i = 0; i < totalRows; i++){
            temp = matrix[i][firstColumn];
            matrix[i][firstColumn] = matrix[i][secondColumn];
            matrix[i][secondColumn] = temp;
        }
    }

}
