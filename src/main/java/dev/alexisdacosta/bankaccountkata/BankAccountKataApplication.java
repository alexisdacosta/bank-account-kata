package dev.alexisdacosta.bankaccountkata;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.alexisdacosta.bankaccountkata.domain.business.models.BankAccount;
import dev.alexisdacosta.bankaccountkata.infrastructure.BankAccountRepository;

@SpringBootApplication
public class BankAccountKataApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountKataApplication.class, args);
	}

	@Bean
    public CommandLineRunner bootstrapData(BankAccountRepository repository) {
        return (args) -> {
            Integer initialBalance = 1000;
            BankAccount bankAccount = new BankAccount(UUID.randomUUID(), initialBalance);
            repository.save(bankAccount);
        };
    }

}
