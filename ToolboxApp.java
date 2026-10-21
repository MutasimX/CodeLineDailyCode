package c2_w1_m1;

import java.util.Scanner;

public class ToolboxApp {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            choice = readInt("Please Enter a Number Between 0 and 10");
            switch (choice) {
                case 1:
                    celsiusToFahrenheit();
                    break;
                case 2:
                    evenOrOdd();
                    break;
                case 3:
                    maxOfThree();
                    break;
                case 4:
                    factorial();
                    break;
                case 5:
                    multiplicationTable();
                    break;
                case 6:
                    starTriangle();
                    break;
                case 7:
                    isPrime();
                    break;
                case 8:
                    reverseNumber();
                    break;
                case 9:
                    numberPyramid();
                    break;
                case 10:
                    starDiamond();
                    break;
                case 0:
                    System.out.println("GoodBye");
                    break;
                default:
                    System.out.println("Invalid Choice. Please Try Again.");
            }
        } while (choice != 0);
    }

    public static void menu() {
        System.out.println();
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Even or Odd");
        System.out.println("3. Maximum of Three Numbers");
        System.out.println("4. Factorial");
        System.out.println("5. Multiplication Table");
        System.out.println("6. Triangle of Stars");
        System.out.println("7. Prime Check");
        System.out.println("8. Reverse a Number");
        System.out.println("9. Number Pyramid");
        System.out.println("10. Diamond of Stars");
        System.out.println("0. Exit");
    }

    // Input helpers (handle wrong input types)
    private static int readInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please Enter a Whole Number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.println(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please Enter a Number.");
            }
        }
    }

    // Reads a number of rows that must be at least 1.
    private static int readRows() {
        int rows = readInt("Enter Number of Rows");
        while (rows < 1) {
            System.out.println("The Number of Rows Must Be at Least 1.");
            rows = readInt("Enter Number of Rows");
        }
        return rows;
    }

    //  Menu options
    public static void celsiusToFahrenheit() {
        double celsius = readDouble("Enter Temperature in Celsius");
        double fahrenheit = celsius * 9 / 5 + 32;
        System.out.println(celsius + " C = " + fahrenheit + " F");
    }

    public static void evenOrOdd() {
        int number = readInt("Enter an Integer");
        if (number % 2 == 0) {
            System.out.println(number + " is Even.");
        } else {
            System.out.println(number + " is Odd.");
        }
    }

    public static void maxOfThree() {
        int first = readInt("Enter the First Integer");
        int second = readInt("Enter the Second Integer");
        int third = readInt("Enter the Third Integer");
        int max = Math.max(first, Math.max(second, third));
        System.out.println("The Largest Number is " + max);
    }

    public static void factorial() {
        int number = readInt("Enter a Non-Negative Number (0 to 15)");
        if (number < 0 || number > 15) {
            System.out.println("Number Out of Range. It Must Be Between 0 and 15.");
            return;
        }
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        System.out.println(number + "! = " + result);
    }

    public static void multiplicationTable() {
        int number = readInt("Enter a Number");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + number * i);
        }
    }

    public static void starTriangle() {
        int rows = readRows();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void isPrime() {
        int number = readInt("Enter an Integer Greater Than 1");
        if (number <= 1) {
            System.out.println("The Number Must Be Greater Tan 1.");
            return;
        }
        boolean prime = true;
        for (int i = 2; (long) i * i <= number; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }
        if (prime) {
            System.out.println(number + " is Prime.");
        } else {
            System.out.println(number + " is Not Prime.");
        }
    }

    public static void reverseNumber() {
        int number = readInt("Enter a Positive Integer");
        if (number <= 0) {
            System.out.println("The Number Must Be Positive.");
            return;
        }
        long reversed = 0;
        int remaining = number;
        while (remaining > 0) {
            reversed = reversed * 10 + remaining % 10;
            remaining /= 10;
        }
        System.out.println("Reversed Number: " + reversed);
    }

    public static void numberPyramid() {
        int rows = readRows();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // Bonus option 10
    public static void starDiamond() {
        int rows = readRows();
        for (int i = 1; i <= rows; i++) {
            printStarRow(rows - i, i);
        }
        for (int i = rows - 1; i >= 1; i--) {
            printStarRow(rows - i, i);
        }
    }

    private static void printStarRow(int spaces, int stars) {
        for (int s = 0; s < spaces; s++) {
            System.out.print(" ");
        }
        for (int s = 0; s < stars; s++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
