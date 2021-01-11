package com.cpp288.demo.netty.tomcat.nio.servlet;

import com.cpp288.demo.netty.tomcat.nio.http.CppRequest;
import com.cpp288.demo.netty.tomcat.nio.http.CppResponse;
import com.cpp288.demo.netty.tomcat.nio.http.CppServlet;

/**
 * second servlet
 *
 * @author chenjian
 * @date 2021/1/11 下午5:11
 */
public class SecondServlet extends CppServlet {

    public void doGet(CppRequest request, CppResponse response) throws Exception {
        this.doPost(request,response);
    }

    public void doPost(CppRequest request, CppResponse response) throws Exception {
        response.write("This is second servlet from BIO.");
    }
}
