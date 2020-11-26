package com.cpp288.demo.programLogic.io;

import java.io.*;

/**
 * stream read writer demo
 *
 * @author chenjian
 * @date 2020/11/26 下午7:28
 */
public class StreamReadWriterDemo {

    private static void inputStreamReader() {
        try (final Reader reader = new InputStreamReader(new FileInputStream("hello.txt"))) {
            final char[] cbuf = new char[10];
            int charsRead = reader.read(cbuf);
            System.out.println(new String(cbuf, 0, charsRead));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void charArrayReader() {
        try (final Reader reader = new InputStreamReader(new FileInputStream("hello.txt"));
                CharArrayWriter writer = new CharArrayWriter()) {
            final char[] cbuf = new char[1024];
            int charsRead;

            while ((charsRead = reader.read(cbuf)) != -1) {
                writer.write(cbuf, 0, charsRead);
            }

            System.out.println(writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        inputStreamReader();
//        charArrayReader();
    }
}
