package com.itheima.web;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ServletDemo2 implements Servlet {//原始的Servlet需要继承Servlet接口, 并实现这个接口下的所有方法
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //根据请求方式的不同分别处理, 也需要将ServletRequest请求转换为HttpServlet请求, 所以需要使用强制类型转换的方式实现
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //1. 获取请求方式
        String method = request.getMethod();
        //2. 判断是GET请求还是POST请求, 通过不同的逻辑代码实现
        if ("GET".equals(method)){
            //get请求方式的处理逻辑
        }else if ("POST".equals((method))){
            //post请求的处理逻辑
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
