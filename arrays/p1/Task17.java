package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дана последовательность целых чисел a 1 , a 2 ,  , a n . Образовать новую последовательность, выбросив из
 * исходной те члены, которые равны min( a 1 , a 2 ,  , a n ) .
 */

public class Task17 {
    public static void main(String[] args) {
        int n;
        int[] numbers;
        int[] numbersWithoutMin;

        System.out.println("Enter the size of the array:");
        n = getNumber();

        numbers = new int[n];
        fillWithRandom(numbers);

        numbersWithoutMin = removeMinValue(numbers);

        System.out.println("Given the array");
        System.out.println(Arrays.toString(numbers));
        System.out.println("The array without min element(s) is ");
        System.out.println(Arrays.toString(numbersWithoutMin));
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
            if(n < 1){
                System.out.println("Your array should have at least one element!");
                meetCondtion = false;
            } else {
                meetCondtion = true;
            }

        } while(!meetCondtion);

        return n;
    }


    public static void fillWithRandom(int[] array){
        final int RANGE = 10;

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


    public static int[] removeMinValue(int[] array){
        int min;
        int[] output;
        int counter;

        counter = 0;
        min = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++){
            if(min > array[i]){
                min = array[i];
            }
        }

        for(int i = 0; i < array.length; i++){
            if(array[i] > min){
                counter++;
            }
        }

        output = new int[counter];
        counter = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] > min){
                output[counter++] = array[i];
            }
        }

        return output;
    }
}
