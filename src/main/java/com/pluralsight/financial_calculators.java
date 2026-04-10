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
            // Asking for loan variables
            System.out.print("What is the principle/loan amount: ");
            double principle = data_catcher.nextInt();
            System.out.print("What is the interest rate: ");
            double interest_rate = data_catcher.nextDouble();
            System.out.print("How long is the loan in years: ");
            int loan_length = data_catcher.nextInt();

            double total_months = 12 * loan_length;
            // returning these values to mortgage method
            double monthly_payment = mortgage(principle,interest_rate,loan_length, total_months);
            // Total interest logic
            double total_interest = (monthly_payment * total_months) - principle;
            // Outcome
            System.out.printf("Your monthly payment is: $%.2f \nYour total interest is: $%.2f" ,monthly_payment, total_interest);

        }
       else if (pick_calculator == 2){
           // Asking for compound values
            System.out.print("What is the principle/initial deposit amount: ");
            double principle = data_catcher.nextInt();
            System.out.print("What is the interest rate: ");
            double interest_rate = data_catcher.nextDouble();
            System.out.print("How long will deposit earn interest in years: ");
            int earn_length = data_catcher.nextInt();

            // Returning these values to fv method
            double ending_balance = fv(principle,interest_rate,earn_length);
            // Earned interest logic
            double earned_interest = ending_balance - principle;
            //outcome
            System.out.printf("Your ending balance is: $%.2f \nYou would have earned: $%.2f in interest" ,ending_balance,earned_interest);
        }
        else if (pick_calculator == 3){
            // Asking for annuity values
            System.out.print("What is the monthly payout: ");
            double monthly_payout = data_catcher.nextInt();
            System.out.print("What is the interest rate: ");
            double interest_rate = data_catcher.nextDouble();
            System.out.print("How long will it take to pay in years: ");
            int pay_length = data_catcher.nextInt();

            // Returning to pv method
            double total_invested = pv(monthly_payout,interest_rate,pay_length);
            // Outcome
            System.out.printf("You would need to invest: $%.2f today",total_invested);
        }
        else {
            System.out.println("Pick from 1, 2 or 3");
        }

    }

    // Mortgage calculator
    public static double mortgage(double principle, double interest_rate, int loan_length, double total_months) {
        // Monthly interest rate
        double monthly_rate = (interest_rate/100) / 12; // interest divided by months in a year
        double length_of_month_rate = Math.pow(1 + monthly_rate,total_months); //
        // Formula M = p * ( i * ( 1 + i)^n / ( (1 + i)^n ) -1)
        return principle * ( monthly_rate * (length_of_month_rate)/ ((length_of_month_rate) -1) );
    }

    // Compound Interest Calculator
    public static double fv(double principle, double interest_rate, int earn_length){

        //variables
        double annual_interest = 1.75 / 100;

        return principle *(Math.pow(1+(annual_interest/365), (365 * earn_length)));
    }

    // Ordinary annuity
    public static double pv(double monthly_payout,double interest_rate, int pay_length){

        // Variables
        double annual_interest = interest_rate/ 100;
        double monthly_interest = annual_interest/12;
        int pay_length_months = pay_length * 12;
        double interest_per_month = Math.pow(1 + monthly_interest,pay_length_months);

        //formula p = mpo *(1-(1/(1+r)^n)/r)
        return monthly_payout *((1-(1 / interest_per_month))/ monthly_interest);
    }
}
