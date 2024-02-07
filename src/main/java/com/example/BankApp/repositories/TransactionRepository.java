package com.example.BankApp.repositories;

import com.example.BankApp.entity.Account;
import com.example.BankApp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findByAccount_AccountNumber(String accountNumber);
    List<Transaction> findByTransactionTime(LocalDate transactionTime);
}
