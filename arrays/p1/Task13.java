package by.ld.hw.arrays.p1;

import java.util.Scanner;

/**
 * Определить количество элементов последовательности натуральных чисел, кратных числу М и
 * заключенных в промежутке от L до N.
 */

public class Task13 {
    public static void main(String[] args) {
        int size;
        int[] numbers;
        int n;
        int l;
        int m;
        int counter;

        System.out.println("Enter the size of the array: ");
        size = getNumber();
        System.out.println("Enter the value of L: ");
        l = getNumber();
        System.out.println("Enter the value of N: ");
        n = getNumber();
        System.out.println("Enter the value of M: ");
        m = getNumber();

        numbers = new int[size];
        fillWithRandom(numbers);

        counter = findElementsInRange(numbers, l, n, m);
        System.out.println("The number of elements from L to N with M as multiplier is " + counter);
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
        final int RANGE = 500;

        for(int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * RANGE);
        }
    }


    public static int findElementsInRange(int[] array, int start, int end, int m){
        int counter = 0;

        for(int i = start; i <= end; i++){
            if(array[i] % m == 0){
                counter++;
            }
        }

        return counter;
    }
}
