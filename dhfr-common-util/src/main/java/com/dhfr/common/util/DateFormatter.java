/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.InitializingBean;

/**
 * <p>
 * DateFormatter is a class with function to format and parse from String to
 * Date and vice versa.</p>
 * Note this class is managed by Spring and all global parameter like
 * defaultLocale,datePattern and other are injection using setter injection by
 * spring.
 * <p>
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 18 January 2014
 */
public class DateFormatter implements InitializingBean {

    private String defaultLocale;
    private String datePattern;
    private String timePattern;
    private String monthPattern;
    private String yearPattern;
    private String dayPattern;
    private String dateFullPattern;
    private String monthAndYearPattern;
    private String dayAndMonthPattern;

    public String getDayAndMonthPattern() {
        return dayAndMonthPattern;
    }

    public void setDayAndMonthPattern(String dayAndMonthPattern) {
        this.dayAndMonthPattern = dayAndMonthPattern;
    }

    public String getMonthAndYearPattern() {
        return monthAndYearPattern;
    }

    public void setMonthAndYearPattern(String monthAndYearPattern) {
        this.monthAndYearPattern = monthAndYearPattern;
    }

    public String getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    public String getTimePattern() {
        return timePattern;
    }

    public void setTimePattern(String timePattern) {
        this.timePattern = timePattern;
    }

    public String getMonthPattern() {
        return monthPattern;
    }

    public void setMonthPattern(String monthPattern) {
        this.monthPattern = monthPattern;
    }

    public String getYearPattern() {
        return yearPattern;
    }

    public void setYearPattern(String yearPattern) {
        this.yearPattern = yearPattern;
    }

    public String getDayPattern() {
        return dayPattern;
    }

    public void setDayPattern(String dayPattern) {
        this.dayPattern = dayPattern;
    }

    public String getDateFullPattern() {
        return dateFullPattern;
    }

    public void setDateFullPattern(String dateFullPattern) {
        this.dateFullPattern = dateFullPattern;
    }

    /**
     *
     * <p>
     * Get Date and formated with default locale. Return value is string with
     * default date pattern (dd-MMMM-yyyy). This date pattern is taken from
     * application properties. For more detail please see
     * application.properties</p>
     * <p>
     * The Date format using default active locale.</p>
     *
     * @return String return value is string with pattern date dd-MMMM-yyyy
     * @param date the date reference
     */
    public String getDateAsStringsDefaultLocale(Date date) {
        return new SimpleDateFormat(datePattern, new Locale(defaultLocale)).format(date);
    }

    /**
     *
     * <p>
     * Get Date and formated with specific locale. The return value is string
     * with default date pattern (dd-MMMM-yyyy). We can inject locale form
     * session or any kind a way to retrieve locale </p>
     * <p>
     * The value of default locale and date format pattern are configured in
     * application.properties</p>
     *
     * @return String return value is string with pattern date dd-MMMM-yyyy
     * @param date the date reference
     * @param locale Locale reference
     */
    public String getDateAsStringsWithActiveLocale(Date date, Locale locale) {
        return new SimpleDateFormat(datePattern, locale).format(date);
    }

    /**
     * <p>
     * Get Date and formated with default locale. The return value is string
     * with default full pattern (dd-MMMM-yy|hh:mm a)
     * </p>
     * </p>The value of default locale and date format pattern are configured in
     * application.properties</p>
     *
     * @return the value is string with default full date pattern
     * dd-MMMM-yy|hh:mm a
     * @param date the date reference
     */
    public String getDateFullAsStringsDefaultLocale(Date date) {
        return new SimpleDateFormat(dateFullPattern, new Locale(defaultLocale)).format(date);
    }

    /**
     * <p>
     * Get Date and formated with specific locale. The return value is string
     * with default full date pattern (dd-MMMM-yy|hh:mm a)</p>
     * <p>
     * For value of date format pattern are configured in
     * application.properties.We can inject locale form session or any kind a
     * way to retrieve locale </p>
     *
     * @return String return value is string with default full date pattern
     * dd-MMMM-yy|hh:mm a
     * @param date the date reference
     * @param locale Locale reference
     */
    public String getDateFullAsStringsWithActiveLocale(Date date, Locale locale) {
        return new SimpleDateFormat(dateFullPattern, locale).format(date);
    }

    /**
     * <p>
     * Get date only time and formated with default locale. The return value is
     * string with default time pattern (hh:mm:ss)</p>
     *
     * <p>
     * The value of default locale and default time pattern are configured in
     * application.properties</p>
     *
     * @return String return value is string with default time pattern hh:mm:ss
     * @param date the date reference
     */
    public String getTimeAsStringsDefaultLocale(Date date) {
        return new SimpleDateFormat(timePattern, new Locale(defaultLocale)).format(date);
    }

