package com.example.effectivejava1.chapter9.javapuzzler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopySafe {
    private static final int BUFFER_SIZE = 8 * 1024;

    // 코드 9-2 자원이 둘 이상이면 try-finally 방식은 너무 지저분하다! (47쪽)
    static void copy(String src, String dst) throws IOException {
        FileInputStream in = new FileInputStream(src);
        try {
            FileOutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            }finally {
                out.close();
            }
        }finally {
            in.close();
        }
    }
}
