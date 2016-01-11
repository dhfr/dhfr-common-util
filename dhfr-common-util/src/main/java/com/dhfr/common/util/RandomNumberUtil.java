/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.common.util;

import java.util.Random;

/**
 * This Class is helper class for generate random number
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 1 February 2014
 */
public class RandomNumberUtil {

    public static Long getRandomNumber() {
        return Math.abs(new Random().nextLong());
    }

    public static Integer getRandomInt(int numberSize) {
        return new Random().nextInt(numberSize);
    }

    /**
     * Generate random number between two number. Maximum digit is 10.
     *
     * @param begin is a begin random and include to solution
     * @param finish is finish random and include to solution
     * @return a random integer
     */
    public static Integer getRandomBettween(int begin, int finish) {
        if (begin > finish) {
            
            throw new IllegalArgumentException("Mr. DHFR say :Begin value must less than finish value");
        } else {
            return getRandomInt(finish - begin) + begin;
        }

    }

    /**
     * Generate random number
     *
     * @param numberSize
     * @return random number in string type. Maximum digit is 19
     */
    public static String getRandomNumber(Integer numberSize) {
        if (numberSize > 19) {
            throw new IllegalArgumentException("Mr. DHFR say :maximum digit is 19");
        } else {
            return getRandomNumber().toString().substring(0, numberSize);
        }
    }

}
