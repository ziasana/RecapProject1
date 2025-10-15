package org.example;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Password Validator and Generator App!");
        System.out.println("Choose an option:");
        System.out.println("1 - Validate a password");
        System.out.println("2 - Generate a secure password");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter password to validate:");
            String password = scanner.next();
            String result= PasswordValidator.isValid(password);
           System.out.println(result==null ? "Valid password." : "Invalid password." +'\n' + result);
        } else if (choice == 2) {
            System.out.println("Enter desired password length (min 8):");
            int length = scanner.nextInt();
            if (length < 8) length = 8;
            String newPassword = GeneratePassword.generateSecurePassword(length, "!@#$%^&*()-_+=?.,;:");
            System.out.println("Generated password: " + newPassword);
            String result = PasswordValidator.isValid(newPassword);
            System.out.println(result==null ? "Password verified and is valid." : "Password is varified and is invalid:\n" + result);
        } else {
            System.out.println("Invalid choice.");
        }
    }
}

