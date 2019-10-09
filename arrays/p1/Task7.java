package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дана последовательность действительных чисел а 1 ,а 2 ,..., а п . Заменить все ее члены, большие данного Z,
 * этим числом. Подсчитать количество замен.
 */

public class Task7 {
    public static void main(String[] args) {
        double[] numbers;
        double[] numbersAfterReplacement;
        int counter = 0;
        int n;
        int z;

        System.out.println("Enter the size of the array: ");
        n = getNumber();
        System.out.println("Enter the value of Z: ");
        z = getNumber();

        // Create an array and fill it with random numbers
        numbers = new double[n];
        fillWithRandom(numbers);
        System.out.println("Array before replacement: ");
        System.out.println(Arrays.toString(numbers));

        // replace elements that are greater than k with the value of z;
        numbersAfterReplacement = replaceNumber(numbers, z);
        System.out.println("Array after replacement: ");
        System.out.println(Arrays.toString(numbersAfterReplacement));

        // check how many times elements of the array were replaced by the value of z
        counter = compareArrays(numbers, numbersAfterReplacement);
        System.out.println("\nThe total number of replacements, when Z = " + z + " is " + counter);


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

    public static double[] replaceNumber(double[] array, int z){
        double[] output;
        double result;

        output = new double[array.length];
        for(int i = 0; i < array.length; i++){
            result = Double.compare(array[i], z);
            if(result > 0){
                output[i] = z;
            } else {
                output[i] = array[i];
            }
        }
        return output;
    }


    public static int compareArrays(double[] first, double[] second){
        int counter = 0;
        for(int i = 0; i < first.length; i++){
            if(first[i] != second[i]){
                counter++;
            }
        }

        return counter;
    }
}
