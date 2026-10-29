package week3;

import java.io.*;

public class FeedbackPortal {

    static String[] names = new String[100];
    static int[] ratings = new int[100];
    static String[] comments = new String[100];
    static int count = 0;

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        loadFeedback();
        boolean running = true;

        while (running) {
            showMenu();
            try {
                int choice = Integer.parseInt(input.readLine().trim());

                switch (choice) {
                    case 1: addFeedback(); break;
                    case 2: showAll(); break;
                    case 3: showAverage(); break;
                    case 4: searchByRating(); break;
                    case 5: deleteFeedback(); break;
                    case 6: saveFeedback(); break;
                    case 7:
                        saveFeedback();
                        System.out.println("GoodBye");
                        running = false;
                        break;
                    default:
                        System.out.println("Please Choose a Number From 1 to 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please Type a Number, Not Letters.");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void showMenu() {
        System.out.println("\n===== CUSTOMER FEEDBACK PORTAL =====");
        System.out.println("1. Add Feedback");
        System.out.println("2. Show All Feedback");
        System.out.println("3. Show Average Rating");
        System.out.println("4. Search By Rating");
        System.out.println("5. Delete Feedback");
        System.out.println("6. Save to File");
        System.out.println("7. Save and Exit");
        System.out.print("Choose: ");
    }

    static void addFeedback() throws IOException {
        if (count >= 100) {
            System.out.println("The List is Full!");
            return;
        }

        System.out.print("Name: ");
        String name = input.readLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name Cannot Be Empty.");
            return;
        }

        int rating = 0;
        while (true) {
            System.out.print("Rating (1-5): ");
            try {
                rating = Integer.parseInt(input.readLine().trim());
                if (rating >= 1 && rating <= 5) {
                    break;
                } else {
                    System.out.println("Rating Must Be Between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please Type a Number");
            }
        }

        System.out.print("Comment: ");
        String comment = input.readLine().trim();
        if (comment.isEmpty()) {
            System.out.println("Comment Cannot Be Empty.");
            return;
        }

        // remove | so it does not break the file format
        names[count] = name.replace("|", "/");
        ratings[count] = rating;
        comments[count] = comment.replace("|", "/");
        count++;
        System.out.println("Feedback Added!");
    }

    static void showAll() {
        if (count == 0) {
            System.out.println("No Feedback Yet.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + names[i] + " | " + ratings[i]
                    + " | " + comments[i]);
        }
    }

    static void showAverage() {
        if (count == 0) {
            System.out.println("No Feedback Yet.");
            return;
        }
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += ratings[i];
        }
        double average = (double) total / count;
        System.out.printf("Average Rating: %.2f%n", average);
    }

    static void searchByRating() throws IOException {
        System.out.print("Enter Rating to Search (1-5): ");
        try {
            int search = Integer.parseInt(input.readLine().trim());
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (ratings[i] == search) {
                    System.out.println((i + 1) + ". " + names[i] + " | "
                            + ratings[i] + " | " + comments[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No Feedback with that Rating.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please Type a Number.");
        }
    }

    static void deleteFeedback() throws IOException {
        System.out.print("Enter Feedback Number to Delete: ");
        try {
            int num = Integer.parseInt(input.readLine().trim());
            if (num < 1 || num > count) {
                System.out.println("Invalid Number.");
                return;
            }
            // shift all three arrays left
            for (int i = num - 1; i < count - 1; i++) {
                names[i] = names[i + 1];
                ratings[i] = ratings[i + 1];
                comments[i] = comments[i + 1];
            }
            count--;
            System.out.println("Feedback Deleted.");
        } catch (NumberFormatException e) {
            System.out.println("Please Type a Number.");
        }
    }

    static void saveFeedback() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"))) {
            for (int i = 0; i < count; i++) {
                writer.write(names[i] + "|" + ratings[i] + "|" + comments[i]);
                writer.newLine();
            }
            System.out.println("Saved to feedback.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void loadFeedback() {
        File file = new File("feedback.txt");
        if (!file.exists()) {
            return; // first run, nothing to load
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null && count < 100) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    names[count] = parts[0];
                    ratings[count] = Integer.parseInt(parts[1]);
                    comments[count] = parts[2];
                    count++;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error Loading File: " + e.getMessage());
        }
    }
}