/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.common.util;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *<p> FilesUtil is class utility for file and folder management</p>
 * 
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 30 January 2014
 *
 */
public class FilesUtil {

    /**
     * Returns a human-readable version of the file size, where the input
     * represents a specific number of BigInteger type.
     *
     * @return String
     * @param byteSize BigInteger
     */
    public static String getHumanReadableSize(BigInteger byteSize) {
        return FileUtils.byteCountToDisplaySize(byteSize);
    }

    /**
     * Returns a human-readable version of the file size, where the input
     * represents a specific number of Long.
     *
     * @return String
     * @param byteSize Long
     */
    public static String getHumanReadableSize(Long byteSize) {
        return FileUtils.byteCountToDisplaySize(byteSize);
    }

    /**
     * Reads the contents of a file line by line to a List of Strings.
     *
     * @return List<String> List of String
     * @param file File
     * @throws java.io.IOException
     */
    public static List<String> getAsListStringFromFile(File file) throws IOException {
        return FileUtils.readLines(file);
    }

    /**
     * Reads the contents of a file into a String.
     *
     * @param file is  Object of File 
     * @return String contents of file
     * @throws java.io.IOException
     *
     */
    public static String getAsStringFromFile(File file) throws IOException {
        return FileUtils.readFileToString(file);
    }

    /**
     * Reads the contents of a file into a byte array
     *
     * @return byte[] contents of file in byte array
     * @param file is Object of File
     * @throws java.io.IOException
     *
     */
    public static byte[] getAsByteFromFile(File file) throws IOException {
        return FileUtils.readFileToByteArray(file);
    }

    /**
     * Writes a String to a file creating the file if it does not exist
     * @param file is object of File
     * @param data string that want to write to the file
     * @throws java.io.IOException
     *
     */
    public static void writeToFileFromString(File file, String data) throws IOException {
        FileUtils.writeStringToFile(file, data);
    }

    /**
     * Writes the toString() value of each item in a collection to the specified
     * File line by line
     *
     * @param file is object of File
     * @param data the lines to write, null entries produce blank lines
     * @throws java.io.IOException
     */
    public static void writeToFileFromCollection(File file, Collection<?> data) throws IOException {
        FileUtils.writeLines(file, data);
    }

    /**
     * Returns the size of the specified file or directory.
     *
     * @return Long size of file or directory
     * @param file the regular file or directory to return the size of
     */
    public static Long getFileSize(File file) {
        return FileUtils.sizeOf(file);
    }

    /**
     * Counts the size of a directory recursively (sum of the length of all
     * files)
     *
     * @return Long size of directory
     * @param directory is File object,a directory to inspect
     */
    public static Long getDirectorySize(File directory) {
        return FileUtils.sizeOfDirectory(directory);
    }

    /**
     * Copies a file to a new location.
     *
     * 
     * @param source source path
     * @param destination destination path to be copied
     * @throws java.io.IOException
     */
    public static void copyFileToFile(File source, File destination) throws IOException {
        FileUtils.copyFile(source, destination);
    }

    /**
     * Copies a file to a directory optionally preserving the file date.
     *
     * @param sourceFile
     * @param dirDestination destination path to be copied
     * @throws java.io.IOException
     */
    public static void copyFileToDirectory(File sourceFile, File dirDestination) throws IOException {
        FileUtils.copyFileToDirectory(sourceFile, dirDestination);
    }

    /**
     * Deletes a file. Warning!!!! If file is a directory, delete it and all
     * sub-directories.
     * 
     * @param file file or directory to delete, must not be null
     * @throws java.io.IOException
     */
    public static void deleteFile(File file) throws IOException {
        FileUtils.forceDelete(file);

    }

    /**
     * Moves a file from source destination to other destination
     *
     * @param source source path
     * @param destiantion destination path to be moved
     * @throws java.io.IOException
     */
    public static void moveFile(File source, File destiantion) throws IOException {
        FileUtils.moveFile(source, destiantion);
    }

}
