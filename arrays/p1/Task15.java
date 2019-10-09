package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дана последовательность действительных чисел a 1 , a 2 ,  , a n . Указать те ее элементы, которые
 * принадлежат отрезку [с, d].
 */

public class Task15 {
    public static void main(String[] args) {
        double[] numbers;
        double[] elements;
        int n;
        double c;
        double d;

        System.out.println("Enter the size of the array: ");
        n = Math.abs( (int) getNumber());
        System.out.println("Enter the value of c: ");
        c = getNumber();
        System.out.println("Enter the value of d: ");
        d = getNumber();

        numbers = new double[n];
        fillWithRandom(numbers);

        // finding elements that belong to specific range c...d
        elements = findElementsRange(numbers, c, d);

        System.out.println("Given the array");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Elements that are located in the range [" + c + "..." + d + "] are");
        System.out.println(Arrays.toString(elements));

    }


    public static double getNumber(){
        double n = 0;
        Scanner scanner;
        boolean meetCondtion;
        boolean isDigit;

        scanner = new Scanner(System.in);
        isDigit = false;
        while(!isDigit){
            try{
                n = scanner.nextDouble();
                isDigit = true;
            } catch (java.util.InputMismatchException e){
                System.out.println("Please enter a numeric value!");
                scanner.next();
            }
        }
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


    public static double[] findElementsRange(double[] array, double lowerBoundary, double upperBoundary){
        double[] results;
        int tempResult;
        int counter;

        counter = 0;
        for(int i = 0; i < array.length; i++){
            tempResult = Double.compare(array[i], lowerBoundary);
            if(tempResult >= 0){
                tempResult = Double.compare(array[i], upperBoundary);
                if(tempResult <= 0){
                    counter++;
                }
            }
        }

        results = new double[counter];
        counter = 0;

        for(int i = 0; i < array.length; i++) {
            tempResult = Double.compare(array[i], lowerBoundary);
            if (tempResult >= 0) {
                tempResult = Double.compare(array[i], upperBoundary);
                if (tempResult <= 0) {
                    results[counter++] = array[i];
                }
            }

        }

        return results;
    }

}
