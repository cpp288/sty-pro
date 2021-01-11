package com.cpp288.demo.netty.tomcat.nio.http;

/**
 * servlet
 *
 * @author chenjian
 * @date 2021/1/11 上午10:43
 */
public abstract class CppServlet {

    public void service(CppRequest request, CppResponse response) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    public abstract void doGet(CppRequest request, CppResponse response) throws Exception;

    public abstract void doPost(CppRequest request, CppResponse response) throws Exception;
}
