package com.suyash;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        // Setup: runs before each test
        account = new BankAccount("Suyash", 1000.0);
        System.out.println("Before test: Account created");
    }

    @After
    public void tearDown() {
        // Teardown: runs after each test
        account = null;
        System.out.println("After test: Account cleared");
    }

    @Test
    public void testDeposit() {
        // Arrange
        double depositAmount = 500.0;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals(1500.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        // Arrange
        double withdrawAmount = 300.0;

        // Act
        account.withdraw(withdrawAmount);

        // Assert
        assertEquals(700.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000.0);
        });
    }
}