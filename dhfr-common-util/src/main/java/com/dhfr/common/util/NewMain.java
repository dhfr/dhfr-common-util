/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.common.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import javafx.scene.chart.PieChart;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author deni.fahri
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
//
//        File file1 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\JSON_Ek\\Surabaya\\Page1.txt");
//        File file2 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\JSON_Ek\\Surabaya\\Page2.txt");
////        File file3 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\json\\json\\menado\\page3.txt");
//        File file3 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\JSON_Ek\\Surabaya\\Page3.txt");
//        File file4 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\JSON_Ek\\Surabaya\\Page4.txt");
//        File file5 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\JSON_Ek\\Surabaya\\Page5.txt");
//        File file6 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\JSON_Ek\\Surabaya\\Page6.txt");
////        File file7 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\Bandung\\Bandung\\Page 7.txt");
////        File file8 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\Bandung\\Bandung\\Page 8.txt");
////        File file9 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\Bandung\\Bandung\\Page 9.txt");
////        File file10 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\Bandung\\Bandung\\Page 10.txt");
////        File file11 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\Bandung\\Bandung\\Page 11.txt");
////        File file12 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\Bandung\\Bandung\\Page 12.txt");
////        File file13 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\Bandung\\Bandung\\Page 13.txt");
////        File file14 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\Bandung\\Bandung\\Page 14.txt");
////        File file15 = new File("C:\\Users\\deni.fahri\\AppData\\Roaming\\Skype\\My Skype Received Files\\Bandung\\Bandung\\Page 15.txt");
////        File file16 = new File("C:\\Users\\deni.fahri\\Downloads\\page16.txt");
//
////        File file2 = new File("C:\\Users\\deni.fahri\\Documents\\hasil.txt");
//        String agoda = FilesUtil.getAsStringFromFile(file1);
//        String agoda1 = FilesUtil.getAsStringFromFile(file2);
//        String agoda2 = FilesUtil.getAsStringFromFile(file3);
//        String agoda3 = FilesUtil.getAsStringFromFile(file4);
//        String agoda4 = FilesUtil.getAsStringFromFile(file5);
//        String agoda5 = FilesUtil.getAsStringFromFile(file6);
////        String agoda6 = FilesUtil.getAsStringFromFile(file7);
////        String agoda7 = FilesUtil.getAsStringFromFile(file8);
////        String agoda8 = FilesUtil.getAsStringFromFile(file9);
////        String agoda9 = FilesUtil.getAsStringFromFile(file10);
////        String agoda10 = FilesUtil.getAsStringFromFile(file11);
////        String agoda11 = FilesUtil.getAsStringFromFile(file12);
////        String agoda12 = FilesUtil.getAsStringFromFile(file13);
////        String agoda13 = FilesUtil.getAsStringFromFile(file14);
////        String agoda14 = FilesUtil.getAsStringFromFile(file15);
////        String agoda15 = FilesUtil.getAsStringFromFile(file16);
//////        System.out.println(" Test Nya adalah :" + agoda);
//////        String a=StringUtils.substringAfter("\"HotelTranslatedName\":", agoda);
//////        System.out.println(" hasil; "+a);
//////        // TODO code application logic here
//////        System.out.println("Nilai " + JsonConverter.getValueByKeyStatic(agoda, "HotelTranslatedName"));
//        TypeToken<List<HotelModel>> token = new TypeToken<List<HotelModel>>() {
//        };
//        Gson gson = new GsonBuilder().create();
////        List<HotelModel> data = new ArrayList<>();
////        HotelModel hotelModel = new HotelModel();
////        hotelModel.setAddress("sdfsdffsfsdfsdfdsfdsf");
////        hotelModel.setAccommodationName("Aku");
////        HotelModel hotelModel1 = new HotelModel();
////        hotelModel1.setAddress("sdfsdffsfsdfsdfdsfdsf");
////        hotelModel1.setAccommodationName("Avvvku");
////        HotelModel hotelModel2 = new HotelModel();
////        hotelModel2.setAddress("sdfsdffsfsdfsdfdsfdsf");
////        hotelModel2.setAccommodationName("Akvvvu");
////        data.add(hotelModel);
////        data.add(hotelModel1);
////        data.add(hotelModel2);
////        String json = gson.toJson(data);
//        List<HotelModel> total = new ArrayList<>();
//        List<HotelModel> data1 = new ArrayList<>();
//        List<HotelModel> data2 = new ArrayList<>();
//        List<HotelModel> data3 = new ArrayList<>();
//        List<HotelModel> data4 = new ArrayList<>();
//        List<HotelModel> data5 = new ArrayList<>();
//        List<HotelModel> data6 = new ArrayList<>();
//        List<HotelModel> data7 = new ArrayList<>();
//        List<HotelModel> data8 = new ArrayList<>();
//        List<HotelModel> data9 = new ArrayList<>();
//        List<HotelModel> data10 = new ArrayList<>();
//        List<HotelModel> data11 = new ArrayList<>();
//        List<HotelModel> data12 = new ArrayList<>();
//        List<HotelModel> data13 = new ArrayList<>();
//        List<HotelModel> data14 = new ArrayList<>();
//        List<HotelModel> data15 = new ArrayList<>();
//        List<HotelModel> data16 = new ArrayList<>();
//
//        data1 = gson.fromJson(agoda, token.getType());
//        data2 = gson.fromJson(agoda1, token.getType());
//        data3 = gson.fromJson(agoda2, token.getType());
//        data4 = gson.fromJson(agoda3, token.getType());
//        data5 = gson.fromJson(agoda4, token.getType());
//        data6 = gson.fromJson(agoda5, token.getType());
////        data7 = gson.fromJson(agoda6, token.getType());
////        data8 = gson.fromJson(agoda7, token.getType());
////        data9 = gson.fromJson(agoda8, token.getType());
////        data10 = gson.fromJson(agoda9, token.getType());
////        data11 = gson.fromJson(agoda10, token.getType());
////        data12 = gson.fromJson(agoda11, token.getType());
////        data13 = gson.fromJson(agoda12, token.getType());
////        data14 = gson.fromJson(agoda13, token.getType());
////        data15 = gson.fromJson(agoda14, token.getType());
////        data16 = gson.fromJson(agoda15, token.getType());
//        total.addAll(data1);
//        total.addAll(data2);
//        total.addAll(data3);
//        total.addAll(data4);
//        total.addAll(data5);
//        total.addAll(data6);
////        total.addAll(data7);
////        total.addAll(data8);
////        total.addAll(data9);
////        total.addAll(data10);
////        total.addAll(data11);
////        total.addAll(data12);
////        total.addAll(data13);
////        total.addAll(data14);
////        total.addAll(data15);
////        total.addAll(data16);
//        System.out.println(" Ukurannn nya " + total.size());
//
////        System.out.println(" Ukurannya " + data2.size());
//        for (HotelModel mode : total) {
//            System.out.println(mode);
//        }
////        HotelModel hotelModel = gson.fromJson(agoda, HotelModel.class);
////        String Data = hotelModel.getHotelTranslatedName() + ";" + hotelModel.getStarRating() + ";" + hotelModel.getAddress() + ";" + hotelModel.getIsFreeWifi();
////        FilesUtil.writeToFileFromString(file2, Data);
////        System.out.println(hotelModel);
////
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("Agoda Data Hotel Surabaya");
//
//////
//        TreeMap<String, Object[]> datatoExel = new TreeMap<>();
//        int i = 1;
////        datatoExel.put("1", new Object[]{"Hotel Agoda Jakarta"});
//        datatoExel.put("1", new Object[]{"Nama Hotel", "Arena", "Alamat", "Rating", "Apakah Gratis Wifi", "Harga Mulai Dari", "Longitude", "Latitude"});
//        for (HotelModel mode : total) {
//            datatoExel.put(String.valueOf(i + 1), new Object[]{mode.getHotelTranslatedName(), mode.getAreaName(), mode.getAddress(), mode.getStarRating(), mode.getIsFreeWifi(), mode.getTextPrice() + " " + mode.getCurrencyCode(), mode.getCoordinate().getLongitude(), mode.getCoordinate().getLatitude()});
//            i++;
//        }
////
//////          int i=1;
//////        for (HotelModel mode : data2) {
//////             datatoExel.put(String.valueOf(i), new Object[]{1d, "John", 1500000d});
////////        }
//////       
//////        datatoExel.put("4", new Object[]{3d, "Dean", 700000d});
//////
//        Set<String> keyset = datatoExel.keySet();
//        int rownum = 0;
//        for (String key : keyset) {
//            Row row = sheet.createRow(rownum++);
//            Object[] objArr = datatoExel.get(key);
//            int cellnum = 0;
//            for (Object obj : objArr) {
//                Cell cell = row.createCell(cellnum++);
//                if (obj instanceof Date) {
//                    cell.setCellValue((Date) obj);
//                } else if (obj instanceof Boolean) {
//                    cell.setCellValue((Boolean) obj);
//                } else if (obj instanceof String) {
//                    cell.setCellValue((String) obj);
//                } else if (obj instanceof Double) {
//                    cell.setCellValue((Double) obj);
//                }
//            }
//        }
//
//        try {
//            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\deni.fahri\\Documents\\Surabaya.xls"));
//            workbook.write(out);
//            out.close();
//            System.out.println("Excel written successfully..");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
        Date now = new Date();
        Date tnggl = new SimpleDateFormat("dd MM yyyy").parse("10 10 1999");
        System.out.println(" tanggalnya " + DateTimeUtil.getTotalYearDifference(tnggl, now));
    }
}
