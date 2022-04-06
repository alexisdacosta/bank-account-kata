package dev.alexisdacosta.bankaccountkata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dev.alexisdacosta.bankaccountkata.BankAccountKataApplication;
import dev.alexisdacosta.bankaccountkata.domain.business.services.BankAccountService;
import dev.alexisdacosta.bankaccountkata.infrastructure.BankAccountRepository;

@Configuration
@ComponentScan(basePackageClasses = BankAccountKataApplication.class)
public class BeanConfiguration {
    
    @Bean
    BankAccountService bankAccountService(BankAccountRepository repository) {
        return new BankAccountService(repository, repository);
    }
}
