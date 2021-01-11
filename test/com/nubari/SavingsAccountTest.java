package com.nubari;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    SavingsAccount savingsAccount;
    @BeforeEach
    void setUp() {
        savingsAccount = new SavingsAccount();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSavingsBalance() {
        assertEquals(0.0, savingsAccount.getSavingsBalance());
    }

    @Test
    void setSavingsBalance() {
        savingsAccount.setSavingsBalance(100.00);
        assertEquals(100.00, savingsAccount.getSavingsBalance());
    }

    @Test
    void calculateMonthlyInterest() {
        SavingsAccount.ANNUALINTERESTRATE = 12;
    }

    @Test
    void addMonthlyInterest() {
    }

    @Test
    void modifyInterestRate() {
        SavingsAccount.modifyInterestRate(100.00);
        assertEquals(100.00, SavingsAccount.ANNUALINTERESTRATE);
    }
}