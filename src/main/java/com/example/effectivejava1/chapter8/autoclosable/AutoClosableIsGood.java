package com.example.effectivejava1.chapter8.autoclosable;

import java.io.BufferedInputStream;
import java.io.IOException;

public class AutoClosableIsGood implements AutoCloseable{
    private BufferedInputStream inputStream;

    // 1번 방법
    /*@Override
    public void close() throws IOException {
        inputStream.close();
    }*/

    // 2번 방법
    @Override
    public void close()  {
        try {
            inputStream.close();
        } catch (IOException e) {
            // e.printStackTrace();
            throw new RuntimeException("failed to close " + inputStream);
        }
    }
}

