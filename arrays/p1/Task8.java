package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
 * положительных и нулевых элементов.
 */

public class Task8 {
    public static void main(String[] args) {
        int n;
        double[] numbers;

        // Getting user's input
        System.out.println("Enter the value of N: ");
        n = getNumber();

        // Creating an array and fill it with random numbers
        numbers = new double[n];
        fillWithRandom(numbers);

        // Finding how many positive, negative and zeros are in the array
        findSignOfElements(numbers);
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
        final int RANGE = 15;
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


    public static void findSignOfElements(double[] array){
        int result = 0;
        int positiveCounter = 0;
        int zeroCounter = 0;
        int negativeCounter = 0;

        for(int i = 0; i < array.length; i++){
            result = Double.compare(array[i], 0);
            if(result > 0){
                positiveCounter++;
            } else if(result < 0){
                negativeCounter++;
            } else {
                zeroCounter++;
            }
        }

        System.out.println("In the array " + Arrays.toString(array));
        System.out.println("Number of positive integers: " + positiveCounter);
        System.out.println("Number of negative integers: " + negativeCounter);
        System.out.println("Number of zeroes: " + zeroCounter);
    }
}
