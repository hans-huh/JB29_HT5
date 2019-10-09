package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дана последовательность действительных чисел а 1 а 2 ,..., а n . Выяснить, будет ли она возрастающей.
 */

public class Task4 {
    public static void main(String[] args) {
        int n = 0;
        double[] numbers;
        boolean isIncreasing;

        System.out.println("Enter the size of the array: ");
        n = getNumber();

        numbers = new double[n];

        fillWithRandom(numbers);

        // check if the array is an increasing sequence
        isIncreasing = checkIncreasing(numbers);

        // printing the result
        System.out.println("Before sorting, the array ");
        System.out.println(Arrays.toString(numbers));
        if(isIncreasing){
            System.out.println("represents an increasing sequence");
        } else {
            System.out.println("is not an increasing sequence");
        }

        // let's sort the array in the ascending order
        Arrays.sort(numbers);

        // check if the sequence is increasing now
        isIncreasing = checkIncreasing(numbers);

        // and print the results
        System.out.println("\nAfter sorting, the array ");
        System.out.println(Arrays.toString(numbers));
        if(isIncreasing){
            System.out.println("represents an increasing sequence.");
        } else {
            System.out.println("is not an increasing sequence");
        }
    }


    public static int getNumber(){
        int n = 0;
        Scanner scanner;
        boolean meetCondition;
        boolean isDigit;

        // Getting user's input
        scanner = new Scanner(System.in);
        do{
            isDigit = false;
            while (!isDigit){
                try{
                    n = scanner.nextInt();
                    isDigit = true;
                } catch(java.util.InputMismatchException e){
                    System.out.println("Please enter a digit!");
                    scanner.next();
                }
            }
            if(n < 2) {
                System.out.println("The sequence should have at least two numbers. Try again please!");
                meetCondition = false;
            } else {
                meetCondition = true;
            }
        } while(!meetCondition);

        return n;
    }


    public static void fillWithRandom(double[] array){
        final int RANGE = 250;
        double temp;

        for(int i = 0; i < array.length; i++){
            temp = (Math.random() * RANGE * generateRandNegative());

            // truncating the random number to 2 decimal places
            array[i] = (double) Math.round(temp * 100) / 100;
        }
    }


    public static int generateRandNegative(){
        int n = 0;
        n = (int) (Math.random() * 2);
        if(n == 0){
            return -1;
        } else {
            return 1;
        }
    }


    public static boolean checkIncreasing(double[] array){
        // using this field to store the result of Double.compare function
        double result = 0;

        for(int i = 1; i < array.length; i++){
            result = Double.compare(array[i - 1], array[i]);
            if(result > 0){
                return false;
            }
        }

        return true;
    }



}
