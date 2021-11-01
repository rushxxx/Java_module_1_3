package com.rush_xxx.repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class io {

    private static String pathToFile = "/src/main/resources/";
    private static String data;

    protected static String readData(String filename){

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(GetPath(filename)), StandardCharsets.UTF_8))) {
            data = reader.readLine();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                data.add(line);
//            }
        } catch (IOException e) {
            // log error
            System.out.println(e.getMessage());
        }

        return data;
    }
    protected static void writeData(String fileName, String data){

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(GetPath(fileName)))) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String GetPath(String filename)
    {
        Path currentAbsolutePath = Paths.get("").toAbsolutePath();
        String path = currentAbsolutePath + pathToFile + filename;
        return path;
    }
}