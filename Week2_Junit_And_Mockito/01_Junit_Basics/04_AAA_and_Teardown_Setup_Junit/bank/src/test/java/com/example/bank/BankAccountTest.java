package com.example.bank;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp(){
        account = new BankAccount(5000);
    }

    @AfterEach
    public void tearDown(){
        account = null;
    }

    @Test
    public void testDeposit(){
        account.deposit(500);
        assertEquals(5500, account.getBalance());
    }

    @Test
    public void testWithdraw(){
        account.withdraw(2000);
        assertEquals(3000, account.getBalance());
    }
}
