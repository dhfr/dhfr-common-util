/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.common.util;

/**
 *<p> DecimalHexBinaryConverter is class for convert number in decimal, hexa, dan binary base.</p>
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 18 January 2014
 */
public class DecimalHexBinaryConverter {

    public static String decimalToHexa(Integer decimalNumber) {
        return Integer.toHexString(decimalNumber);
    }

    /**
     *
     * <p>
     * Get number in binary base from decimal base.
     * <p>
     *
     * @param decimalNumber is number in integer type
     * @return String as binary
     */
    public static String decimalToBinary(Integer decimalNumber) {
        StringBuilder binaryNumber = new StringBuilder();
        StringBuilder sbBinary = new StringBuilder();
        String binaryString = Integer.toBinaryString(decimalNumber);
        char[] binary = binaryString.toCharArray();
        int counter = 0;
        // ambil dari index karakter terakhir
        for (int i = binary.length - 1; i >= 0; i--) {
            counter++;
            sbBinary.append(binary[i]);
            // reset counter ke nol jika berhasil mengambil 4 digit karakter
            if (counter == 4) {
                counter = 0;
            }
        }
        // 4 adalah panjang karakter tiap blok di binary
        // ex: dec [100] == binary [0110 0100]
        for (int i = 0; i < 4 - counter; i++) {
            if (counter > 0) {
                sbBinary.append("0");
            }
        }
        // sekarang dibalik
        for (int i = sbBinary.length() - 1; i >= 0; i--) {
            binaryNumber.append(sbBinary.toString().charAt(i));
        }
        return binaryNumber.toString();
    }

    /**
     *
     * <p>
     * Get number in decimal base from binary base
     * <p>
     *
     * @param binaryNumber is number in binary base
     * @return Integer as binary
     */
    public static Integer binaryToDecimal(String binaryNumber) {
        return Integer.parseInt(binaryNumber, 2);
    }

    /**
     *
     * <p>
     * Get number in hexa base from binary base
     * <p>
     *
     * @param binaryNumber is number in binary base
     * @return String as hexa
     */
    public static String binaryToHexa(String binaryNumber) {
        return decimalToHexa(binaryToDecimal(binaryNumber));
    }

    /**
     *
     * <p>
     * Get number in decimal base from hexa base
     * <p>
     *
     * @param hexaNumber is number in hexa base
     * @return Integer as decimal
     */
    public static Integer hexaToDecimal(String hexaNumber) {
        return Integer.parseInt(hexaNumber, 16);
    }

    /**
     *
     * <p>
     * Get number in binary base from hexa base
     * <p>
     * @param hexaNumber is number in hexa base
     * @return String as binary
     */
    public static String hexaToBinary(String hexaNumber) {
        return decimalToBinary(hexaToDecimal(hexaNumber));
    }
}
