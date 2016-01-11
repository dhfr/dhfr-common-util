/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.common.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * This Class is helper class for hash a String.
 * We can use MD and SHA algorithm
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 28 January 2014
 */
public class HashingUtils {

    /**
     * Calculates the SHA-256 digest and returns the value as a hex string.
     *
     * @return String hex string
     * @param sha256 - Data to digest
     */
    public static String getHashSHA256(String sha256) {
        return DigestUtils.sha256Hex(sha256);
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a hex string.
     *
     * @return String hex string
     * @param sha1 - Data to digest in String type
     */
    public static String getHashSHA1(String sha1) {
        return DigestUtils.sha1Hex(sha1);
    }

    /**
     * Calculates the MD5 digest and returns the value as a 32 character hex
     * string.
     *
     * @return String hex string
     * @param md5 - Data to digest
     */
    public static String getHashMD5(String md5) {
        return DigestUtils.md5Hex(md5);
    }

    /**
     * Calculates the MD2 digest and returns the value as a 32 character hex
     * string.
     *
     * @return String hex string
     * @param md2 - Data to digest
     */
    public static String getHashMD2(String md2) {
        return DigestUtils.md2Hex(md2);
    }

    /**
     * Calculates the SHA-512 digest and returns the value as a hex string.
     *
     * @return String hex string
     * @param sha512 - Data to digest
     *
     */
    public static String getHashSHA512(String sha512) {
        return DigestUtils.sha512Hex(sha512);
    }

    /**
     * Calculates the SHA-384 digest and returns the value as a hex string.
     *
     * @return String hex string
     * @param sha384 - Data to digest
     */
    public static String getHashSHA384(String sha384) {
        return DigestUtils.sha384Hex(sha384);
    }
}