    /**
     * <p>
     * Get date only time and formated with specific locale.The return value is
     * string with default time pattern (hh:mm:ss)</p>
     *
     * <p>
     * The value of default time pattern are configured in
     * application.properties. We can inject locale form session or any kind a
     * way to retrieve locale </p>
     *
     * @return String return value is string with default time pattern hh:mm:ss
     * @param date the date reference
     * @param locale Locale reference
     */
    public String getTimeAsStringsWithActiveLocale(Date date, Locale locale) {
        return new SimpleDateFormat(timePattern, locale).format(date);
    }

    /**
     * <p>
     * Get date only month and formated with default locale, the return value is
     * string with default month pattern (MMMM)</p>
     * <p>
     * for value of default locale and default month pattern are configured in
     * application.properties
     * </p>
     *
     * @return String return value is string with default month pattern MMMM
     * @param date the date reference
     */
    public String getMonthAsStringsDefaultLocale(Date date) {
        return new SimpleDateFormat(monthPattern, new Locale(defaultLocale)).format(date);
    }

    /**
     * <p>
     * Get date only month and formated with specific locale. The return value
     * is string with default month pattern (MMMM)</p>
     * <p>
     * The value of default month pattern are configured in
     * application.properties. We can inject locale form session or any kind a
     * way to retrieve locale </p>
     *
     * @return String return value is string with default month pattern MMMM
     * @param date the date reference
     * @param locale Locale reference
     */
    public String getMonthAsStringsWithActiveLocale(Date date, Locale locale) {
        return new SimpleDateFormat(monthPattern, locale).format(date);
    }

    /**
     * <p>
     * Get date only year and formated with default locale. The return value is
     * string with default year pattern (yyyy)</p>
     * <
     * <p>
     * The value of default locale and default year pattern are configured in
     * application.properties</p>
     *
     * @return String return value is string with default year pattern yyyy
     * @param date the date reference
     */
    public String getYearAsStringsDefaultLocale(Date date) {
        return new SimpleDateFormat(yearPattern, new Locale(defaultLocale)).format(date);
    }

    /**
     * <p>
     * Get date only year and formated with specific locale. The return value is
     * string with default year pattern (yyyy)</p>
     *
     * <p>
     * The value of default year pattern are configured in
     * application.properties. We can inject locale form session or any kind a
     * way to retrieve locale.</p>
     *
     * @return String return value is string with default year pattern yyyy
     * @param date the date reference
     * @param locale Locale reference
     */
    public String getYearAsStringsWithActiveLocale(Date date, Locale locale) {
        return new SimpleDateFormat(yearPattern, locale).format(date);
    }

    /**
     * <p>
     * Get date only month and year and formated with default locale. The return
     * value is string with default month and year pattern (MMMM-yyyy)</p>
     *
     * <p>
     * The value of default locale, default month and year pattern are
     * configured in application.properties</p>
     *
     * @return String return value is string with default month and year pattern
     * MMMM-yyyy
     * @param date the date reference
     */
    public String getMonthAndYearAsStringsDefaultLocale(Date date) {
        return new SimpleDateFormat(monthAndYearPattern, new Locale(defaultLocale)).format(date);
    }

    /**
     * <p>
     * Get date only month and year and formated with specific locale. The
     * return value is string with default month and year pattern
     * (MMMM-yyyy)</p>
     *
     * <p>
     * The value of default month and year pattern are configured in
     * application.properties. We can inject locale form session or any kind a
     * way to retrieve locale.</p>
     *
     * @return String return value is string with default month and year pattern
     * MMMM-yyyy
     * @param date the date reference
     * @param locale Locale reference
     */
    public String getMonthAndYearAsStringsWithActiveLocale(Date date, Locale locale) {
        return new SimpleDateFormat(monthAndYearPattern, locale).format(date);
    }

    /**
     * <p>
     * Get date only day and month and formated with active locale, the return
     * value is String with default Day & Month pattern (dd-MMMM).</p>
     *
     * <p>
     * The value of day & month pattern are configured in
     * application.properties. We can inject locale form session or any kind a
     * way to retrieve locale.</p>
     *
     * @param locale locale reference
     * @return Date return value is Date with Month pattern dd-MMMM
     * @param date Date reference
     */
    public String getDayAndMonthAsStringsWithActiveLocale(Date date, Locale locale) {
        return new SimpleDateFormat(dayAndMonthPattern, locale).format(date);
    }

