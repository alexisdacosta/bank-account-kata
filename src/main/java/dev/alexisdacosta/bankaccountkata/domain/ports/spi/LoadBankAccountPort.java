package dev.alexisdacosta.bankaccountkata.domain.ports.spi;

import java.util.Optional;
import java.util.UUID;

import dev.alexisdacosta.bankaccountkata.domain.business.models.BankAccount;

public interface LoadBankAccountPort {
    public Optional<BankAccount> load(UUID id);  
}
