package com.example.BankApp.controller;


import com.example.BankApp.dto.AccountDto;
import com.example.BankApp.dto.TransactionDto;
import com.example.BankApp.entity.Transaction;
import com.example.BankApp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping ("/transaction")
public class TransactionController {


    private TransactionService transactionService;


    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping
    public ResponseEntity<List<TransactionDto>> transactionList() {
        List<TransactionDto> transactionDtos = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactionDtos);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<TransactionDto>> getAllTransactionToAccountNumber(@PathVariable String accountNumber) {
        List<TransactionDto> checkTransactionList = transactionService.getTransactionByAccountNumber(accountNumber);
        return ResponseEntity.ok(checkTransactionList);
    }

    @GetMapping("/time/{transactionTime}")
    public ResponseEntity<List<TransactionDto>> getAllTransactionToTransactionTime(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate transactionTime){
        List<TransactionDto> transactionDtoList = transactionService.getAllTransactionsByTransactionTime(transactionTime);
        return ResponseEntity.ok(transactionDtoList);
    }
}

