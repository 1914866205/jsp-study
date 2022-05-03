package com.example.jspstudy;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/4/30 12:54
 * @Version 1.0
 **/
@WebFilter(filterName = "myFilter",urlPatterns = "/success.jsp")
public class MyFilter implements Filter {
    public MyFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String username = request.getParameter("username");
        if (username != null) {
            chain.doFilter(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/loginform.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}