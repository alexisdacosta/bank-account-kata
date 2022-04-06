package dev.alexisdacosta.bankaccountkata.domain.business.models;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private Integer amount;
    private String description;
    private Integer preBalance;
    private Integer postBalance;

    public Transaction(LocalDate date, Integer amount, String description, Integer preBalance, Integer postBalance) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.preBalance = preBalance;
        this.postBalance = postBalance;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public Integer getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPreBalance() {
        return preBalance;
    }

    public Integer getPostBalance() {
        return postBalance;
    }

    @Override
    public String toString() {
        return " - date : " + date + "\n" +
                " - amount : " + amount + "\n" +
                " - description : " + description + "\n" +
                " - preBalance : " + preBalance + "\n" +
                " - postBalance : " + postBalance + "\n";
    }
}
