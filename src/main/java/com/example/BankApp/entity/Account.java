package com.example.BankApp.entity;

import com.example.BankApp.dto.AccountDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String accountNumber;

    private BigDecimal balance;

    public AccountDto toAccountDto(){
        return AccountDto.builder()
                .accountNumber(accountNumber)
                .balance(balance)
                .build();
    }


}
