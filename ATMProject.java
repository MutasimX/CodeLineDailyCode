package week2;

import java.util.Scanner;

public class ATMProject {

    private static final Scanner scanner = new Scanner(System.in);

    private static final int MaxLoginAttempts = 3;
    private static final double MaxDeposit = 5000;
    private static final double MaxSessionWithdrawal = 1000;

    private static double balance = 1000.00;
    private static int pin = 1234;

    private static int depositCount = 0;
    private static double depositTotal = 0;
    private static double highestDeposit = 0;

    private static int withdrawalCount = 0;
    private static double withdrawalTotal = 0;
    private static double highestWithdrawal = 0;

    public static void main(String[] args) {
        if (login()) {
            runMenu();
        }
    }

    // Input
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

    // Login
    private static boolean login() {
        for (int attempt = 1; attempt <= MaxLoginAttempts; attempt++) {
            int enteredPin = readInt("Enter PIN");
            if (enteredPin == pin) {
                System.out.println("Welcome!");
                return true;
            }
            int attemptsLeft = MaxLoginAttempts - attempt;
            if (attemptsLeft > 0) {
                System.out.println("Wrong PIN. Attempts Left: " + attemptsLeft);
            }
        }
        System.out.println("CARD LOCKED");
        return false;
    }

    // Menu
    private static void menu() {
        System.out.println();
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Account Tier");
        System.out.println("5. Savings Projection");
        System.out.println("6. Receipt Summary");
        System.out.println("7. Change PIN");
        System.out.println("8. Transfer Money");
        System.out.println("0. Exit");
    }

    private static void runMenu() {
        int choice;
        do {
            menu();
            choice = readInt("Enter Your Choice");
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    accountTier();
                    break;
                case 5:
                    savingsProjection();
                    break;
                case 6:
                    receiptSummary();
                    break;
                case 7:
                    changePin();
                    break;
                case 8:
                    transfer();
                    break;
                case 0:
                    System.out.println("GoodBye!");
                    break;
                default:
                    System.out.println("Invalid Choice. Please Try Again.");
            }
        } while (choice != 0);
    }

    // Operations
    private static void checkBalance() {
        System.out.printf("Balance: %.2f%n", balance);
    }

    private static void deposit() {
        double amount = readDouble("Enter Deposit Amount");
        if (amount <= 0) {
            System.out.println("Error: Deposit Must Be Greater Than 0.");
        } else if (amount > MaxDeposit) {
            System.out.printf("Error: Deposit Cannot Be More Than %.2f.%n", MaxDeposit);
        } else {
            balance += amount;
            depositCount++;
            depositTotal += amount;
            if (amount > highestDeposit) {
                highestDeposit = amount;
            }
            System.out.printf("Deposit Successful. Balance: %.2f%n", balance);
        }
    }

    private static double getFee(double amount) {
        if (amount <= 500) {
            return 2.00;
        }
        return 5.00;
    }

    private static boolean takeMoney(double amount) {
        double fee = getFee(amount);

        if (amount <= 0) {
            System.out.println("Error: Amount Must Be Greater Than 0.");
        } else if (amount % 10 != 0) {
            System.out.println("Error: Amount Must Be a Multiple of 10.");
        } else if (amount + fee > balance) {
            System.out.println("Error: Insufficient Balance to Cover the Amount and the Fee.");
        } else if (withdrawalTotal + amount > MaxSessionWithdrawal) {
            System.out.printf("Error: Session Withdrawal Limit of %.2f Exceeded.%n",
                    MaxSessionWithdrawal);
        } else {
            System.out.printf("Fee: %.2f%n", fee);
            balance -= amount + fee;
            withdrawalCount++;
            withdrawalTotal += amount;
            if (amount > highestWithdrawal) {
                highestWithdrawal = amount;
            }
            return true;
        }
        return false;
    }

    private static void withdraw() {
        double amount = readDouble("Enter Withdrawal Amount");
        if (takeMoney(amount)) {
            System.out.printf("Withdrawal Successful. Balance: %.2f%n", balance);
        }
    }

    private static String getTierName() {
        if (balance < 1000) {
            return "Bronze";
        } else if (balance < 5000) {
            return "Silver";
        } else if (balance < 20000) {
            return "Gold";
        } else {
            return "Platinum";
        }
    }

    private static int getInterestPercent() {
        if (balance < 1000) {
            return 1;
        } else if (balance < 5000) {
            return 2;
        } else if (balance < 20000) {
            return 3;
        } else {
            return 4;
        }
    }

    private static void accountTier() {
        System.out.println("Tier: " + getTierName() + ", Interest Rate: "
                + getInterestPercent() + "%");
    }

    private static void savingsProjection() {
        int years = readInt("Enter Number of Years");
        if (years < 1 || years > 10) {
            System.out.println("Error: Years Must Be From 1 to 10.");
            return;
        }
        double rate = getInterestPercent() / 100.0;
        double projected = balance;
        for (int year = 1; year <= years; year++) {
            projected *= 1 + rate;
            System.out.printf("Year %d: %.2f%n", year, projected);
        }
    }

    private static void receiptSummary() {
        System.out.printf("Deposits: %d, Total: %.2f%n", depositCount, depositTotal);
        System.out.printf("Withdrawals: %d, Total: %.2f%n", withdrawalCount, withdrawalTotal);
        System.out.printf("Balance: %.2f%n", balance);
        System.out.printf("Highest Deposit: %.2f%n", highestDeposit);
        System.out.printf("Highest Withdrawal: %.2f%n", highestWithdrawal);
    }

    private static void changePin() {
        int oldPin = readInt("Enter Old PIN");
        if (oldPin != pin) {
            System.out.println("Error: Old PIN is Incorrect.");
            return;
        }
        int newPin = readInt("Enter New PIN (4 Digits)");
        if (newPin < 1000 || newPin > 9999) {
            System.out.println("Error: PIN Must Be Exactly 4 Digits (1000 to 9999).");
            return;
        }
        int confirmPin = readInt("Confirm New PIN");
        if (confirmPin != newPin) {
            System.out.println("Error: PINs Do Not Match. PIN Was Not Changed.");
        } else {
            pin = newPin;
            System.out.println("PIN Changed Successfully.");
        }
    }

    // Transfer
    private static void transfer() {
        int accountNumber = readInt("Enter 6-Digit Account Number");
        if (accountNumber < 100000 || accountNumber > 999999) {
            System.out.println("Error: Account Number Must Be Exactly 6 Digits.");
            return;
        }
        double amount = readDouble("Enter Transfer Amount");
        if (takeMoney(amount)) {
            System.out.printf("Transfer to Account %d Successful. Balance: %.2f%n",
                    accountNumber, balance);
        }
    }
}