    /**
     * <p>
     * Get date only day and month and formated with active locale. The return
     * value is String with default Day & Month pattern (dd-MMMM).</p>
     *
     * <p>
     * The value of active locale and format for day & month pattern are
     * configured in application.properties</p>
     *
     * @return Date return value is Date with Month pattern dd-MMMM
     * @param date Date reference
     */
    public String getDayAndMonthAsStringsDefaultLocale(Date date) {
        return new SimpleDateFormat(dayAndMonthPattern, new Locale(defaultLocale)).format(date);
    }

    /**
     *
     * <p>
     * Get Date and formated with default locale. Return value is Date with
     * default date pattern (dd-MMMM-yyyy). This date pattern is taken from
     * application properties. For more detail please see
     * application.properties</p>
     * <p>
     * The Date format using default active locale.</p>
     *
     * @return String return value is string with pattern date dd-MMMM-yyyy
     * @param inputDate the date reference
     * @throws java.text.ParseException
     */
    public Date getDateDefaultLocale(String inputDate) throws ParseException {
        return new SimpleDateFormat(datePattern, new Locale(defaultLocale)).parse(inputDate);
    }

    /**
     *
     * <p>
     * Get Date and formated with specific locale. The return value is Date with
     * default date pattern (dd-MMMM-yyyy). We can inject locale form session or
     * any kind a way to retrieve locale </p>
     * <p>
     * The value of default locale and date format pattern are configured in
     * application.properties</p>
     *
     * @return String return value is string with pattern date dd-MMMM-yyyy
     * @param inputDate the String reference
     * @param locale Locale reference
     * @throws java.text.ParseException
     */
    public Date getDateWithActiveLocale(String inputDate, Locale locale) throws ParseException {
        return new SimpleDateFormat(datePattern, locale).parse(inputDate);
    }

    /**
     * <p>
     * Get Date and formated with default locale. The return value is Date with
     * default full pattern (dd-MMMM-yy|hh:mm a)
     * </p>
     * </p>The value of default locale and date format pattern are configured in
     * application.properties</p>
     *
     * @return the value is Date with default full date pattern dd-MMMM-yy|hh:mm
     * a
     * @param stringDate the String reference
     * @throws java.text.ParseException
     */
    public Date getDateFullDefaultLocale(String stringDate) throws ParseException {
        return new SimpleDateFormat(dateFullPattern, new Locale(defaultLocale)).parse(stringDate);
    }

    /**
     * <p>
     * Get Date and formated with specific locale. The return value is Date with
     * full date pattern (dd-MMMM-yy|hh:mm a).</p>
     *
     * <p>
     * The value of full date pattern are configured in
     * application.properties.We can inject locale form session or any kind a
     * way to retrieve locale.</p>
     *
     * @return Date return value is Date with pattern date dd-MMMM-yy|hh:mm a
     * @param stringDate String reference
     * @param locale Locale reference
     * @throws java.text.ParseException
     */
    public Date getDateFullWithActiveLocale(String stringDate, Locale locale) throws ParseException {
        return new SimpleDateFormat(dateFullPattern, locale).parse(stringDate);
    }

    /**
     * <p>
     * Get date only time and formated with default locale. The return value is
     * Date with default time pattern (hh:mm:ss)</p>
     *
     * <p>
     * The value of default locale and default time pattern are configured in
     * application.properties</p>
     *
     * @return String return value is string with default time pattern hh:mm:ss
     * @param stringDate the String reference
     * @throws java.text.ParseException
     */
    public Date getTimeDefaultLocale(String stringDate) throws ParseException {
        return new SimpleDateFormat(timePattern, new Locale(defaultLocale)).parse(stringDate);
    }

    /**
     * <p>
     * Get Time with specific locale, the return value is Date with default time
     * pattern (hh:mm:ss).</p>
     * <br/>
     * <p>
     * for value of default locale and format for Time pattern are configured in
     * application.properties</p>
     *
     * @return Date return value is Date with Time pattern hh:mm:ss
     * @param stringDate String reference
     * @param locale Locale reference
     * @throws java.text.ParseException
     */
    public Date getTimeWithActiveLocale(String stringDate, Locale locale) throws ParseException {
        return new SimpleDateFormat(timePattern, locale).parse(stringDate);
    }

    /**
     * <p>
     * Get Month with default locale, the return value is Date with default
     * month pattern (MMMM).</p>
     *
     * <p>
     * for value of default locale and format for month pattern are configured
     * in application.properties</p>
     *
     * @param stringDate
     * @return Date return value is Date with Month pattern MMMM
     * @throws java.text.ParseException
     */
    public Date getMonthDefaultLocale(String stringDate) throws ParseException {
        return new SimpleDateFormat(monthPattern, new Locale(defaultLocale)).parse(stringDate);
    }

