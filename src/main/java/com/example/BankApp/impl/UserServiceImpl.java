package com.example.BankApp.impl;

import com.example.BankApp.dto.UserDto;
import com.example.BankApp.entity.User;
import com.example.BankApp.exceptions.PasswordNotConditionsException;
import com.example.BankApp.exceptions.UserNotExistException;
import com.example.BankApp.repositories.UserRepository;
import com.example.BankApp.services.UserService;
import com.example.BankApp.util.UserUtils;
import jakarta.transaction.Transactional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserUtils userUtils;

    public UserServiceImpl(UserRepository userRepository, UserUtils userUtils) {
        this.userRepository = userRepository;
        this.userUtils = userUtils;
    }

    @Override
    public List<UserDto> getAllUser() {
        return userRepository.findAll().stream().map(User::toUserDto).toList();
    }

    @Override
    public UserDto getUserDetail(String username) {
        Optional <User> gotUser = userRepository.findByUsername(username);
        if(gotUser.isPresent()){
            return gotUser.get().toUserDto();
        }else{
            throw new UsernameNotFoundException(username);
        }
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = userDto.toUserEntity();
        UserDto saveUser = userRepository.save(user).toUserDto();
        return saveUser;

    }

    @Override
    public UserDto changeUserPassword(String username, String password) {
        Optional <User> updateUserInformation = userRepository.findByUsername(username);
        System.out.println(updateUserInformation.get());
        if(!updateUserInformation.isPresent()){
            throw new UserNotExistException();
        }
        User existUser = updateUserInformation.get();

        existUser.setPassword(password);

        if(!checkPassword(existUser.getPassword())) {
            throw new PasswordNotConditionsException();
        }

        return userRepository.save(existUser).toUserDto();

    }

    @Transactional
    @Override
    public boolean deleteUser(String username) {
        if(userRepository.existsByUsername(username)){
            userRepository.deleteByUsername(username);
            return true;
        }

        return false;
    }

    @Override
    public String createUsername() {
        String createdUsername = userUtils.generateUserName();
       return createdUsername;
    }

    @Override
    public boolean checkPassword(String password) {
        int countedDigitsInPassword = userUtils.countDigitsInPassword(password);
        if(userUtils.checkSignsPassword(countedDigitsInPassword)){
            return true;
        }
        return false;
}
}


