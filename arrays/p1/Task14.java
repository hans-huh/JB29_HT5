package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дан одномерный массив A[N]. Найти:
 * max( a 2 , a 4 ,  , a 2 k ) + min( a 1 , a 3 ,  , a 2 k + 1 )
 */

public class Task14 {
    public static void main(String[] args) {
        int n;
        int[] numbers;
        int result;

        System.out.println("Enter the value of N: ");
        n = getNumber();

        numbers = new int[n];

        fillWithRandom(numbers);

        result = findSum(numbers);

        System.out.println("In the array");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Sum of max, stored at an odd index, and min, stored at an even index, is " + result);
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
        final int RANGE = 20;

        for(int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * RANGE);
        }
    }


    public static int findSum(int[] array) {
        int sum;
        int[] oddIndex;
        int[] evenIndex;
        int oddCounter;
        int evenCounter;

        oddCounter = 0;
        evenCounter = 0;
        for(int i = 0; i < array.length; i++){
            if(i % 2 == 0){
                oddCounter++;
            } else {
                evenCounter++;
            }
        }

        oddIndex = new int[oddCounter];
        evenIndex = new int[evenCounter];
        oddCounter = 0;
        evenCounter = 0;
        for(int i = 0; i < array.length; i++){
            if(i % 2 == 0){
                oddIndex[oddCounter++] = array[i];
            } else {
                evenIndex[evenCounter++] = array[i];
            }
        }

        return findMax(oddIndex) + findMin(evenIndex);
    }


    public static int findMax(int[] array){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }

        return max;
    }


    public static int findMin(int[] array){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
        }

        return min;
    }
}
