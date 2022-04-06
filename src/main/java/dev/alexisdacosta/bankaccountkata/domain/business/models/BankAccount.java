package dev.alexisdacosta.bankaccountkata.domain.business.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BankAccount {
    private UUID id;
    private Integer balance;
    private List<Transaction> transactions = new ArrayList<>();

    public BankAccount(UUID id, Integer balance) {
        this.id = id;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public Integer getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void withdraw(Integer amount) {
        if (amount > balance) throw new IllegalArgumentException("Not enough money");
        if (amount < 0) throw new IllegalArgumentException("Amount must be positive");

        transactions.add(new Transaction(LocalDate.now(), amount, "withdraw", balance, balance - amount));
        this.balance -= amount;
    }

    public void deposit(Integer amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount must be positive");

        transactions.add(new Transaction(LocalDate.now(), amount, "deposit", balance, balance + amount));
        this.balance += amount;
    }

    @Override
    public String toString() {
        return  "=============================================\n" + 
                " ACCOUNT NUMBER : " + id + "\n" +
                " BALANCE : " + balance + "\n" + 
                " =============== TRANSACTION ================\n" + 
                transactions + "\n" + 
                "=============================================";
    }

}
