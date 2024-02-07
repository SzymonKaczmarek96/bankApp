package com.example.BankApp.controller;


import com.example.BankApp.dto.AccountDto;
import com.example.BankApp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccounts(){
        List<AccountDto> accountDtoList = accountService.getAllAccount();
        return ResponseEntity.ok(accountDtoList);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDto>getAccountNumber(@PathVariable String accountNumber){
        AccountDto accountGetDetails = accountService.getAccountDetails(accountNumber);
        return ResponseEntity.ok(accountGetDetails);
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDto> accountCreate(@RequestBody AccountDto accountDto){
        AccountDto createdAccount = accountService.createAccount(accountDto);
        return ResponseEntity.ok().body(createdAccount);
    }

    @PutMapping("/update/{accountNumber}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable String accountNumber, @RequestBody AccountDto accountDto){
        AccountDto updateAccountInformation = accountService.updateAccountInformation(accountNumber,accountDto);
        return ResponseEntity.ok().body(updateAccountInformation);

    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<AccountDto> deleteAccount(@PathVariable String accountNumber){
        accountService.deleteAccount(accountNumber);
        return ResponseEntity.noContent().build();
    }





}
