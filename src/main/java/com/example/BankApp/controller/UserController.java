package com.example.BankApp.controller;


import com.example.BankApp.dto.UserDto;

import com.example.BankApp.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;



    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> usersList(){
        List<UserDto> users = userService.getAllUser();
        return ResponseEntity.ok(users);

    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> displayUser(@PathVariable String username){
        UserDto detailsUser = userService.getUserDetail(username);
        return ResponseEntity.ok(detailsUser);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        try {
            if(userDto.getUsername() == null || userDto.getUsername().isEmpty()) {
                userDto.setUsername(userService.createUsername());
            }

            if(!userService.checkPassword(userDto.getPassword())){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            UserDto createdUser = userService.createUser(userDto);
            return ResponseEntity.ok().body(createdUser);
        }catch (DataIntegrityViolationException e){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<UserDto> updatePassword(@PathVariable String username, @RequestBody String password){
        String trimmedPassword = password.trim();
        UserDto updateUserPassword = userService.changeUserPassword(username,trimmedPassword);
        return ResponseEntity.ok().body(updateUserPassword);

    }
    @DeleteMapping("/{username}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable String username){
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/login")
    public ResponseEntity login(@PathVariable String username, String password) {

        return null;
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<String> handleDuplicateUsername(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Introduced username or password is incorrect");
    }

}
