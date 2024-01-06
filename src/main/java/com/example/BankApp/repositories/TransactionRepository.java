package com.example.BankApp.repositories;

import com.example.BankApp.entity.Account;
import com.example.BankApp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findByAccountNumber (Account account);

}
