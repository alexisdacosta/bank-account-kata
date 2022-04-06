package dev.alexisdacosta.bankaccountkata.domain.business.models;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class BankAccountTest {
    @Test
    void testDeposit() {
        BankAccount bankAccount = new BankAccount(UUID.randomUUID(), 1000);
        bankAccount.deposit(100);
        assert bankAccount.getBalance() == 1100;
        assert bankAccount.getTransactions().size() == 1;
        assert bankAccount.getTransactions().get(0).getAmount() == 100;
        assert bankAccount.getTransactions().get(0).getDescription().equals("deposit");
        assert bankAccount.getTransactions().get(0).getPreBalance() == 1000;
        assert bankAccount.getTransactions().get(0).getPostBalance() == 1100;
    }

    @Test
    void testGetBalance() {
        BankAccount bankAccount = new BankAccount(UUID.randomUUID(), 1000);
        assert bankAccount.getBalance() == 1000;
    }

    @Test
    void testGetTransactions() {
        BankAccount bankAccount = new BankAccount(UUID.randomUUID(), 1000);
        bankAccount.deposit(100);
        assert bankAccount.getTransactions().size() == 1;
        assert bankAccount.getTransactions().get(0).getAmount() == 100;
        assert bankAccount.getTransactions().get(0).getDescription().equals("deposit");
        assert bankAccount.getTransactions().get(0).getPreBalance() == 1000;
        assert bankAccount.getTransactions().get(0).getPostBalance() == 1100;
    }

    @Test
    void testSetBalance() {
        BankAccount bankAccount = new BankAccount(UUID.randomUUID(), 1000);
        bankAccount.setBalance(2000);
        assert bankAccount.getBalance() == 2000;
    }

    @Test
    void testWithdraw() {
        BankAccount bankAccount = new BankAccount(UUID.randomUUID(), 1000);
        bankAccount.withdraw(100);
        assert bankAccount.getBalance() == 900;
        assert bankAccount.getTransactions().size() == 1;
        assert bankAccount.getTransactions().get(0).getAmount() == 100;
        assert bankAccount.getTransactions().get(0).getDescription().equals("withdraw");
        assert bankAccount.getTransactions().get(0).getPreBalance() == 1000;
        assert bankAccount.getTransactions().get(0).getPostBalance() == 900;
    }
}
