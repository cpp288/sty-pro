package com.cpp288.demo.programLogic.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * File IO Demo
 *
 * @author chenjian
 * @date 2020/11/26 下午4:28
 */
public class FileIODemo {

    /**
     * 写文件
     */
    private static void writeFile() {
        try (FileOutputStream output = new FileOutputStream("hello.txt", true)) {
            String data = "hello,陈";
            byte[] bytes = data.getBytes(Charset.defaultCharset());
            output.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读文件
     */
    private static void readFile() {
        try (FileInputStream input = new FileInputStream("hello.txt")){
            // 这里固定了字节数组大小，在不确定文件大小的情况下，这样实现是不好的
            byte[] buf = new byte[1024];
            int off = 0;
            int bytesRead = 0;

            while ((bytesRead = input.read(buf, off, 1024 - off)) != -1) {
                off += bytesRead;
            }
            String data = new String(buf, 0, off, StandardCharsets.UTF_8);
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        writeFile();
        readFile();
    }
}
