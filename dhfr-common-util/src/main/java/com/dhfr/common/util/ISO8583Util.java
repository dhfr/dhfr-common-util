/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.common.util;

/**
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 2 February 2014
 */
public class ISO8583Util {

    /**
     *
     * <p>
     * Find the Bitmap length of messages in iso 8583 format.
     * </p>
     *
     *
     * @param originalMsg is messages in String type
     * @return Integer value
     */
    public static Integer findLengthOfBitmap(String originalMsg) {
        String firstBitmap = originalMsg.substring(4, 5);
        int lenghtOfBitmap;
        if (DecimalHexBinaryConverter.hexaToBinary(firstBitmap).substring(0, 1).equalsIgnoreCase("1")) {
            lenghtOfBitmap = 32;
        } else {
            lenghtOfBitmap = 16;
        }
        return lenghtOfBitmap;
    }

    /**
     *
     * <p>
     * Find data element from binary bitmap. Data element contains all real
     * information of transaction it self.
     * </p>
     *
     *
     * @param binaryBitmap in String type
     * @return String value
     */
    public static String findActiveDE(String binaryBitmap) {
        StringBuilder activeDE = new StringBuilder();
        char[] charBinaryBitmap = binaryBitmap.toCharArray();
        int counter = 0;
        for (int i = 0; i < charBinaryBitmap.length; i++) {
            counter++;
            if (String.valueOf(charBinaryBitmap[i]).equals("1")) {
                activeDE.append(String.valueOf(counter)).append(";");
            }
        }

        return activeDE.toString();
    }

    /**
     *
     * <p>
     * Find binary bitmap from messages in hexa bitmap format.
     * </p>
     *
     * @param hexaBitmap in String type
     * @return String value
     */
    public static String findBinaryBitmapFromHexa(String hexaBitmap) {
        StringBuilder binaryBitmap = new StringBuilder();
        char[] rawBitmap = hexaBitmap.toCharArray();
        for (int i = 0; i < rawBitmap.length; i++) {
            binaryBitmap.append(DecimalHexBinaryConverter.hexaToBinary(String.valueOf(rawBitmap[i])));
        }
        return binaryBitmap.toString();
    }

    /**
     *
     * <p>
     * Find message type indicator with 4 digit length character. MIT is sing
     * first data in iso 8583 messages format. ISO Version
     * ===================================== Position |Meaning
     * ===================================== 0xxx ISO 8583-1:1987 version 1xxx
     * ISO 8583-2:1993 version 2xxx ISO 8583-1:2003 version 9xxx Private Usage
     * ===================================== For more detail (Messages Class,
     * messages function, and messages origin) please see
     * http://en.wikipedia.org/wiki/ISO_8583
     * </p>
     *
     * @param originalMsg in String type
     * @return String value
     */
    public static String findMTI(String originalMsg) {
        return originalMsg.substring(0, 4);
    }

    /**
     *
     * <p>
     * Get hexa bitmap from array of active DE.
     * </p>
     *
     * @param activeDE in array integer.
     * @return String value
     */
    public static String getHexaBitmapFromActiveDE(int[] activeDE) {
        StringBuilder finalHexaBitmap = new StringBuilder();
        StringBuilder binaryBitmapForReply = new StringBuilder();

        boolean secondarBitmapActive = false;
        int panjangBitmap = 16;
        // Check secondary bitmap
        for (int i = 0; i < activeDE.length; i++) {
            if (activeDE[i] > 64) {
                secondarBitmapActive = true;
                panjangBitmap = 32;
            }
        }

        // x4 for get all total element
        panjangBitmap *= 4;
        int counterBitmap = 0;
        String active = "";
        for (int i = 0; i < panjangBitmap; i++) {
            counterBitmap++;
            active = "0";
            for (int j = 0; j < activeDE.length; j++) {
                if (counterBitmap == activeDE[j]) {
                    active = "1";
                }
            }

            binaryBitmapForReply.append(active);
        }

        // because secondary bitmap active, first bit change to 1
        if (secondarBitmapActive) {
            binaryBitmapForReply = new StringBuilder("1" + binaryBitmapForReply.toString().substring(1, binaryBitmapForReply.length()));
        }

        char[] binaryBitmapChar = binaryBitmapForReply.toString().toCharArray();
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binaryBitmapChar.length; i++) {
            sb.append(binaryBitmapChar[i]);
            counter++;

            if (counter == 4) {
                finalHexaBitmap.append(DecimalHexBinaryConverter.binaryToHexa(sb.toString()));
                sb = new StringBuilder();
                counter = 0;
            }
        }

        return finalHexaBitmap.toString();
    }
}
