package by.ld.hw.arrays.matrix;

/**
 * Магическим квадратом порядка n называется квадратная матрица размера n x n, составленная из чисел 1,
 * 2, 3, ..., n 2 так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны
 * между собой. Построить такой квадрат
 */

import java.util.Scanner;

public class Task40 {
    public static void main(String[] args) {
        int n;
        int[][] magicSquare;

        System.out.println("Creating a square matrix of size n...");
        System.out.println("Please enter the value of n: ");
        n = getNumber();

        magicSquare = createSquareMatrix(n);

        makeMagicSquare(magicSquare);

        System.out.println("The magic square of order " + n + ": ");
        printMatrix(magicSquare);
    }


    public static int getNumber(){
        int n = 0;
        Scanner scanner;
        boolean isDigit;
        boolean meetCondition;

        scanner = new Scanner(System.in);
        do{
            isDigit = false;
            while(!isDigit){
                try{
                    n = scanner.nextInt();
                    isDigit = true;
                } catch(java.util.InputMismatchException e){
                    System.out.println("Please enter a digit!");
                    scanner.next();
                }
            }
            if(n < 2){
                System.out.println("Your matrix should have at least two rows / two columns. Please try again!");
                meetCondition = false;
            } else if(n % 2 == 0){
                System.out.println("Please enter an odd digit!");
                meetCondition = false;
            } else {
                meetCondition = true;
            }
        } while (!meetCondition);

        return n;
    }


    public static int[][] createSquareMatrix(int n){
        int[][] matrix;

        matrix = new int[n][n];

        return matrix;
    }


    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int cell : row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


    public static void makeMagicSquare(int[][] matrix){
        int n;
        int row;
        int column;
        int value;

        n = matrix.length;

        // setting the position of the first value in the magic square
        row = n / 2;
        column = n - 1;

        value = 1;
        while(value <= n * n){
            if(row == -1 && column == n){
                column = n - 2;
                row = 0;
            } else {
                if(column == n){
                    column = 0;
                }

                if(row < 0){
                    row = n - 1;
                }
            }

            if(matrix[row][column] != 0){
                column = column - 2;
                row++;
                continue;
            } else {
                matrix[row][column] = value++;
            }
            column++;
            row--;
        }

    }
}
