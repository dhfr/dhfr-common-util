/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.common.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

/**
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 27 January 2014
 */
public class AESUtil {

    private static final Logger LOGGER = Logger.getLogger(AESUtil.class);

    /**
     * This method for encrypt string using AES algorithm
     *
     * @param input String data input that will encrypt
     * @param keyValue array of byte key parameter that will used in encryption
     * technic
     * @param typeEncription type of AES encryption sample: AES/ECB/PKCS5Padding see CommonUtilConstant.AES_ALGO.
     * @return string that already encrypted by AES
     */
    public static String getAESEncription(String input, byte[] keyValue, String typeEncription) {

        SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
        byte[] encVal = null;
        try {
            Cipher cipher = Cipher.getInstance(typeEncription);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encVal = cipher.doFinal(input.getBytes());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            LOGGER.error("Error", ex);
            ex.getMessage();
        }
        return Base64.encodeBase64String(encVal);
    }

    /**
     * This method for decryption string using AES algorithm
     *
     * @param ouput String data input that will decrypt
     * @param keyValue array of byte key parameter that will used in decryption
     * technic
     * @param typeEncription type of AES encryption sample: AES/ECB/PKCS5Padding see CommonUtilConstant.AES_ALGO.
     * @return
     */
    public static String getAESDescription(String ouput, byte[] keyValue, String typeEncription) {
        SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
        byte[] encVal = null;
        try {
            Cipher cipher = Cipher.getInstance(typeEncription);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decordedValue = Base64.decodeBase64(ouput);
            encVal = cipher.doFinal(decordedValue);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            LOGGER.error("Error", ex);
        }

        return new String(encVal);
    }
}
