package com.example.effectivejava1.chapter9.suppress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {

    // try ~ finally는 한 가지 에러만 보여준다. (에러가 2개가 발생해도)
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BadBufferReader(new FileReader(path));
        try {
            return br.readLine();
        }finally {
            br.close();
        }
    }

    static String firstLineOfFileWithResources(String path) throws IOException {
        try(BufferedReader br = new BadBufferReader(new FileReader(path));) {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(firstLineOfFile("build.gradle"));
        System.out.println(firstLineOfFileWithResources("build.gradle"));
    }
}
