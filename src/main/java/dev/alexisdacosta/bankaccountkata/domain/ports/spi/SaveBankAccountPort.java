package dev.alexisdacosta.bankaccountkata.domain.ports.spi;

import dev.alexisdacosta.bankaccountkata.domain.business.models.BankAccount;

public interface SaveBankAccountPort {
    public void save(BankAccount bankAccount);
}
