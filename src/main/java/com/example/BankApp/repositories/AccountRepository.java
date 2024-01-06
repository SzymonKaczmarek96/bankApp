package com.example.BankApp.repositories;

import com.example.BankApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByAccountNumber(String accountNumber);
}
