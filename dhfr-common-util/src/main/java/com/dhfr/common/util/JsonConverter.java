/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.InitializingBean;

/**
 * <p>
 * JsonConverter is class utility for generate json from java object and parsing
 * json to java object.</p>
 * <p>
 * This class managed by spring. Spring inject the jsonPatternDateFormat. </p>
 * <p>
 * Note: every class consume JsonConverter must have same date pattern
 * format.</p>
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 19 January 2014
 *
 */
public class JsonConverter implements InitializingBean {

    private String jsonPatternDateFormat;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (jsonPatternDateFormat.equalsIgnoreCase("") || jsonPatternDateFormat == null) {
            throw new Exception("Mr. DHFR say :Property of jsonPatternDateFormat can't be null."
                    + " Please see and config spring config xml or common_util.properties");
        }
    }

    public void setJsonPatternDateFormat(String jsonPatternDateFormat) {
        this.jsonPatternDateFormat = jsonPatternDateFormat;
    }

    /*
     * @return String in json format
     * @param object is all java Object ecspecialy  pojo or javabeans.
     * This object will convert to json.
     */
    public String getJson(Object object) {
        Gson gson = new GsonBuilder().setDateFormat(jsonPatternDateFormat).create();
        return gson.toJson(object).toString();
    }
    /*
     * This method is static method so don't managed by spring
     * @return String in json format 
     * @param object is all java Object ecspecialy  pojo or javabeans.
     * This object will convert to json.
     */

    public static String getJson(Object object, String jsonPatternDateFormat) {
        Gson gson = new GsonBuilder().setDateFormat(jsonPatternDateFormat).create();
        return gson.toJson(object).toString();
    }

    /*
     * @return String value of json base on keyName parameter.
     * @param jsonMsg is json formate
     * @param keyName is key paremeter that we will get value within
     */
    public String getValueByKey(String jsonMsg, String keyName) {
        JsonElement jelement = new JsonParser().parse(jsonMsg);
        JsonObject jobject = jelement.getAsJsonObject();
        return jobject.get(keyName).getAsString();
    }
    /*
     * @return String value of json base on keyName parameter.
     * @param jsonMsg is json formate
     * @param keyName is key paremeter that we will get value within
     */

    public static String getValueByKeyStatic(String jsonMsg, String keyName) {
        JsonElement jsonElemet = new JsonParser().parse(jsonMsg);
        JsonObject jobject = jsonElemet.getAsJsonObject();
        return jobject.get(keyName).getAsString();
    }
    /*
     * @return Object of class java from json messages on keyName parameter.
     * @param jsonMsg is json formate
     * @param keyName is key paremeter that we will get value within
     */

    public Object getClassFromJson(String jsonMsg, Class clazz) {
        Gson gson = new GsonBuilder().setDateFormat(jsonPatternDateFormat).create();
        return gson.fromJson(jsonMsg, clazz);
    }
    /*
     * @return Object of class java from json messages on keyName parameter.
     * @param jsonMsg is json formate
     * @param keyName is key paremeter that we will get value within
     * see CommonUtilConstant.JSON_PATTERN_DATE_FORMAT
     */

    public static Object getClassFromJson(String jsonMsg, Class clazz, String jsonPatternDateFormat) {
        Gson gson = new GsonBuilder().setDateFormat(jsonPatternDateFormat).create();
        return gson.fromJson(jsonMsg, clazz);
    }

}
