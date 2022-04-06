package dev.alexisdacosta.bankaccountkata.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dev.alexisdacosta.bankaccountkata.domain.business.models.BankAccount;

public abstract class BankAccountMockDB {
    public List<BankAccount> bankAccounts = new ArrayList<>(){
        {
            add(new BankAccount(UUID.fromString("00000000-0000-0000-0000-000000000001"), 1000));
            add(new BankAccount(UUID.fromString("00000000-0000-0000-0000-000000000002"), 2000));
            add(new BankAccount(UUID.fromString("00000000-0000-0000-0000-000000000003"), 3000));
        }
    };
}
