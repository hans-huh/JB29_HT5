package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дана последовательность чисел а 1 ,а 2 ,..., а п . Указать наименьшую длину числовой оси, содержащую все эти
 * числа.
 */

public class Task6 {
    public static void main(String[] args) {
        int n = 0;
        int[] numbers;
        int min = 0;
        int max = 0;

        // Getting user's input
        System.out.println("Enter the size of the array: ");
        n = getNumber();

        // create an arraty and fill it with random values
        numbers = new int[n];
        numbers = fillWithRandom(numbers);

        // sort the array in ascending order and select the first and the last values
        Arrays.sort(numbers);
        min = numbers[0];
        max = numbers[numbers.length - 1];

        System.out.println("For the array " + Arrays.toString(numbers));
        System.out.println("The length of the number line is " + (max - min));

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


    public static int[] fillWithRandom(int[] array){
        final int RANGE = 10;

        for(int i = 0; i < array.length; i++){
            array[i] = (int) ((Math.random() * RANGE + 1) * generateRandNegative());
        }

        return array;
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
}
