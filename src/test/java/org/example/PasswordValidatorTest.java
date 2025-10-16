package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {


    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void hasSpace_ReturnFalseWhenSpaceExist(String password) {
        assertFalse(PasswordValidator.hasSpace(password));
    }


    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void hasMinLength_ReturnFalseWhenLengthIsSmallerThen8(String password) {
        assertTrue(PasswordValidator.hasMinLength(password, 8), "Password length is less than 8: " + password.length());
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void containsDigit_ReturnTrueWhenContainsAtLeastOneDigit(String password) {
        assertTrue(PasswordValidator.containsDigits(password), "Password does not contain any digit: " + password);
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void containsUpperAndLower_ReturnTrueWhenContainsBothLowerAndUpper(String password) {
        assertTrue(PasswordValidator.containsUpperAndLower(password), "Password does not contain both upper and lower case letters: " + password);
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void isCommonPassword_ReturnFalseWhenContainsCommonPassword(String password) {
        assertFalse(PasswordValidator.isCommonPassword(password), "Password is a common password: " + password);
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void containsTwoSpecialChar_ReturnTrueWhenContainsTwoSpecialChar(String password) {
        String allowedChar="!@#$%^&*()-_+=?.,;:";
        assertTrue(PasswordValidator.containsTwoSpecialChar(password, allowedChar), "Password does not contain at least two special characters from the allowed set: " + allowedChar + " in password: " + password);
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void containsTwoDigits_ReturnTrueWhenContainsAtLeastTwoDigits(String password) {
        assertTrue(PasswordValidator.containsTwoDigits(password), "Password does not contain at least two digits: " + password);
    }


    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void isValid_ReturnTrueWhenAllChecksPassed(String password) {
        assertNotEquals("", PasswordValidator.isValid(password), "Password validation failed for: " + password);
    }


}