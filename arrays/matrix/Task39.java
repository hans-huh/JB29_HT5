package by.ld.hw.arrays.matrix;

import java.util.Scanner;

public class Task39 {
    public static void main(String[] args) {
        int m;
        int n;
        int[][] firstMatrix;
        int[][] secondMatrix;
        int[][] product;

        System.out.println("Creating first matrix...");
        System.out.println("PLease enter the number of rows: ");
        m = getNumber();
        System.out.println("Please enter the number of columns: ");
        n = getNumber();

        firstMatrix = createMatrix(m, n);
        fillWithRandoms(firstMatrix);

        System.out.println("First matrix has been created!");
        System.out.println("Creating second matrix...");
        System.out.println("PLease enter the number of rows: ");
        m = getNumber();
        System.out.println("Please enter the number of columns: ");
        n = getNumber();

        secondMatrix = createMatrix(m, n);
        fillWithRandoms(secondMatrix);
        System.out.println("Second matrix has been created!");

        product = multiplyMatrices(firstMatrix, secondMatrix);

        if(product.length != 0){
            System.out.println("The product of matrix A: \n");
            printMatrix(firstMatrix);
            System.out.println("\nmultiplied by matrix B: \n");
            printMatrix(secondMatrix);
            System.out.println("\nis: \n");
            printMatrix(product);
        }

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
        final int RANGE = 5;

        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                matrix[i][k] = (int) (Math.random() * (RANGE)) + 1;
            }
        }
    }


    public static int[][] multiplyMatrices(int[][] first, int[][] second){
        int[][] product;
        int indexRow;
        int indexColumn;
        int temp;

        if(first[0].length != second.length){
            System.out.println("The number of columns of the 1st matrix\n" +
                    "should equal the number of rows of the second column!]n");
            product = new int[0][0];
            return product;
        }

        product = new int[first.length][second[0].length];
        indexRow = 0;
        indexColumn = 0;

        for(int i = 0; i < first.length; i++){
            for(int j = 0; j < second[0].length; j++){
                temp = 0;
                for(int k = 0; k < second.length; k++){
                    temp = temp + (first[i][k] * second[k][j]);
                }
                product[i][j] = temp;
            }
        }

        return product;
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
            if(n < 1){
                System.out.println("Your matrix should have at least 1 row / column. Please try again!");
                meetCondition = false;
            } else {
                meetCondition = true;
            }
        } while (!meetCondition);

        return n;
    }
}
