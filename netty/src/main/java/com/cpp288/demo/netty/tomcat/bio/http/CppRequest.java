package com.cpp288.demo.netty.tomcat.bio.http;

import java.io.InputStream;

/**
 * request body
 *
 * @author chenjian
 * @date 2021/1/11 上午10:43
 */
public class CppRequest {

    private String method;
    private String url;

    public CppRequest(InputStream is) {

        try {
            // 拿到HTTP协议的具体内容
            String content = "";
            byte[] buff = new byte[1024];
            int len = 0;
            if ((len = is.read(buff)) > 0) {
                content = new String(buff, 0, len);
            }

            String line = content.split("\\n")[0];
            String[] arr = line.split("\\s");

            this.method = arr[0];
            this.url = arr[1].split("\\?")[0];
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
