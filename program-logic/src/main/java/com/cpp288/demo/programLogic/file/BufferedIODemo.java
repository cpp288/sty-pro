package com.cpp288.demo.programLogic.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * buffered io demo
 *
 * @author chenjian
 * @date 2020/11/26 下午7:09
 */
public class BufferedIODemo {

    private static void read() {

        try (final InputStream input = new BufferedInputStream(new FileInputStream("hello.txt"))) {
            byte[] buff = new byte[1024];
            while (input.read(buff) != -1) {
                System.out.print(new String(buff));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        read();
    }
}
