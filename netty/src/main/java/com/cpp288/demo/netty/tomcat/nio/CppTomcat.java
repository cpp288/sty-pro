package com.cpp288.demo.netty.tomcat.nio;

import com.cpp288.demo.netty.tomcat.nio.http.CppRequest;
import com.cpp288.demo.netty.tomcat.nio.http.CppResponse;
import com.cpp288.demo.netty.tomcat.nio.http.CppServlet;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.io.FileInputStream;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * tomcat
 *
 * @author chenjian
 * @date 2021/1/11 上午10:43
 */
public class CppTomcat {

    private int port = 8080;

    private ServerSocket server;

    private Properties webxml = new Properties();

    private Map<String, CppServlet> servletMapping = new HashMap<String, CppServlet>();

    public static void main(String[] args) {
        new CppTomcat().start();
    }

    //Tomcat的启动入口
    private void start() {
        //1、加载web.properties文件，解析配置
        init();

        //Boss线程
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //Worker线程
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        //2、创建Netty服务端对象
        ServerBootstrap server = new ServerBootstrap();

        try {
            //3、配置服务端参数
            server.group(bossGroup, workerGroup)
                    //配置主线程的处理逻辑
                    .channel(NioServerSocketChannel.class)
                    //子线程的回调处理，Handler
                    .childHandler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel client) throws Exception {
                            //处理回调的逻辑

                            //链式编程，责任链模式

                            //处理响应结果的封装
                            client.pipeline().addLast(new HttpResponseEncoder());
                            //用户请求过来，要解码
                            client.pipeline().addLast(new HttpRequestDecoder());
                            //用户自己的业务逻辑
                            client.pipeline().addLast(new GPTomcatHandler());

                        }
                    })
                    //配置主线程分配的最大线程数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //保持长连接
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            //启动服务
            ChannelFuture f = server.bind(this.port).sync();

            System.out.println("Tomcat 已启动，监听端口是: " + this.port);

            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }


    private void init() {
        try {
            String WEB_INF = this.getClass().getResource("/").getPath();
            FileInputStream fis = new FileInputStream(WEB_INF + "web-nio.properties");

            webxml.load(fis);

            for (Object k : webxml.keySet()) {

                String key = k.toString();

                if (key.endsWith(".url")) {

                    //将 servlet.xxx.url 的 .url 替换，只剩下 servlet.xxx当成  servletName
                    String servletName = key.replaceAll("\\.url$", "");
                    String url = webxml.getProperty(key);

                    //拿到Serlvet的全类名
                    String className = webxml.getProperty(servletName + ".className");

                    //反射创建Servlet的实例
                    CppServlet obj = (CppServlet) Class.forName(className).newInstance();
                    //将URL和Servlet建立映射关系
                    servletMapping.put(url, obj);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class GPTomcatHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

            if (msg instanceof HttpRequest) {
                HttpRequest req = (HttpRequest) msg;

                CppRequest request = new CppRequest(ctx, req);
                CppResponse response = new CppResponse(ctx, req);

                String url = request.getUrl();

                if (servletMapping.containsKey(url)) {
                    servletMapping.get(url).service(request, response);
                } else {
                    response.write("404 - Not Found!!");
                }
            }
        }
    }
}
