package com.example.effectivejava1.chapter24.adapter;

import java.io.*;

public class AdapterInJava {

    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("number.txt")) {
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
