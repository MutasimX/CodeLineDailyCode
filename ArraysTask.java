package c3_m1;

import java.util.Scanner;

public class ArraysTask {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers = {12, 7, 25, 3, 18, 9, 30, 14};

        System.out.println("Sum: " + sumArray(numbers));
        System.out.println("Average: " + averageArray(numbers));
        System.out.println("Max: " + findMax(numbers));
        System.out.println("Min: " + findMin(numbers));
        System.out.println("Difference: " + (findMax(numbers) - findMin(numbers)));
        System.out.println("Even numbers: " + countEven(numbers));

        System.out.print("Enter a number to search for ");
        int target = scanner.nextInt();
        int index = indexOf(numbers, target);
        if (index != -1) {
            System.out.println(target + " found at index " + index);
        } else {
            System.out.println(target + " not found");
        }

        System.out.print("Original: ");
        printArray(numbers);

        int[] reversed = reverseArray(numbers);

        System.out.print("Reversed: ");
        printArray(reversed);

        int[] grades = readGrades(5);
        int passed = countPassed(grades);
        int failed = grades.length - passed;

        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);

        scanner.close();
    }

    static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    static double averageArray(int[] arr) {
        if (arr.length == 0) {
            return 0.0;
        }
        return (double) sumArray(arr) / arr.length;
    }

    static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    static int countEven(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int[] reverseArray(int[] arr) {
        int[] reversedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - i - 1];
        }
        return reversedArr;
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] readGrades(int size) {
        int[] grades = new int[size];
        for (int i = 0; i < size; i++) {
            while (true) {
                System.out.println("Enter grade " + (i + 1));
                int grade = scanner.nextInt();

                if (grade >= 0 && grade <= 100) {
                    grades[i] = grade;
                    break;
                } else {
                    System.out.println("Invalid Grade! Enter a Grade from 0 to 100.");
                }
            }
        }
        return grades;
    }

    static int countPassed(int[] grades) {
        int count = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 50) {
                count++;
            }
        }
        return count;
    }
}