package com.example.BankApp.impl;

import com.example.BankApp.dto.AccountDto;
import com.example.BankApp.entity.Account;
import com.example.BankApp.exceptions.AccountCreationException;
import com.example.BankApp.exceptions.AccountNotExistException;
import com.example.BankApp.exceptions.DuplicateAccountException;
import com.example.BankApp.repositories.AccountRepository;
import com.example.BankApp.services.AccountService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {


    private final AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAllAccount() {
        return accountRepository.findAll().stream().map(Account::toAccountDto).toList();
    }

    @Override
    public AccountDto getAccountDetails(String accountNumber) {
        Optional <Account> getDetails = accountRepository.findByAccountNumber(accountNumber);
        if (getDetails.isPresent()) {
            return getDetails.get().toAccountDto();
        } else {
            throw new AccountNotExistException();
        }

    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        try {
            Account account = accountDto.toAccountEntity();
            AccountDto savedAccount = accountRepository.save(account).toAccountDto();
            return savedAccount;
        }catch (DataIntegrityViolationException e){
                throw new DuplicateAccountException();
        }catch (Exception e){
            throw new AccountCreationException();
        }

    }

    @Override
    public AccountDto updateAccountInformation(String accountNumber, AccountDto accountDto) {
       Optional <Account> updateAccount = accountRepository.findByAccountNumber(accountNumber);

       if(!updateAccount.isPresent()){
            throw new AccountNotExistException();
       }else {
           Account existsAccount = updateAccount.get();
           existsAccount.setBalance(accountDto.getBalance());
           existsAccount.setAccountNumber(accountDto.getAccountNumber());
           return accountRepository.save(existsAccount).toAccountDto();
       }
    }

    @Transactional
    @Override
    public boolean deleteAccount(String accountNumber) {
        if(accountRepository.existsByAccountNumber(accountNumber)){
            accountRepository.deleteByAccountNumber(accountNumber);
            return true;
        }
        return false;
    }
}
