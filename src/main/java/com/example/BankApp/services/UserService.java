package com.example.BankApp.services;

import com.example.BankApp.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    List<UserDto> getAllUser();

    UserDto getUserDetail(String username);

    UserDto createUser(UserDto userDto);

    UserDto changeUserPassword(String username,String password);

    boolean deleteUser(String username);

    String createUsername();

    boolean checkPassword(String password);




}
