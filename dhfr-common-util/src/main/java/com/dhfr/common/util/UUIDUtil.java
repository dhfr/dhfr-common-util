/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.common.util;

import java.util.UUID;

/**
 * This Class is helper class for generate UUID
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 1 February 2014
 */
public class UUIDUtil {

    /**
     * Generate random UUID
     *
     * @return String UUID value
     */
    public static String getRandomDataUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * Generate random UUID with specific size.
     *
     * @param size
     * @return String UUID value
     */
    public static String getRandomUUID(int size) {
        if (size > 36) {
            throw new IndexOutOfBoundsException("Mr. DHFR say :size to large. Maximum size is 36");
        } else if (size < 0) {
            throw new IndexOutOfBoundsException("Mr. DHFR say :minimum size is 0. Cannot negative number");
        } else {
            return getRandomDataUUID().substring(0, size);
        }

    }
}
