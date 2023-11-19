package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo",loadOnStartup = 1)/*在WebServlet注解中, 默认情况下, 使用value属性和urlPatterns属性实现的功能一样*/
public class ServletDemo implements Servlet {
    /**
     * 初始化方法
     * 1. 调用时机: 默认情况下, 第一次访问Servlet的时候被调用, 因为那时候创建Servlet对象, 需要对对象进行初始化
     *      * loadOnStartup: 当配置为0或者正整数会在服务器启动时(相对的创建的更早,对于较长等待的情况下对用户更加友好), 创建Servlet的对象, 数字越小优先级越高; 但是当配置为负整数时: 会在第一次访问Servlet的时候创建Servlet对象
     *      * 默认情况下就是配置的负整数, 在第一次访问的时候创建Servlet对象, 当需要修改为服务器启动时创建Servlet对象时, 需要在注解中配置loadOnStartup属性, 使用value=xx补全
     * 2. 调用次数: 一次
     * 也就是说在第一次访问Servlet的时候, 会创建Servlet对象, 并且调用init方法, 以后再访问Servlet的时候, 不会再创建Servlet对象, 只会调用service方法
     * 在打开web服务器后访问@WebServlet注解的路径, 当路径第一次访问时会调用init()无论怎样刷新都不会在影响, 直到关闭服务器, 会释放在init时创建的资源
     * @param servletConfig
     * @throws ServletException
     */
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("init方法被调用");
    }

    /**
    *service方法在Servlet被访问的时候会自动执行
    * 提供服务
    * 1. 调用时机: 每次Servlet被访问时, 调用
    * 2. 调用次数: 多次, 因为在每次访问时相当于刷新在WebServlet中注解的路径
    */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("ServletDemo.service方法被调用了");
    }

    /**
     * 销毁方法:
     * 1. 调用时机: 在内存释放或者服务器关闭的时候, Servlet对象会被销毁 ,调用释放资源
     * 2. 调用次数: 一次
     */
    @Override
    public void destroy() {
        System.out.println("调用destroy()方法销毁释放资源");/*只能通过ctrl+c或者在插件的使用中通过mvn tomcat7:run开始运行    mvn tomcat7:stop*/
    }

    /**
     * 可以通过定义成员变量的方式将不同的函数中的参数进行传递, 使得在不同的作用域或全局环境下都能被访问
     */
    @Override
    public ServletConfig getServletConfig() {
//        return null;
        return servletConfig;
    }


    /**
     * 返回一些信息: 如作者版权等, 一般情况下返回null或者空字符串""
     */
    @Override
    public String getServletInfo() {
        return null;
    }

}
