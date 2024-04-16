package com.example.BankApp.repositories;

import com.example.BankApp.entity.Account;
import com.example.BankApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByAccount_AccountNumber(String accountNumber);

    boolean existsByUsername(String username);

    void deleteByUsername(String username);

}
