package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Даны действительные числа a 1 , a 2 , ... , a 2n . Найти
 * max( a 1 + a 2 n , a 2 + a 2 n − 1 ,  , a n + a n + 1 )
 */

public class Task16 {
    public static void main(String[] args) {
        int n;
        double[] numbers;
        double[] arrayOfSums;

        System.out.println("Enter the value of n: ");
        n = getNumber();

        numbers = new double[2 * n];
        fillWithRandom(numbers);

        arrayOfSums = getSums(numbers, n);

        System.out.println("Given the array");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Max number is " + findMax(arrayOfSums));
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


    public static void fillWithRandom(double[] array){
        final int RANGE = 20;
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


    public static double[] getSums(double[] array, int n){
        double[] output;
        double temp;
        int counter;


        counter = 0;
        for(int i = 0, k = array.length - 1; i < n && k >= n; i++, k--){
            temp = (array[i] + array[k]);
            temp = (double) Math.round(temp * 100) / 100;
            counter++;
        }

        output = new double[counter];
        counter = 0;

        for(int i = 0, k = array.length - 1; i < n && k >= n; i++, k--){
            temp = (array[i] + array[k]);
            temp = (double) Math.round(temp * 100) / 100;
            output[counter++] = temp;
        }

        return output;
    }


    public static double findMax(double[] array){
        int result;
        Double max = Double.NEGATIVE_INFINITY;

        for(int i = 0; i < array.length; i++){
            result = Double.compare(array[i], max);
            if(result > 0){
                max = array[i];
            }
        }

        return max;
    }
}
