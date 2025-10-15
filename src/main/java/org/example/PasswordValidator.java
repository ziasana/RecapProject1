package org.example;

import java.util.*;

public class PasswordValidator {


    public static boolean hasMinLength(String password, int min) {
        if (password.isEmpty())
            return false;
        return password.length() >= min;
    }

   public static boolean containsDigits(String password) {
        if (password.isEmpty())
            return false;
        boolean digitsFound = false;
        for(char c : password.toCharArray()) {
            if(Character.isDigit(c)) {
                digitsFound = true;
                break;
            }
        }
        return digitsFound;
   }
   public static boolean containsUpperAndLower(String password){
        if(password.isEmpty())
            return false;
        boolean upperFound = false;
        boolean lowerFound = false;
        for(char c: password.toCharArray()){
            if(!upperFound && Character.isUpperCase(c)) {
                upperFound = true;
            }
            else if(!lowerFound && Character.isLowerCase(c)) {
                lowerFound = true;
            }
            if(upperFound && lowerFound) {
                break;
            }
        }
        return upperFound && lowerFound;
   }

    public static boolean isCommonPassword(String password) {
        Set<String> commonPasswordSet = new HashSet<>();
        commonPasswordSet.add("password".trim().toLowerCase());
        commonPasswordSet.add("Passwort1".trim().toLowerCase());
        commonPasswordSet.add("12345678".trim().toLowerCase());
        commonPasswordSet.add("Aa345678".trim().toLowerCase());
        return commonPasswordSet.contains(password);
    }

    public static boolean containsTwoSpecialChar(String password, String allowedChar) {
        if(password.isEmpty() || allowedChar.isEmpty())
            return false;
        int foundCount = 0;
        for(char allowed : allowedChar.toCharArray()) {
            // if (password.indexOf(allowed) != -1) {
            if (password.contains(String.valueOf(allowed))) {
                foundCount++;
            }
            if (foundCount == 2)
                break;
        }
        return foundCount == 2;
    }

    public static boolean containsTwoDigits(String password) {
        if(password.isEmpty())
            return false;
        int foundCount = 0;
        for(char c : password.toCharArray()) {
            if(Character.isDigit(c)) {
                foundCount++;
            }
            if(foundCount == 2)
                break;
        }
        return foundCount == 2;
    }

    public static boolean hasSpace(String password) {
        if (password.isEmpty())
            return false;
        boolean found = false;
        for (char c : password.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
