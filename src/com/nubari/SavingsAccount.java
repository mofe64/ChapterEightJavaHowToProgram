package com.nubari;

public class SavingsAccount {
    static double ANNUALINTERESTRATE;
    private double savingsBalance;

    public SavingsAccount() {
    }

    public SavingsAccount(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double calculateMonthlyInterest() {
        return (this.savingsBalance * ANNUALINTERESTRATE) / 12;
    }

    public void addMonthlyInterest() {
        this.savingsBalance += calculateMonthlyInterest();
    }

    public static void modifyInterestRate(double newInterestRate) {
        ANNUALINTERESTRATE = newInterestRate;
    }
}
