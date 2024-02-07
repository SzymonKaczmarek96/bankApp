package com.example.BankApp.impl;


import com.example.BankApp.dto.TransactionDto;
import com.example.BankApp.entity.Account;
import com.example.BankApp.entity.Transaction;
import com.example.BankApp.exceptions.AccountNotExistException;
import com.example.BankApp.repositories.AccountRepository;
import com.example.BankApp.repositories.TransactionRepository;
import com.example.BankApp.services.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;

    private AccountServiceImpl accountService;


    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository, AccountServiceImpl accountService) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
       return transactionRepository.findAll().stream().map(Transaction::toTransactionDto).toList();
    }

    @Override
    public List<TransactionDto> getTransactionByAccountNumber(String accountNumber){
        List<Transaction> transactionsByAccountNumber = transactionRepository.findByAccount_AccountNumber(accountNumber);
        return transactionsByAccountNumber.stream().map(Transaction::toTransactionDto).toList();
        }
    @Override
    public List<TransactionDto> getAllTransactionsByTransactionTime(LocalDate transactionTime) {
        List<Transaction> transactionsByDateTime = transactionRepository.findByTransactionTime(transactionTime);
        return transactionsByDateTime.stream().map(Transaction::toTransactionDto).toList();
    }

    @Override
    public TransactionDto createTransactions(TransactionDto transactionDto) {
        try {
            Transaction transaction = transactionDto.toTransactionEntity();
            TransactionDto saveTransaction = transactionRepository.save(transaction).toTransactionDto();
            return saveTransaction;
        }catch (Exception e){
            throw new AccountNotExistException();
        }
    }
}
