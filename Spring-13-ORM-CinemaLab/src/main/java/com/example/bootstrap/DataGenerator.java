package com.example.bootstrap;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataGenerator implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public DataGenerator(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println();

        System.out.println(accountRepository.findAllByCountryOrState("United States", "New York"));


    }
}
