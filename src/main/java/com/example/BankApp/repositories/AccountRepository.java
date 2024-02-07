package com.example.BankApp.repositories;

import com.example.BankApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findById(Long idAccount);

    Optional<Account> findByAccountNumber(String accountNumber);

    boolean existsByAccountNumber(String accountNumber);

    void deleteByAccountNumber(String accountNumber);

}
