package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Даны натуральные числа а 1 ,а 2 ,..., а n . Указать те из них, у которых остаток от деления на М равен L (0 < L
 * < М-1).
 */

public class Task11 {
    public static void main(String[] args) {
        int n;
        int m;
        int[] numbers;

        // Get user's input
        System.out.println("Enter the size of the array: ");
        n = getNumber();
        System.out.println("Enter the value of M: ");
        m = getNumber();

        // Create an array and fill it with random positive digits
        numbers = new int[n];
        fillWithRandom(numbers);

        printElementsWithRemainder(numbers, m);

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
        final int RANGE = 250;

        for(int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * RANGE);
        }
    }


    public static void printElementsWithRemainder(int[] array, int m){
        int remainder = 0;

        System.out.println("Given the array ");
        System.out.println(Arrays.toString(array));
        System.out.println("The elements that can be divided by " + m + ", and have the remainder L, where 0 < L < " + (m - 1) + " are: \n");

        for(int i = 0; i < array.length; i++){
            remainder = array[i] % m;
            if(remainder > 0 && remainder < (m - 1)){
                System.out.print(array[i] + " ");
            }
        }
    }


}
