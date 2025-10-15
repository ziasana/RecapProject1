package org.example;

import java.security.SecureRandom;

public class GeneratePassword {
   private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
   private static final String DIGITS = "0123456789";

    public static String generateSecurePassword(int length, String allowedSpecials)
    {
        if (length < 8) {
            throw new IllegalArgumentException("Password length must be at least 8 characters.");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Ensure required characters
        password.append(UPPER.charAt(random.nextInt(UPPER.length())));        // 1 uppercase
        password.append(LOWER.charAt(random.nextInt(LOWER.length())));        // 1 lowercase

        // Ensure at least TWO digits
        for (int i = 0; i < 2; i++) {
            password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }

        // Ensure at least two special character (if provided)
        if (allowedSpecials != null && !allowedSpecials.isEmpty()) {
            password.append(allowedSpecials.charAt(random.nextInt(allowedSpecials.length())));
        }
        for (int i = 0; i < 2; i++) {
            password.append(allowedSpecials.charAt(random.nextInt(DIGITS.length())));

        }
        // Fill the rest with random mix of all types
        String charPool = UPPER + LOWER + DIGITS + allowedSpecials;
        while (password.length() < length) {
            password.append(charPool.charAt(random.nextInt(charPool.length())));
        }

        return password.toString();
    }
}

