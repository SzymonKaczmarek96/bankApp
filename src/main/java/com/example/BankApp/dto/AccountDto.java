package com.example.BankApp.dto;

import com.example.BankApp.entity.Account;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class AccountDto {

    private String accountNumber;

    private BigDecimal balance;

    public Account toAccountEntity() {
        return Account.builder()
                .accountNumber(accountNumber)
                .balance(balance)
                .build();
    }
}