    /**
     * <p>
     * Get date only month and formated with specific locale. The return value
     * is Date with default month pattern (MMMM)</p>
     * <p>
     * The value of default month pattern are configured in
     * application.properties. We can inject locale form session or any kind a
     * way to retrieve locale </p>
     *
     * @return String return value is string with default month pattern MMMM
     * @param stringDate the String reference
     * @param locale Locale reference
     * @throws java.text.ParseException
     */
    public Date getMonthWithActiveLocale(String stringDate, Locale locale) throws ParseException {
        return new SimpleDateFormat(monthPattern, locale).parse(stringDate);
    }

    /**
     * <p>
     * Get date only year and formated with default locale. The return value is
     * Date with default year pattern (yyyy)</p>
     * <
     * <p>
     * The value of default locale and default year pattern are configured in
     * application.properties</p>
     *
     * @return String return value is string with default year pattern yyyy
     * @param stringDate the date reference
     * @throws java.text.ParseException
     */
    public Date getYearDefaultLocale(String stringDate) throws ParseException {
        return new SimpleDateFormat(yearPattern, new Locale(defaultLocale)).parse(stringDate);
    }

    /**
     * <p>
     * Get date only year and formated with specific locale. The return value is
     * Date with default year pattern (yyyy)</p>
     *
     * <p>
     * The value of default year pattern are configured in
     * application.properties. We can inject locale form session or any kind a
     * way to retrieve locale.</p>
     *
     * @return String return value is string with default year pattern yyyy
     * @param stringDate the String reference
     * @param locale Locale reference
     * @throws java.text.ParseException
     */
    public Date getYearWithActiveLocale(String stringDate, Locale locale) throws ParseException {
        return new SimpleDateFormat(yearPattern, locale).parse(stringDate);
    }

    /**
     * <p>
     * Get date only month and year and formated with default locale. The return
     * Date is string with default month and year pattern (MMMM-yyyy)</p>
     *
     * <p>
     * The value of default locale, default month and year pattern are
     * configured in application.properties</p>
     *
     * @return String return value is string with default month and year pattern
     * MMMM-yyyy
     * @param stringDate the String reference
     * @throws java.text.ParseException
     */
    public Date getMonthAndYearDefaultLocale(String stringDate) throws ParseException {
        return new SimpleDateFormat(monthAndYearPattern, new Locale(defaultLocale)).parse(stringDate);
    }

    /**
     * <p>
     * Get date only month and year and formated with specific locale. The
     * return value is Date with default month and year pattern (MMMM-yyyy)</p>
     *
     * <p>
     * The value of default month and year pattern are configured in
     * application.properties. We can inject locale form session or any kind a
     * way to retrieve locale.</p>
     *
     * @return String return value is string with default month and year pattern
     * MMMM-yyyy
     * @param stringDate the String reference
     * @param locale Locale reference
     * @throws java.text.ParseException
     */
    public Date getMonthAndYearWithActiveLocale(String stringDate, Locale locale) throws ParseException {
        return new SimpleDateFormat(monthAndYearPattern, locale).parse(stringDate);
    }

    /**
     * <p>
     * Get date only day and month and formated with active locale. The return
     * value is Date with default Day & Month pattern (dd-MMMM).</p>
     *
     * <p>
     * The value of active locale and format for day & month pattern are
     * configured in application.properties</p>
     *
     * @return Date return value is Date with Month pattern dd-MMMM
     * @param stringDate String reference
     * @throws java.text.ParseException
     */
    public Date getDayAndMonthDefaultLocace(String stringDate) throws ParseException {
        return new SimpleDateFormat(dayAndMonthPattern, new Locale(defaultLocale)).parse(stringDate);
    }

