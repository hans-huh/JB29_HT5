package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
 * являются простыми числами.
 */

public class Task12 {
    public static void main(String[] args) {
        int n;
        double[] numbers;
        double sum = 0;

        System.out.println("Enter the size of the array: ");
        n = getNumber();

        numbers = new double[n];
        fillWithRandom(numbers);

        // Calculate sum of array values whose indexes are prime numbers
        System.out.println("Given the array");
        System.out.println(Arrays.toString(numbers));
        sum = calculatePrimeIndexSum(numbers);
        System.out.println("The sum of array values where indexes are prime numbers is " + sum);
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


    public static double calculatePrimeIndexSum(double[] array){
        double sum = 0;
        for(int i = 0; i < array.length; i++){
            if(checkPrime(i + 1)){
                sum += array[i];
            }
        }

        return (double) Math.round(sum * 100) / 100;
    }


    public static boolean checkPrime(int n){
        for(int i = 2; i <= n / 2; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
