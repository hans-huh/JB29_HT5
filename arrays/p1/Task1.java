package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */

public class Task1 {
    public static void main(String[] args) {
        int n = 0;
        int[] array;
        int k = 0;
        int sum = 0;

        System.out.println("Enter the value of n: ");
        n = getNumber();
        System.out.println("Enter the value of k: ");
        k = getNumber();

        // creating an array of n elements
        array = new int[n];

        // fill the array with random values
        array = fillWithRandom(array);

        // find sum of elements that can be divided by k
        sum = findSum(array, k);

        System.out.println("Given the array " + Arrays.toString(array));
        System.out.println("The sum of elements divisible by " + k + " is " + sum);

    }


    public static int getNumber(){
        int n = 0;
        Scanner scanner;
        boolean meetCondition;
        boolean isDigit;

        scanner = new Scanner(System.in);
        do{
            isDigit = false;
            while(!isDigit){
                try {
                    n = scanner.nextInt();
                    isDigit = true;
                }
                catch (java.util.InputMismatchException e){
                    System.out.println("Please enter a digit!");
                    scanner.next();
                }
            }

            if(n < 1) {
                System.out.println("Incorrect value. The number should be greater than zero! Try again...");
                meetCondition = false;
            } else {
                meetCondition = true;
            }

        } while(!meetCondition);

        return n;
    }


    public static int[] fillWithRandom(int[] array){
        final int RANGE = 200;
        for(int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * RANGE + 1);
        }
        return array;
    }


    public static int findSum(int[] array, int k){
        int sum = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] % k == 0){
                sum += array[i];
            }
        }

        return sum;
    }
}
