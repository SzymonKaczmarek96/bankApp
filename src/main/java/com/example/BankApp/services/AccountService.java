package com.example.BankApp.services;

import com.example.BankApp.dto.AccountDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface AccountService {

    List<AccountDto> getAllAccount();

    AccountDto getAccountDetails(String accountNumber);

    AccountDto createAccount(AccountDto accountDto);

    AccountDto updateAccountInformation(String accountNumber, AccountDto accountDto);

    boolean deleteAccount(String accountNumber);



}
