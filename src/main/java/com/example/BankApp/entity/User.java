package com.example.BankApp.entity;

import com.example.BankApp.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long user_id;

    private String username;

    @Transient
    private String password;

    private String phoneNumber;

    @ManyToOne
    private Account account;

    private String role;

    public UserDto toUserDto() {
        return UserDto.builder()
                .username(username)
                .password(password)
                .phoneNumber(phoneNumber)
                .account(account)
                .role(role)
                .build();
    }


}
