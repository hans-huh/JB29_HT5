package by.ld.hw.arrays.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * В целочисленной последовательности есть нулевые элементы. Создать массив из номеров этих элементов.
 */

public class Task2 {
    public static void main(String[] args) {
        int n = 0;
        int[] array;
        int[] indexOfZeros;

        // getting user's input
        System.out.println("What is the size of the integer sequence: ");
        n = getNumber();

        // creating an array with random numbers in it
        array = new int[n];
        array = fillWithRandom(array);

        // finding the indexes of zero elements and storing them in the array
        indexOfZeros = findZeros(array);

        System.out.println("In the array " + Arrays.toString(array));
        System.out.println("zero elements are stored at the following indexes: ");
        System.out.println(Arrays.toString(indexOfZeros));
    }


    public static int getNumber(){
        int n = 0;
        boolean meetCondition;
        boolean isDigit;
        Scanner scanner;

        scanner = new Scanner(System.in);
        do{
            isDigit = false;
            while(!isDigit){
                try{
                    n = scanner.nextInt();
                    isDigit = true;
                } catch(java.util.InputMismatchException e) {
                    System.out.println("Please enter a digit!");
                    scanner.next();
                }
            }
            if(n <= 0){
                System.out.println("Number should be greater than zero! Try again please...");
                meetCondition = false;
            } else {
                meetCondition = true;
            }
        } while (!meetCondition);


        return n;
    }


    public static int[] fillWithRandom(int[] array){
        final int RANGE = 10;

        for(int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * RANGE);
        }

        return array;
    }


    public static int[] findZeros(int[] array){
        int[] indexes;
        int count;

        count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                count++;
            }
        }

        indexes = new int[count];
        count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                indexes[count++] = i;
            }
        }

        return indexes;
    }
}
