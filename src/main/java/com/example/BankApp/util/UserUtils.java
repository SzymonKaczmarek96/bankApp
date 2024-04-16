package com.example.BankApp.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;


@RequiredArgsConstructor
@Component
public class UserUtils {

    public String generateUserName(){
        Random random = new Random();
        ArrayList<Character> generateSignsList = new ArrayList<>(Arrays.asList('0','1', '2', '3', '4', '5', '6', '7', '8', '9'));
        StringBuilder sb = new StringBuilder();
        for(int i=0;i <= 8; i++){
            char sign = generateSignsList.get(random.nextInt(10));
            sb.append(sign);
        }
        return sb.toString();
    }

    public int countDigitsInPassword(String password){
        ArrayList<Character> allowedSigns = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        int numberOfAppearances = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);;
            for(int j =0; j < allowedSigns.size(); j++){
                if(c == allowedSigns.get(j)){
                    numberOfAppearances += 1;
                }
            }
        }
        return numberOfAppearances;
    }


    public boolean checkSignsPassword(int method){
        if(method == 5){
            return true;
        }
        return false;
    }

}
