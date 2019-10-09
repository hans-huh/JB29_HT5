package by.ld.hw.arrays.p1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
 * чисел несколько, то определить наименьшее из них.
 */

public class Task18 {
    public static void main(String[] args) {
        int n;
        int[] numbers;
        int range;
        int result;

        System.out.println("Enter the size of the array: ");
        n = getNumber();

        System.out.println("Please enter the max value of gererated random numbers: ");
        range = getNumber();

        numbers = new int[n];
        fillWithRandom(numbers, range);

        // finding the element with max number of occurences in the array
        result = findMaxOccurrence(numbers);
        System.out.println("In the array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.println("\n most common element is: " + result);
    }


    public static int getNumber(){
        int n = 0;
        boolean meetCondition;
        boolean isDigit;
        Scanner scanner;

        scanner = new Scanner(System.in);
        do{
            isDigit = false;
            while(!isDigit){
                try{
                    n = scanner.nextInt();
                    isDigit = true;
                } catch(java.util.InputMismatchException e){
                    System.out.println("Please enter an integer!");
                    scanner.next();
                }
            }
            if(n < 2){
                System.out.println("The input should not be less than two. Please try again: ");
                meetCondition = false;
            } else {
                meetCondition = true;
            }
        } while(!meetCondition);

        return n;
    }


    public static void fillWithRandom(int[] array, int range){

        for(int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * (range + 1) * generateRandNegative());
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

    public static int findMaxOccurrence(int[] array){
        int indexOfMax;
        int temp;
        int[] negativeCounter;
        int[] positiveCounter;
        int negativeMaxIndex;
        int positiveMaxIndex;
        int max;

        max = findMax(array);

        // creating two arrays of size = max element in the array passed as the parameter.
        // For every occurrence of a specific number, the element at the respective index will be incremented by one
        negativeCounter = new int[max + 1];
        positiveCounter = new int[max + 1];

        // fill the arrays with zeros
        Arrays.fill(negativeCounter, 0);
        Arrays.fill(positiveCounter, 0);

        for(int i = 0; i < array.length; i++){
            if(array[i] < 0){
                temp = (int) Math.abs(array[i]);

                negativeCounter[temp]++;
            } else {
                temp = array[i];
                positiveCounter[temp]++;
            }
        }

        // finding the indexes where the biggest number of occurrences is stored
        negativeMaxIndex = findNegativeMaxOccurrence(negativeCounter);
        positiveMaxIndex = findPositiveMaxOccurrence(positiveCounter);

        if(negativeMaxIndex <= positiveMaxIndex){
            return positiveMaxIndex;
        } else {
            return negativeMaxIndex * (-1);
        }

    }


    public static int findMax(int[] array){
        int max;
        int temp;

        max = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            temp = Math.abs(array[i]);
            if (temp > max){
                max = temp;
            }
        }

        return max;
    }


    public static int findNegativeMaxOccurrence(int[] array){
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }


    public static int findPositiveMaxOccurrence(int[] array){
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

}