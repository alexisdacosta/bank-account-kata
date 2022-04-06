package dev.alexisdacosta.bankaccountkata.domain.ports.api;

import java.util.UUID;

import dev.alexisdacosta.bankaccountkata.domain.business.models.BankAccount;

public interface StatusPort {
    public BankAccount getStatus(UUID id);
}
