package com.example.BankApp.entity;

import com.example.BankApp.dto.TransactionDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String description;


    private BigDecimal amount;


    private LocalDate transactionTime;


    @ManyToOne
//    @JoinColumn(name = "account_id")
    private Account account;

    public TransactionDto toTransactionDto(){
        return TransactionDto.builder()
                .description(description)
                .amount(amount)
                .transactionTime(transactionTime)
                .account(account)
                .build();
    }


}
