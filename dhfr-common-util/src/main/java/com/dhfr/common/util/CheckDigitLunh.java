/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.common.util;

import org.apache.commons.validator.routines.checkdigit.CheckDigit;
import org.apache.commons.validator.routines.checkdigit.CheckDigitException;
import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;

/**
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 27 January 2014
 */
public class CheckDigitLunh {

    /**
     * Check a series of number is valid or not using lunh algorithm
     *
     * @param number
     * @return Boolean
     */
    public static Boolean isValidNumberByLunh(String number) {
        CheckDigit checkDigit = new LuhnCheckDigit();
        return checkDigit.isValid(number);
    }

    /**
     * Calculate a number for the check digit
     * @param code
     * @return String code of check digit
     * @throws org.apache.commons.validator.routines.checkdigit.CheckDigitException
     */
    public static String calculate(String code) throws CheckDigitException {
        CheckDigit checkDigit = new LuhnCheckDigit();
        return checkDigit.calculate(code);
    }
}
