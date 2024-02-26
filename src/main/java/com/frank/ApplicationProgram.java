package com.frank;

import com.frank.types.Bowler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ApplicationProgram {

    private static List<Bowler> theBowlers = new ArrayList();
    public static void main(String[] args) {
       System.out.println("Start of application program");

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
            int bowlerNumber = Integer.parseInt(response);
            ShowBowler(theBowlers.get(bowlerNumber-1));
        }

        System.out.println("-".repeat(80));

        System.out.println("End of application program");
        return;
    }
    /**
     * Display data for a Bowler
     */
    private static void ShowBowler(Bowler aBowler) {
        System.out.print(aBowler);
        System.out.printf(" average: %.2f \n", aBowler.getAverage());
    }
    /**
     * Add test data to test program data store
     */
    private static void LoadBowlers() {
        theBowlers.add(new Bowler("Fred Flintstone", new int[] {230, 260, 275}));
        theBowlers.add(new Bowler("Barney Rubble",   new int[] {120, 140, 190}));
        theBowlers.add(new Bowler("The Dude",        new int[] {260, 270, 290}));
        theBowlers.add(new Bowler());
        theBowlers.add(new Bowler("Roy Munson",      new int[] {225, 285, 252}));
    }
}
