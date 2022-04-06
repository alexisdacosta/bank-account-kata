package dev.alexisdacosta.bankaccountkata.domain.business.services;

import java.util.UUID;

import dev.alexisdacosta.bankaccountkata.domain.business.models.BankAccount;
import dev.alexisdacosta.bankaccountkata.domain.ports.api.DepositPort;
import dev.alexisdacosta.bankaccountkata.domain.ports.api.StatusPort;
import dev.alexisdacosta.bankaccountkata.domain.ports.api.WithdrawPort;
import dev.alexisdacosta.bankaccountkata.domain.ports.spi.LoadBankAccountPort;
import dev.alexisdacosta.bankaccountkata.domain.ports.spi.SaveBankAccountPort;

public class BankAccountService implements WithdrawPort, DepositPort, StatusPort {

    private LoadBankAccountPort loadBankAccountPort;
    private SaveBankAccountPort saveBankAccountPort;

    public BankAccountService(LoadBankAccountPort loadBankAccountPort, SaveBankAccountPort saveBankAccountPort) {
        this.loadBankAccountPort = loadBankAccountPort;
        this.saveBankAccountPort = saveBankAccountPort;
    }

    @Override
    public void withdraw(UUID id, Integer amount) {
        // We need to load the bank account first
        BankAccount bankAccount = loadBankAccountPort.load(id)
                                                     .orElseThrow(() -> new IllegalArgumentException("Bank account not found"));

        // Then we can withdraw with the amount we want
        bankAccount.withdraw(amount);

        // And finally we save the bank account
        saveBankAccountPort.save(bankAccount);
    }


    @Override
    public void deposit(UUID id, Integer amount) {
        BankAccount bankAccount = loadBankAccountPort.load(id)
                                                     .orElseThrow(() -> new IllegalArgumentException("Bank account not found"));

        // Then we can withdraw with the amount we want
        bankAccount.deposit(amount);

        // And finally we save the bank account
        saveBankAccountPort.save(bankAccount);
    }

    @Override
    public BankAccount getStatus(UUID id) {
        BankAccount bankAccount = loadBankAccountPort.load(id)
                                                     .orElseThrow(() -> new IllegalArgumentException("Bank account not found"));

        return bankAccount;
    }
}