    /**
     * <p>
     * Get date only day and month and formated with active locale, the return
     * value is Date with default Day & Month pattern (dd-MMMM).</p>
     *
     * <p>
     * The value of day & month pattern are configured in
     * application.properties. We can inject locale form session or any kind a
     * way to retrieve locale.</p>
     *
     * @param locale locale reference
     * @return Date return value is Date with Month pattern dd-MMMM
     * @param stringDate String reference
     * @throws java.text.ParseException
     */
    public Date getDayAndMonthWithActiveLocale(String stringDate, Locale locale) throws ParseException {
        return new SimpleDateFormat(dayAndMonthPattern, locale).parse(stringDate);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (defaultLocale.equalsIgnoreCase("") || defaultLocale == null) {
            throw new Exception("Mr. DHFR say :Property of defaultLocale can't be null."
                    + " Please see and config common_util.properties");
        }
        if (datePattern.equalsIgnoreCase("") || defaultLocale == null) {
            throw new Exception("Mr. DHFR saya :Property of datePattern can't be null. "
                    + "Please see and config common_util.properties");
        }
        if (timePattern.equalsIgnoreCase("") || defaultLocale == null) {
            throw new Exception("Mr. DHFR say :Property of timePattern can't be null."
                    + " Please see and config common_util.properties");
        }
        if (monthPattern.equalsIgnoreCase("") || defaultLocale == null) {
            throw new Exception("Mr. DHFR say :Property of monthPattern can't be null. "
                    + "Please see and config common_util.properties");
        }
        if (yearPattern.equalsIgnoreCase("") || defaultLocale == null) {
            throw new Exception("Mr. DHFR say :Property of yearPattern can't be null. "
                    + "Please see and config common_util.properties");
        }
        if (dayPattern.equalsIgnoreCase("") || defaultLocale == null) {
            throw new Exception("Mr. DHFR say :Property of dayPattern can't be null. "
                    + "Please see and config common_util.properties");
        }
        if (dateFullPattern.equalsIgnoreCase("") || defaultLocale == null) {
            throw new Exception("Mr. DHFR say :Property of dateFullPattern can't be null."
                    + " Please see and config common_util.properties");
        }
        if (monthAndYearPattern.equalsIgnoreCase("") || defaultLocale == null) {
            throw new Exception("Mr. DHFR say :Property of monthAndYearPattern can't be null. "
                    + "Please see and config common_util.properties");
        }
        if (dayAndMonthPattern.equalsIgnoreCase("") || defaultLocale == null) {
            throw new Exception("Mr. DHFR say :Property of dayAndMonthPattern can't be null. "
                    + "Please see and config common_util.properties");
        }
    }

    /**
     *
     * <p>
     * Get Date and formated with default locale. Return value is string with
     * default date pattern (dd-MMMM-yyyy). This date pattern is taken from
     * CommonUtilConstant.DEFAULT_DATE_PATTERN. This method is static so don't
     * managed by spring.
     * <p>
     * The Date format using default active locale.</p>
     *
     * @param datePattern
     * @return String return value is string with pattern date dd-MMMM-yyyy
     * @param date the date reference
     */
    public static String getDateAsStringsDefaultLocale(Date date, String datePattern) {
        return new SimpleDateFormat(datePattern, Locale.getDefault()).format(date);
    }

    /**
     *
     * <p>
     * Get Date and formated with default locale. Return value is Date with
     * default date pattern (dd-MMMM-yyyy). This date pattern is taken from
     * CommonUtilConstant.DEFAULT_DATE_PATTERN. This method is static so don't
     * managed by spring.
     * <p>
     * The Date format using default active locale.</p>
     *
     * @param datePattern
     * @return String return value is string with pattern date dd-MMMM-yyyy
     * @param inputDate the date reference
     * @throws java.text.ParseException
     */
    public static Date getDateWithDefaultLocale(String inputDate, String datePattern) throws ParseException {
        return new SimpleDateFormat(datePattern, Locale.getDefault()).parse(inputDate);
    }

    /**
     *
     * <p>
     * Get Date and formated with active locale. Return value is string with
     * default date pattern (dd-MMMM-yyyy). This date pattern is taken from
     * CommonUtilConstant.DEFAULT_DATE_PATTERN. This method is static so don't
     * managed by spring.
     * <p>
     * The Date format using active locale.</p>
     *
     * @param datePattern
     * @param locale
     * @return String return value is string with pattern date dd-MMMM-yyyy
     * @param date the date reference
     */
    public static String getDateAsStringActiveLocale(Date date, String datePattern, Locale locale) {
        return new SimpleDateFormat(datePattern, locale).format(date);
    }

    /**
     *
     * <p>
     * Get Date and formated with active locale. Return value is Date with
     * default date pattern (dd-MMMM-yyyy). This date pattern is taken from
     * CommonUtilConstant.DEFAULT_DATE_PATTERN. This method is static so don't
     * managed by spring.
     * <p>
     * The Date format using active locale.</p>
     *
     * @param date
     * @param datePattern
     * @param locale
     * @return String return value is string with pattern date dd-MMMM-yyyy
     * @throws java.text.ParseException
     */
    public static Date getDateWithActiveLocale(String date, String datePattern, Locale locale) throws ParseException {
        return new SimpleDateFormat(datePattern, locale).parse(date);
    }
}
