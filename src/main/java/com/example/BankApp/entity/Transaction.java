package com.example.BankApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false, length = 255)
    private String description;


    @Column(nullable = false)
    private double amount;


    @Column(nullable = false)
    private LocalDateTime transactionTime;


    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
