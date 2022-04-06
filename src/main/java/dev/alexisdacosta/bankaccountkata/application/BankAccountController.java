package dev.alexisdacosta.bankaccountkata.application;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.alexisdacosta.bankaccountkata.domain.business.models.BankAccount;
import dev.alexisdacosta.bankaccountkata.domain.ports.api.DepositPort;
import dev.alexisdacosta.bankaccountkata.domain.ports.api.StatusPort;
import dev.alexisdacosta.bankaccountkata.domain.ports.api.WithdrawPort;

@RestController
@RequestMapping("/account")
public class BankAccountController {
    @Autowired
    private DepositPort depositPort;
    @Autowired 
    private WithdrawPort withdrawPort;
    @Autowired
    private StatusPort statusPort;

    @PostMapping(value = "/{id}/deposit/{amount}")
    public void deposit(@PathVariable UUID id, @PathVariable Integer amount) {
        depositPort.deposit(id, amount);
        
    }

    @PostMapping(value = "/{id}/withdraw/{amount}")
    public void withdraw(@PathVariable UUID id, @PathVariable Integer amount) {
        withdrawPort.withdraw(id, amount);
    }

    @GetMapping(value = "/{id}/status")
    public BankAccount status(@PathVariable UUID id) {
        BankAccount res = statusPort.getStatus(id);
        return res;
    }
}
