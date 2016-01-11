/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.common.util;


import com.dhfr.common.CommonUtilConstant;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.InitializingBean;

/**
 * NumberFormatter, a class with function to format and parse from String type
 * to Number and vice versa. Note this class can managed by Spring.
 * <p>
 * All global parameter are managed by spring like minFractionDigit</P>
 * <p>
 * DefaultLocale default local where the application running, see
 * application.properties. Locale is active locale that used by application, get
 * locale from local session or application session
 *
 * <p>
 * typeInstance - Type number format</p>
 * <ul>
 * <li>CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE=currency</li>
 * <li>CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE=number</li>
 * <li>CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE=percent</li>
 * </ul>
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 14 January 2014
 */
public class NumberFormatter implements InitializingBean {

    private Integer minFractionDigit;
    private Integer maxFractionDigit;
    private String defaultLocale;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (minFractionDigit == null) {
            throw new Exception("Mr. DHFR say :Property of minFractionDigit can't be null."
                    + " Please see and config common_util.properties");
        }
        if (maxFractionDigit == null) {
            throw new Exception("Mr. DHFR say :Property of maxFractionDigit can't be null."
                    + " Please see and config common_util.properties");
        }
        if (defaultLocale.equalsIgnoreCase("") || defaultLocale == null) {
            throw new Exception("Mr. DHFR say :Property of defaultLocale can't be null."
                    + " Please see and config common_util.properties");
        }
    }

    public Integer getMinFractionDigit() {
        return minFractionDigit;
    }

    public void setMinFractionDigit(Integer minFractionDigit) {
        this.minFractionDigit = minFractionDigit;
    }

    public Integer getMaxFractionDigit() {
        return maxFractionDigit;
    }

    public void setMaxFractionDigit(Integer maxFractionDigit) {
        this.maxFractionDigit = maxFractionDigit;
    }

    public String getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    /**
     * <p>
     * Get number format with default locale. The return value is String </p>
     * <p>
     * The maximal and minimal fraction are configured in
     * application.properties</p>
     * <p>
     * typeInstance - Type number format</p>
     * <ul>
     * <li>CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE=currency</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE=number</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE=percent</li>
     * </ul>
     *
     * @return String number format
     * @param inputNumber number reference
     * @param typeInstance type of number format
     */
    public String getNumberAsStringDefaultLocale(Number inputNumber, String typeInstance) {
        NumberFormat nf = getNumberFormat(typeInstance, new Locale(defaultLocale));
        nf.setMaximumFractionDigits(maxFractionDigit);
        nf.setMinimumFractionDigits(minFractionDigit);
        return nf.format(inputNumber);
    }

    /**
     * <p>
     * Get number format with default locale. The return value is String. This
     * method is static so don't managed by Sping</p>
     * <p>
     * The maximal and minimal fraction are configured in
     * application.properties</p>
     * <p>
     * typeInstance - Type number format</p>
     * <ul>
     * <li>CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE=currency</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE=number</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE=percent</li>
     * </ul>
     *
     * @param maxPractionDigi maximum total digit
     * @param minPractionDigit minimum total digit
     * @return String number format
     * @param inputNumber number reference
     * @param typeInstance type of number format
     */
    public static String getNumberAsStringDefaultLocale(Number inputNumber, String typeInstance,
            Integer maxPractionDigi, Integer minPractionDigit) {
        NumberFormat nf = getNumberFormatStatic(typeInstance, Locale.getDefault());
        nf.setMaximumFractionDigits(maxPractionDigi);
        nf.setMinimumFractionDigits(minPractionDigit);
        return nf.format(inputNumber);
    }

    /**
     * <p>
     * Get number format with specific locale. the return value is String </p>
     * <p>
     * the maximal and minimal fraction are configured in
     * application.properties</p>
     * <p>
     * typeInstance - Type number format</p>
     * <ul>
     * <li>CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE=currency</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE=number</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE=percent</li>
     * </ul>
     *
     * @return String number format
     * @param inputNumber number reference
     * @param locale Locale reference
     * @param typeInstance type of number format
     */
    public String getNumberAsStringActiveLocale(Number inputNumber, Locale locale, String typeInstance) {
        NumberFormat nf = getNumberFormat(typeInstance, locale);
        nf.setMaximumFractionDigits(maxFractionDigit);
        nf.setMinimumFractionDigits(minFractionDigit);
        return nf.format(inputNumber);
    }

    /**
     * <p>
     * Get number format with specific locale. the return value is String. This
     * method is static so do not managed by spring</p>
     * <p>
     * the maximal and minimal fraction are configured in
     * application.properties</p>
     * <p>
     * typeInstance - Type number format</p>
     * <ul>
     * <li>CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE=currency</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE=number</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE=percent</li>
     * </ul>
     *
     * @param maxFractionDigit
     * @param minFractionDigit
     * @return String number format
     * @param inputNumber number reference
     * @param locale Locale reference
     * @param typeInstance type of number format
     */
    public static String getNumberAsStringActiveLocale(Number inputNumber, Locale locale, String typeInstance,
            Integer maxFractionDigit, Integer minFractionDigit) {
        NumberFormat nf = getNumberFormatStatic(typeInstance, locale);
        nf.setMaximumFractionDigits(maxFractionDigit);
        nf.setMinimumFractionDigits(minFractionDigit);
        return nf.format(inputNumber);
    }

    /**
     * <p>
     * Get number format with default locale. the return value is Number </p>
     * <p>
     * the maximal and minimal fraction are configured in
     * application.properties</p>
     * <p>
     * typeInstance - Type number format</p>
     * <ul>
     * <li>CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE=currency</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE=number</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE=percent</li>
     * </ul>
     *
     * @return Number number format
     * @param inputNumber number reference
     * @param typeInstance type of number format
     * @throws java.text.ParseException
     */
    public Number getNumberDefaultLocale(String inputNumber, String typeInstance) throws ParseException {
        NumberFormat nf = getNumberFormat(typeInstance, new Locale(defaultLocale));
        nf.setMaximumFractionDigits(maxFractionDigit);
        nf.setMinimumFractionDigits(minFractionDigit);
        return nf.parse(inputNumber);
    }

    /**
     * <p>
     * Get number format with default locale. the return value is Number. This
     * method is static so don't managed by spring </p>
     * <p>
     * the maximal and minimal fraction are configured in
     * application.properties</p>
     * <p>
     * typeInstance - Type number format</p>
     * <ul>
     * <li>CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE=currency</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE=number</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE=percent</li>
     * </ul>
     *
     * @param maxFractionDigit
     * @param minFractionDigit
     * @return Number number format
     * @param inputNumber number reference
     * @param typeInstance type of number format
     * @throws java.text.ParseException
     */
    public static Number getNumberDefaultLocale(String inputNumber, String typeInstance,
            Integer maxFractionDigit, Integer minFractionDigit) throws ParseException {
        NumberFormat nf = getNumberFormatStatic(typeInstance, Locale.getDefault());
        nf.setMaximumFractionDigits(maxFractionDigit);
        nf.setMinimumFractionDigits(minFractionDigit);
        return nf.parse(inputNumber);
    }

    /**
     * <p>
     * Get number format with specific locale. the return value is Number </p>
     * <p>
     * The maximal and minimal fraction are configured in
     * application.properties</p>
     * <p>
     * typeInstance - Type number format</p>
     * <ul>
     * <li>CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE=currency</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE=number</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE=percent</li>
     * </ul>
     *
     * @return String number format
     * @param inputNumber number reference
     * @param locale Locale reference
     * @param typeInstance type of number format
     * @throws java.text.ParseException
     */
    public Number getNumberActiveLocale(String inputNumber, Locale locale, String typeInstance) throws ParseException {
        NumberFormat nf = getNumberFormat(typeInstance, locale);
        nf.setMaximumFractionDigits(maxFractionDigit);
        nf.setMinimumFractionDigits(minFractionDigit);
        return nf.parse(inputNumber);
    }

    /**
     * <p>
     * Get number format with specific locale. the return value is Number. This
     * method is static so don't managed by spring </p>
     * <p>
     * The maximal and minimal fraction are configured in
     * application.properties</p>
     * <p>
     * typeInstance - Type number format</p>
     * <ul>
     * <li>CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE=currency</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE=number</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE=percent</li>
     * </ul>
     *
     * @param maxFractionDigit
     * @param minFractionDigit
     * @return String number format
     * @param inputNumber number reference
     * @param locale Locale reference
     * @param typeInstance type of number format
     * @throws java.text.ParseException
     */
    public static Number getNumberActiveLocale(String inputNumber, Locale locale, String typeInstance,
            int maxFractionDigit, int minFractionDigit) throws ParseException {
        NumberFormat nf = getNumberFormatStatic(typeInstance, locale);
        nf.setMaximumFractionDigits(maxFractionDigit);
        nf.setMinimumFractionDigits(minFractionDigit);
        return nf.parse(inputNumber);
    }

    /**
     * <p>
     * Get instance class of Number Formatter with specific Locale and number
     * format type</p>
     * <p>
     * TypeInstance - Type number format</p>
     * <ul>
     * <li>CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE=currency</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE=number</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE=percent</li>
     * </ul>
     *
     * @return String number format
     * @param locale Locale reference
     * @param typeInstance type of number format
     */
    public NumberFormat getNumberFormat(String typeInstance, Locale locale) {
        NumberFormat nf = null;
        if (typeInstance.equalsIgnoreCase(CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE)) {
            nf = NumberFormat.getNumberInstance(locale);
        }
        if (typeInstance.equalsIgnoreCase(CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE)) {
            nf = NumberFormat.getPercentInstance(locale);
        }
        if (typeInstance.equalsIgnoreCase(CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE)) {
            nf = NumberFormat.getCurrencyInstance(locale);
        }
        return nf;
    }

    /**
     * <p>
     * Get instance class of Number Formatter with specific Locale and number
     * format type. This method is static so do not managed by spring</p>
     * <p>
     * TypeInstance - Type number format</p>
     * <ul>
     * <li>CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE=currency</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE=number</li>
     * <li>CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE=percent</li>
     * </ul>
     *
     * @return String number format
     * @param locale Locale reference
     * @param typeInstance type of number format
     */
    public static NumberFormat getNumberFormatStatic(String typeInstance, Locale locale) {
        NumberFormat nf = null;
        if (typeInstance.equalsIgnoreCase(CommonUtilConstant.NUMBER_FORMAT_NUMBER_TYPE)) {
            nf = NumberFormat.getNumberInstance(locale);
        }
        if (typeInstance.equalsIgnoreCase(CommonUtilConstant.NUMBER_FORMAT_PERCENT_TYPE)) {
            nf = NumberFormat.getPercentInstance(locale);
        }
        if (typeInstance.equalsIgnoreCase(CommonUtilConstant.NUMBER_FORMAT_CURRENCY_TYPE)) {
            nf = NumberFormat.getCurrencyInstance(locale);
        }
        return nf;
    }

}
