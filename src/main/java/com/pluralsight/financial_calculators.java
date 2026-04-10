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
            double principle = data_catcher.nextInt();
            System.out.print("What is the interest rate: ");
            double interest_rate = data_catcher.nextDouble();
            System.out.print("How long is the loan in years: ");
            int loan_length = data_catcher.nextInt();

            double total_months = 12 * loan_length;
            // returning these values to the method
            double monthly_payment = morgage(principle,interest_rate,loan_length, total_months);
            // Total interest logic
            double total_interest = (monthly_payment * total_months) - principle;
            // Outcome
            System.out.printf("Your monthly payment is: $%.2f \nYour total interest is: $%.2f" ,monthly_payment, total_interest);

        }
       /* else if (pick_calculator == 2){

        }
        else if (pick_calculator == 3){

        }
        else {
            System.out.println("Pick from 1, 2 or 3");
        }*/

    }

    // Mortgage calculator
    public static double morgage(double principle, double interest_rate, int loan_length, double total_months) {
        // Monthly interest rate
        double monthly_rate = (interest_rate/100) / 12; // interest divided by months in a year
        double length_of_month_rate = Math.pow(1 + monthly_rate,total_months); //
        // Formula M = p * ( i * ( 1 + i)^n / ( (1 + i)^n ) -1)
        return principle * ( monthly_rate * (length_of_month_rate)/ ((length_of_month_rate) -1) );


    }
}
