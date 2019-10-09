package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дана последовательность натуральных чисел а 1 , а 2 ,..., а п . Создать массив из четных чисел этой
 * последовательности. Если таких чисел нет, то вывести сообщение об этом факте.
 */

public class Task5 {
    public static void main(String[] args) {
        int n = 0;
        int[] numbers;
        int[] evenNumbers;

        // Getting user's input
        System.out.println("Enter the size of the array: ");
        n = getNumber();

        // create an array and fill it the array with random numbers
        numbers = new int[n];
        numbers = fillWithRandom(numbers);

        // method takes the array with the sequence and returns an array that contains even digits only. If there is no even digits in it
        // a zero length array is returned.
        evenNumbers = checkEvenNumbers(numbers);
        if(evenNumbers.length == 0){
            System.out.println("There is no even numbers in the sequence " + Arrays.toString(numbers));
        } else {
            Arrays.sort(evenNumbers);
            System.out.println("The sequence " + Arrays.toString(numbers));
            System.out.println("contains the following even digits " + Arrays.toString(evenNumbers));
        }
    }


    public static int getNumber(){
        int n = 0;
        Scanner scanner;
        boolean meetConditions;
        boolean isDigit;

        scanner = new Scanner(System.in);
        do{
            isDigit = false;
            while(!isDigit){
                try{
                    n = scanner.nextInt();
                    isDigit = true;
                } catch (java.util.InputMismatchException e){
                    System.out.println("Please enter a digit!");
                    scanner.next();
                }
            }
            if(n < 1){
                System.out.println("Your array should contain at least one element!");
                meetConditions = false;
            } else {
                meetConditions = true;
            }
        } while(!meetConditions);

        return n;
    }


    public static int[] fillWithRandom(int[] array){
        final int RANGE = 250;

        for(int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * RANGE + 1);
        }

        return array;
    }


    public static int[] checkEvenNumbers(int[] array){
        int[] evenNumbers;
        int count;

        count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                count++;
            }
        }
        evenNumbers = new int[count];
        count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                evenNumbers[count++] = array[i];
            }
        }

        return evenNumbers;
    }
}
