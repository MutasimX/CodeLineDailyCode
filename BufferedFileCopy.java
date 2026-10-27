package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileCopy {

    public static void main(String[] args) {

        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File Copied From " + sourceFile + " to " + destinationFile);

        } catch (FileNotFoundException e) {
            System.out.println("The File " + sourceFile + "' Was Not Found.");

        } catch (IOException e) {
            System.out.println("Something Went Wrong . " + e.getMessage());
        }
    }
}