package com.frank;

import com.frank.types.Bowler;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ApplicationProgram {

    private static List<Bowler> theBowlers = new ArrayList();
    public static void main(String[] args) throws FileNotFoundException {
       System.out.println("Start of application program");

        // Since both System.out and printStackTrace() are assigned to the screen,
        // using them both to display messages causes confusing output (prints 2 files to same screen).
        // You may assign the output of either or both to a file using:
        // -- printStackTrace() may be reassigned to a file using the System.setErr() method
        // -- System.out (standard out) may be reassigned to a file using the System.setOut() method
        // To use System.setErr()
        // 1. Define a PrintStream object to the file you want to hold the output
        // 2. Assign the PrintStream object to standard error file using System.setErr()

        PrintStream errorLog = new PrintStream("myErrors.log"); // Define a file to hold standard error msgs
        System.setErr(errorLog); // Send standard error messages to the file

       LoadBowlers();  // call method to instantiate some test data in ArrayList

       System.out.println("-".repeat(80) + "\n--- List of Bowlers ---");

       for (Bowler aBowler : theBowlers) {
           ShowBowler(aBowler);
       }
       System.out.println("-".repeat(80));
       String response = "";
       boolean shouldLoop = true;
       Scanner theKeyBoard = new Scanner(System.in);
       while(shouldLoop) {
            System.out.println("\nEnter the number of the Bowler you would like displayed");
            System.out.printf("Valid numbers are 1 thru %d\nYour choice: ", theBowlers.size());
            response = theKeyBoard.nextLine();
            if (response.toLowerCase().charAt(0) == 'e') {
                shouldLoop = false;
                continue;
            }
           try {    // Add try block due to possibilities of IndexOutOfBoundsException - showBowler()
                    // or NumberFormatException - Integer.parseInt()
               int bowlerNumber = Integer.parseInt(response);

               ShowBowler(theBowlers.get(bowlerNumber - 1));

            } catch (IndexOutOfBoundsException exceptionObject) {
                System.out.println("Please select a bowler number in the range given.");
                exceptionObject.printStackTrace();

            } catch (NumberFormatException exceptionObject) {
               System.out.println("Non-numeric value entered for bowler number.");
               exceptionObject.printStackTrace();
           }
        } // End of for-loop

        System.out.println("-".repeat(80));

        System.out.println("End of application program");
        return;
    } // End of main

    // Helper methods used by main() in its processing
    /**
     * Display data for a Bowler
     * This method is static because main() which calls it is static
     */
    private static void ShowBowler(Bowler aBowler) {
        System.out.print(aBowler);
        try {
        System.out.printf(" average: %.2f \n", aBowler.getAverage());
        }
        // Every time an exception occurs an exception object is created and passed to the catch block
        // The exception object contains information about the exception
        // name-of-exception    name-for-exception-object
        catch(NullPointerException exceptionObject) {
            // System.out displays to the standard output stream file
            System.out.println("\n\n ----Uh-oh! Null pointer exception occurred! ----\n");
            // printStackTrace() displays to the standard error file - asynchronously - you don't wait for it to finish
            // You can direct the standard error stream to a different file rather than the screen (see top of this code)
            exceptionObject.printStackTrace(); // Display the series of method calls that lead to the exception
            System.out.println("The system says the problem is: " + exceptionObject.getMessage() + "\n");
        }
    }
    /**
     * Add test data to test program data store
     * This method is static because main() which calls it is static
     */
    private static void LoadBowlers() {
        theBowlers.add(new Bowler("Fred Flintstone", new int[] {230, 260, 275}));
        theBowlers.add(new Bowler("Barney Rubble",   new int[] {120, 140, 190}));
        theBowlers.add(new Bowler("The Dude",        new int[] {260, 270, 290}));
        theBowlers.add(new Bowler());
        theBowlers.add(new Bowler("Roy Munson",      new int[] {225, 285, 252}));
    }
}
