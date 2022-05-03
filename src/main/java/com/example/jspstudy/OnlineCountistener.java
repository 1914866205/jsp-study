package com.example.jspstudy;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;
import java.util.Set;

/**
 * @ClassName MyServletContextListenerImpl
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/4/30 12:58
 * @Version 1.0
 **/
//@WebListener
public class OnlineCountistener implements HttpSessionListener {
    //创建session监听
    //一旦创建session就会触发一次这个事件
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        System.out.println(se.getSession().getId());
        Integer onlineCount = (Integer) context.getAttribute("OnlineCount");
        System.out.println("onlineCount:" + onlineCount);
        if (onlineCount == null) {
            onlineCount = new Integer(1);
        } else {
            onlineCount = new Integer(onlineCount + 1);
        }
        context.setAttribute("OnlineCount", onlineCount);
    }

    //销毁session监听
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        System.out.println(se.getSession().getId());
        Integer onlineCount = (Integer) context.getAttribute("OnlineCount");
        System.out.println("onlineCount:" + onlineCount);
        onlineCount = new Integer(onlineCount - 1);
        context.setAttribute("OnlineCount", onlineCount);
    }

}
