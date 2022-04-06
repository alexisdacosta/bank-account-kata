package dev.alexisdacosta.bankaccountkata.domain.ports.api;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public interface DepositPort {
    public void deposit(UUID id, Integer amount);
}
