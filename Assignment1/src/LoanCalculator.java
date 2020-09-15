/**
 * This program calculates the monthly payments
 * on a loan base on the principle amount and interest
 */
import java.util.Scanner;
public class LoanCalculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Display the program header
		System.out.println("\tLoan Calculator");
		System.out.println("-----------------------------");
		
		// Prompt user for the loan amount
		System.out.print("Enter the loan amount: ");
		double loanAmount = input.nextDouble();
		
		// Test that input value is positive, re-prompt if negative
		while(loanAmount < 0) {
			System.out.print("Error, loan amount must be greater than 0. \nPlease re-enter: ");
			loanAmount = input.nextDouble();
		}
		// Prompt user for interest rate
		System.out.print("Enter the interest rate: ");
		double interestRate = input.nextDouble();
		
		// Test that input value is positive, re-prompt if negative
		while(interestRate < 0) {
			System.out.print("Error, interest rate must be greater than 0. \nPlease re-enter: ");
			interestRate = input.nextDouble();
		}
		interestRate = interestRate * .01; // Convert interest rate to decimal value for multiplication
		// Prompt user for the number of payments
		System.out.print("Enter the number of payments: ");
		int numberOfPayments = input.nextInt();
		// Test that input value is positive, re-prompt if negative
		while(numberOfPayments < 0) {
			System.out.print("Error, number of payments must be greater than 0. \nPlease re-enter: ");
			numberOfPayments = input.nextInt();
		}
		// Calculate the monthly payment
		double monthlyPayment = loanAmount * ((interestRate/12.0) / (1.0 - (Math.pow(1.0 + interestRate / 12.0, -numberOfPayments))));
		// Display the monthly payment
		System.out.printf("The monthly payment will be $%.2f", monthlyPayment);
		input.close();
	}

}
