package dev.alexisdacosta.bankaccountkata.infrastructure;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import dev.alexisdacosta.bankaccountkata.domain.business.models.BankAccount;
import dev.alexisdacosta.bankaccountkata.domain.ports.spi.LoadBankAccountPort;
import dev.alexisdacosta.bankaccountkata.domain.ports.spi.SaveBankAccountPort;

@Component
public class BankAccountRepository extends BankAccountMockDB implements SaveBankAccountPort, LoadBankAccountPort {

    @Override
    public void save(BankAccount bankAccount) {
        // Find if the bank account already exists
        Optional<BankAccount> bankAccountOptional = bankAccounts.stream()
                                                                .filter(b -> b.getId().equals(bankAccount.getId()))
                                                                .findFirst();

        if (bankAccountOptional.isPresent()) {
            // If it does, we update it
            bankAccounts.remove(bankAccountOptional.get());
            bankAccounts.add(bankAccount);
        } else {
            // If it doesn't, we add it
            bankAccounts.add(bankAccount);
        }
        
    }

    @Override
    public Optional<BankAccount> load(UUID id) {
        Optional<BankAccount> account = bankAccounts.stream()
                                                    .filter(bankAccount -> bankAccount.getId().equals(id))
                                                    .findFirst();

        return account;
    }

}
    
