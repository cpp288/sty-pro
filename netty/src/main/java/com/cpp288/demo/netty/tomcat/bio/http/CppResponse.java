package com.cpp288.demo.netty.tomcat.bio.http;

import java.io.OutputStream;

/**
 * response
 *
 * @author chenjian
 * @date 2021/1/11 上午10:43
 */
public class CppResponse {

    private OutputStream out;

    public CppResponse(OutputStream os) {
        this.out = os;
    }

    public void write(String s) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 ok\n")
                .append("Content-Type: text/html;\n")
                .append("\r\n")
                .append(s);
        out.write(sb.toString().getBytes());
    }
}
