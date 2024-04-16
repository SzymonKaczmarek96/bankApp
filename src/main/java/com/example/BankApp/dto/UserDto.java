package com.example.BankApp.dto;

import com.example.BankApp.entity.Account;
import com.example.BankApp.entity.User;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class UserDto {

    private String username;

    private String password;

    private String phoneNumber;

    private Account account;

    private String role;


    public User toUserEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .phoneNumber(phoneNumber)
                .account(account)
                .role(role)
                .build();
    }
}
