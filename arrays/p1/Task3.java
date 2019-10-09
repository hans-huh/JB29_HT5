package by.ld.hw.arrays.p1;

import java.util.Scanner;

/**
 * Дана последовательность целых чисел а 1 а 2 ,..., а n . Выяснить, какое число встречается раньше -
 * положительное или отрицательное.
 */

public class Task3 {
    public static void main(String[] args) {
        int n = 0;
        int[] numbers;
        boolean isNegative;

        // Getting user's input
        System.out.println("Enter the value of n: ");
        n = getNumber();

        // Create an array
        numbers = new int[n];

        // Fill the array with random positive or negative numbers
        numbers = fillWithRandom(numbers);

        isNegative = negativeCheck(numbers);

        if (isNegative) {
            System.out.println("The first number in the sequence is negative");
        } else {
            System.out.println("The first number in the sequence is positive");
        }
    }


    public static int getNumber() {
        int n = 0;
        Scanner scanner;
        boolean meetCondition;
        boolean isDigit;


        // Getting user's input
        scanner = new Scanner(System.in);
        do {
            isDigit = false;
            while (!isDigit) {
                try {
                    n = scanner.nextInt();
                    isDigit = true;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Please enter a digit!");
                    scanner.next();
                }
            }

            if (n < 2) {
                System.out.println("The sequence should have at least two numbers. Try again please!");
                meetCondition = false;
            } else {
                meetCondition = true;
            }

        } while (!meetCondition);

        return n;
    }


    public static int[] fillWithRandom(int[] array) {
        final int RANGE = 250;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * RANGE + 1) * generateRandNegative());
        }

        return array;
    }


    public static int generateRandNegative() {
        int n = 0;
        n = (int) (Math.random() * 2);
        if (n == 0) {
            return -1;
        } else {
            return 1;
        }
    }


    public static boolean negativeCheck(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                return true;
            } else if (array[i] > 0) {
                return false;
            } else {
                continue;
            }
        }

        return false;
    }

}
