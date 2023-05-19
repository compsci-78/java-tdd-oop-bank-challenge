package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SavingAccountTest {
    @Test
    public void testDeposit(){
        // the test should increase the balance and add a transaction of type CREDIT
        SavingAccount account = new SavingAccount(0);
        account.deposit(100.00, LocalDate.of(2023,5,19));

        Assertions.assertEquals(100.00,account.getBalance());

        Assertions.assertEquals(1,account.getTransactions().size());
        Assertions.assertEquals(TransactionType.CREDIT,account.getTransactions().get(0).getType());
    }
    @Test
    public void testWithdraw(){
        // the test should decrease the balance and add a transaction of type DEBIT
        SavingAccount account = new SavingAccount(0);
        account.deposit(100.00, LocalDate.of(2023,5,19));
        account.deposit(100.00, LocalDate.of(2023,5,19));
        account.deposit(100.00, LocalDate.of(2023,5,19));

        Assertions.assertEquals(300.00,account.getBalance());
        account.withdraw(100.00, LocalDate.of(2023,5,19));

        Assertions.assertEquals(200.00,account.getBalance());

        Assertions.assertEquals(4,account.getTransactions().size());
        Assertions.assertEquals(TransactionType.CREDIT,account.getTransactions().get(3).getType());
    }
}
