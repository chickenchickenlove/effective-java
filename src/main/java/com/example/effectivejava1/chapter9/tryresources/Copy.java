package com.example.effectivejava1.chapter9.tryresources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

    private static final int BUFFER_SIZE = 8 * 1024;

    // 코드 9-3 : try-with-resources - 자원을 회수하는 최선책! (p48)
    static void copy(String src, String dst) throws IOException {
        try (FileInputStream in = new FileInputStream(src);
            FileOutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }
}
