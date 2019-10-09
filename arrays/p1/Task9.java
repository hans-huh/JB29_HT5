package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Даны действительные числа а 1 ,а 2 ,..., а n . Поменять местами наибольший и наименьший элементы.
 */

public class Task9 {
    public static void main(String[] args) {
        int n;
        double [] numbers;

        // Getting user's input
        System.out.println("Enter the size of the array: ");
        n = getNumber();

        // Creating an array and fill it with random values
        numbers = new double[n];
        fillWithRandom(numbers);

        // Sort the array in ascending order.
        Arrays.sort(numbers);
        System.out.println("Array before swapping:");
        System.out.println(Arrays.toString(numbers));

        // since the array is already sorted, all we need is to swap first and last elements of the array
        swap(numbers, 0, numbers.length - 1);

        System.out.println("Array after swapping: ");
        System.out.println(Arrays.toString(numbers));
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


    public static void swap(double[] array, int a, int b){
        double temp = 0;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
