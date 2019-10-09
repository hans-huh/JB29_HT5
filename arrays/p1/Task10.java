package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Даны целые числа а 1 ,а 2 ,..., а n . Вывести на печать только те числа, для которых а i > i.
 */

public class Task10 {
    public static void main(String[] args) {
        int n;
        int[] numbers;

        // Getting user's input
        System.out.println("Enter the size of the array: ");
        n = getNumber();

        // Create an array and fill it with random integers
        numbers = new int[n];
        fillWithRandom(numbers);

        printElementIndex(numbers);
    }


    public static int getNumber(){
        int n = 0;
        Scanner scanner;
        boolean meetCondtion;
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
            if(n < 2){
                System.out.println("Your array should have at least two elements!");
                meetCondtion = false;
            } else {
                meetCondtion = true;
            }

        } while(!meetCondtion);

        return n;
    }


    public static void fillWithRandom(int[] array){
        final int RANGE = 25;

        for(int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * RANGE * generateRandNegative());
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


    public static void printElementIndex(int[] array){
        System.out.println("In the array: ");
        System.out.println(Arrays.toString(array));
        System.out.println("The elements that are greater than their respective indexes are: \n");
        int counter = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > i){
                System.out.print(array[i] + " ");
                counter++;
                if(counter == 10){
                    counter = 0;
                    System.out.println();
                }
            }
        }
    }
}


