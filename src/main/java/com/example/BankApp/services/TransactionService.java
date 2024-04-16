package com.example.BankApp.services;


import com.example.BankApp.dto.AccountDto;
import com.example.BankApp.dto.TransactionDto;
import com.example.BankApp.entity.Account;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Service
public interface TransactionService {

    List<TransactionDto> getAllTransactions();

    List<TransactionDto> getTransactionByAccountNumber(String accountNumber);

    List<TransactionDto> getAllTransactionsByTransactionTime(LocalDate transactionTime);

    TransactionDto createTransactions(TransactionDto transactionDto);







}
