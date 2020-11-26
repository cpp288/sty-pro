package com.cpp288.demo.programLogic.file;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Byte Array IO demo
 *
 * @author chenjian
 * @date 2020/11/26 下午4:48
 */
public class ByteArrayIODemo {

    private static void read() {

        try (final FileInputStream input = new FileInputStream("hello.txt");
             final ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            final byte[] buf = new byte[1024];
            int bytesRead = 0;
            // 读入的数据先写入 ByteArrayOutputStream 中，在通过toString方法获取完整的数据
            while ((bytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, bytesRead);
            }
            // ByteArrayOutputStream 输出目标是一个byte数组，这个数组的长度是根据数据内容动态扩展的
            final String data = output.toString("UTF-8");
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        read();
    }
}
