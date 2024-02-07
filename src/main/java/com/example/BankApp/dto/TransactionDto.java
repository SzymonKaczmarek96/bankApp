package com.example.BankApp.dto;

import com.example.BankApp.entity.Account;
import com.example.BankApp.entity.Transaction;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Builder
@EqualsAndHashCode
public class TransactionDto {
    private String description;

    private BigDecimal amount;

    private LocalDate transactionTime;

    private Account account;

    public Transaction toTransactionEntity() {
        return Transaction.builder()
                .description(description)
                .amount(amount)
                .transactionTime(transactionTime)
                .account(account)
                .build();
    }
}
