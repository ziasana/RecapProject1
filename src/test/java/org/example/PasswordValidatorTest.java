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
        assertTrue(PasswordValidator.hasMinLength(password, 8));
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void containsDigit_ReturnTrueWhenContainsAtLeastOneDigit(String password) {
        assertTrue(PasswordValidator.containsDigits(password));
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void containsUpperAndLower_ReturnTrueWhenContainsBothLowerAndUpper(String password) {
        assertTrue(PasswordValidator.containsUpperAndLower(password));
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void isCommonPassword_ReturnFalseWhenContainsCommonPassword(String password) {
        assertFalse(PasswordValidator.isCommonPassword(password));
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void containsTwoSpecialChar_ReturnTrueWhenContainsTwoSpecialChar(String password) {
        String allowedChar="!@#$%^&*()-_+=?.,;:";
        assertTrue(PasswordValidator.containsTwoSpecialChar(password, allowedChar));
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void containsTwoDigits_ReturnTrueWhenContainsAtLeastTwoDigits(String password) {
        assertTrue(PasswordValidator.containsTwoDigits(password));
    }


    @ParameterizedTest
    @CsvFileSource (resources = "/password-valid-data.txt")
    void isValid_ReturnTrueWhenAllChecksPassed(String password) {

        assertAll("password validation",
                () -> assertTrue(PasswordValidator.hasMinLength(password, 8), "Min length check failed"),
                () -> assertTrue(PasswordValidator.containsUpperAndLower(password), "Upper and lower case check failed"),
                () -> assertFalse(PasswordValidator.isCommonPassword(password), "Common password check failed"),
                () -> assertTrue(PasswordValidator.containsTwoSpecialChar(password, "!@#$%^&*()-_+=?.,;:"), "Two special char \"#$%&?@()\" check failed"),
                () -> assertTrue(PasswordValidator.containsTwoDigits(password), "Two digits check failed"),
                () -> assertFalse(PasswordValidator.hasSpace(password), "Space check failed")
        );
    }

}