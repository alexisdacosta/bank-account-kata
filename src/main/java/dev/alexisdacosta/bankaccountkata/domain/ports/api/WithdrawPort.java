package dev.alexisdacosta.bankaccountkata.domain.ports.api;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public interface WithdrawPort {
    public void withdraw(UUID id, Integer amount);
}
