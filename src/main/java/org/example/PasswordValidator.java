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
       for (char c : password.toCharArray()) {
           if (Character.isDigit(c))
               return true;
       }
       return false;
   }

    public static boolean containsUpperAndLower(String password) {
        boolean hasUpper = false, hasLower = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (hasUpper && hasLower) return true;
        }
        return false;
    }


    public static boolean isCommonPassword(String password) {
        return Arrays.asList("password", "passwort1", "12345678", "aa345678", "password123")
                .contains(password);
    }

    public static boolean containsTwoSpecialChar(String password, String allowedChar) {
        if(password.isEmpty() || allowedChar.isEmpty())
            return false;
        int foundCount = 0;
        for(char allowed : allowedChar.toCharArray()) {
            // if (password.indexOf(allowed) != -1) {
            if (password.contains(String.valueOf(allowed))) {
                foundCount++;
                if (foundCount == 2) return true;
            }
        }
        return false;
    }

    public static boolean containsTwoDigits(String password) {
        if (password == null || password.isEmpty())
            return false;

        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
                if (digitCount == 2) return true;
            }
        }
        return false;
    }

    public static boolean hasSpace(String password) {
        if (password.isEmpty())
            return false;
        for (char c : password.toCharArray()) {
            if (Character.isSpaceChar(c))
                return true;
        }
        return false;
    }
}
