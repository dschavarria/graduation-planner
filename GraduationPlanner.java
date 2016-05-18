/**
Graduation Planner: a program that helps you calculate cost and time remaining in your degree
program by entering the individual remaining CUs for each of your classes. By Daniel S. Chavarria
March 29, 2015
 */

import java.util.Scanner;

public class GraduationPlanner
{
    //main method
    public static void main(String[] args)
    {
        // Introduce the program
        System.out.println();
		System.out.println("Welcome to Graduation Planner!");
        System.out.println("******************************");
        System.out.println("This program will take your remaining courses into account and");
        System.out.println("calculate the estimated time and cost to complete based on how many");
        System.out.println("units you plan to complete per term.");
        System.out.println();
        pressEnter();
        System.out.println();

        // Display Instructions
        System.out.println("Next you will enter the CUs remaining for each course, one at a time.");
        System.out.println();
        System.out.println("For example, if you have two courses left and one has 4 CUs and the ");
        System.out.println("other has 3 CUs you would enter:");
        System.out.println("4");
        System.out.println("Then:");
        System.out.println("3");
		System.out.println();
        // Create new array that holds CUs
        int[] compsArray = new int[40];

        // Allow for keyboard input
        Scanner input = new Scanner(System.in);

        // String for keyboard input
        String stringInput;

        // Show prompt for CUs, use only integers, cannot be negative
        System.out.println("Please enter your CUs now. They cannot be negative numbers.");
        System.out.println("When you are finished enter \"q\":");

        // Input CUs until "q" is entered
        boolean isNotQ = true;

        for (int i = 0; isNotQ; i++) {
            stringInput = input.nextLine();

            //check if input is a digit or a letter
            if (stringInput.matches("([a-z]+)")) {
                if (stringInput.matches("q")) {
                    isNotQ = false;
                } else {
                    System.out.println("Invalid entry! Please enter an integer greater than zero, or enter the letter q to quit:");
                    i--;
                    isNotQ = true;
                }
            } else if (stringInput.matches("(\\d+)")){
                //parse string to integer
                int parseInt = Integer.parseInt(stringInput);
                if (parseInt >= 0) {
                    compsArray[i] = parseInt;
                    isNotQ = true;
                } else if (parseInt < 0) {
                    System.out.println("Invalid entry! Please enter an integer greater than zero, or enter the letter q to quit:");
                    i--;
                    isNotQ = true;
                }
            }else{
                System.out.println("Invalid entry! Please enter an integer greater than zero, or enter the letter q to quit:");
                i--;
                isNotQ = true;
            }
        }
		System.out.println();
        System.out.println("You're finished!");
        System.out.println();
        System.out.println("Next you will input the number CUs per term that you would like to complete.");
        System.out.print("Please enter a minimum of 12 CUs per term.");
		System.out.println();
        pressEnter();
        System.out.println();

        //Prompt for estimated CUs per term, minimum of 12 per term
        System.out.println("Please enter the number of CUs per term you would like to complete:");


        //Create CUs per term variable
        int cusPerTerm = 0;

        //Create cusPerTerm scanner
        Scanner cusPerTermInput = new Scanner(System.in);

        //Create variable to break while
        Boolean isNotValid = true;

        // while loop to insure correct input
        while(isNotValid) {
            stringInput = cusPerTermInput.nextLine();

            //check if input is a digit or a letter
            if (stringInput.matches("([a-z]+)")) {
                System.out.println("Invalid entry! Please enter an integer greater than or equal to 12:");
                isNotValid = true;
            } else if (stringInput.matches("(\\d+)")){
                //parse string to and integer.
                int parseInt = Integer.parseInt(stringInput);
                if (parseInt >= 12) {
                    cusPerTerm = parseInt;
                    isNotValid = false;

                } else if (parseInt < 12) {
                    System.out.println("Invalid entry! Please enter an integer greater than or equal to 12:");
                    isNotValid = true;
                }
            }else{
                System.out.println("Invalid entry! Please enter an integer greater than or equal to 12:");
                isNotValid = true;
            }
        }
        // View input
        System.out.println();
        System.out.println("Great!");
        System.out.println();
        System.out.println("Next you will see your estimated terms to complete");
        System.out.println("and your estimated cost to complete.");
        System.out.println();
        pressEnter();
        System.out.println();

        // Determine total number of CUs
        int totalCus = 0;

        for (int i = 0, compsArrayLength = compsArray.length; i < compsArrayLength; i++) {
            int aCompsArray = compsArray[i];
            totalCus = totalCus + aCompsArray;
        }

        // Determine total number of terms
        int totalTerms;

        // Round to a complete term
        if (totalCus % cusPerTerm == 0) {
            totalTerms = totalCus / cusPerTerm;
        } else {
            totalTerms = (totalCus / cusPerTerm) + 1;
        }

        // Determine total cost
        final int COST_PER_TERM = 2890;
        int totalCost = totalTerms * COST_PER_TERM;

        // Determine total months left
        final int MONTHS_PER_TERM = 6;
        int monthsLeft = totalTerms * MONTHS_PER_TERM;

        // Output results
        System.out.println("Your calculations are complete!");
        System.out.println();
        System.out.println("You have a total of "+ totalCus +" CUs left in your degree plan.");
        System.out.println("It will take you " + totalTerms + " terms to complete those CUs based on");
        System.out.println("completing "+ cusPerTerm +" CUs per term.");
        System.out.println();
        System.out.print("The cost of tuition is $");
        System.out.printf("%,d", COST_PER_TERM);
        System.out.println(" per semester,");
        System.out.print("so your cost to complete is $");
        System.out.printf("%,d", totalCost);
        System.out.println(".");
        System.out.println();
        System.out.println("It will take you " + monthsLeft + " months to complete the "+ totalTerms +" remaining terms." );
        System.out.println();
        pressEnter();
        System.out.println();

        //Display thank you message
        System.out.println("Thank you for using Graduation Planner, have an awesome day!");
    }
    // Waits for enter to be pressed
    public static void pressEnter() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Press enter to continue....... ");
        keyboard.nextLine();
		System.out.print("------------------------------------------------------------");
    }
}