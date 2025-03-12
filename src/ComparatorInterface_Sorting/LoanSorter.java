package ComparatorInterface_Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LoanSorter {
    public static void main(String[] args) {
        // Creating an array of Loan objects
        Loan[] list = {
                new Loan(5.5, 10, 100),
                new Loan(5, 10, 1000),
                new Loan(4.5, 15, 500),
                new Loan(5, 10, 500),
                new Loan(3.5, 30, 100),
                new Loan(4.0, 20, 500)
        };

        // Print original list before sorting
        System.out.println("Original Loan List:");
        printLoanList(list);

        // Sorting loans by loan amount first, then by annual interest rate
        Arrays.sort(list, Comparator.comparing(Loan::getLoanAmount)
                .thenComparing(Loan::getAnnualInterestRate));

        // Print sorted list after sorting
        System.out.println("\nSorted Loan List:");
        printLoanList(list);
    }

    // Method to print loan list
    private static void printLoanList(Loan[] loans) {
        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }
}

// Loan class with getters and toString method
class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    @Override
    public String toString() {
        return String.format("Loan[Amount=%.2f, Interest=%.2f%%, Years=%d]",
                loanAmount, annualInterestRate, numberOfYears);
    }
}
