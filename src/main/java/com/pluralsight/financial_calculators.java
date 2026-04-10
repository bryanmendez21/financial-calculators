package com.pluralsight;

import java.util.Scanner;

public class financial_calculators {
    public static void main(String[] args) {
        // Prompts
        Scanner data_catcher = new Scanner(System.in);
        System.out.printf("(1): Mortgage Calculator \n(2): Compound Interest \n(3): Ordinary Annuity \nWhich calculator would you like to use: ", 1, 2, 3);
        int pick_calculator = data_catcher.nextInt();

        // calling method based on calculator picked
        if (pick_calculator == 1){
            // asking for loan variables
            System.out.print("What is the principle/loan amount: ");
            int principle = data_catcher.nextInt();
            System.out.print("What is the interest rate: ");
            float interest_rate = data_catcher.nextFloat();
            System.out.print("How long is the loan in months: ");
            int loan_length = data_catcher.nextInt();
            // Outcome
            //System.out.printf("Your monthly payment is: $%.2f",  );

        }
        else if (pick_calculator == 2){

        }
        else if (pick_calculator == 3){

        }
        else {
            System.out.println("Pick from 1, 2 or 3");
        }

    }

    // Mortgage calculator
    public static float morgage(int principle, float interest_rate, int loan_length) {
        return  ;


    }
}
