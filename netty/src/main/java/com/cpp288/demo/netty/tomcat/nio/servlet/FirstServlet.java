package com.cpp288.demo.netty.tomcat.nio.servlet;

import com.cpp288.demo.netty.tomcat.nio.http.CppRequest;
import com.cpp288.demo.netty.tomcat.nio.http.CppResponse;
import com.cpp288.demo.netty.tomcat.nio.http.CppServlet;

/**
 * first servlet
 *
 * @author chenjian
 * @date 2021/1/11 下午5:10
 */
public class FirstServlet extends CppServlet {

    public void doGet(CppRequest request, CppResponse response) throws Exception {
        this.doPost(request,response);
    }

    public void doPost(CppRequest request, CppResponse response) throws Exception {
        response.write("This is first servlet from BIO.");
    }
}
