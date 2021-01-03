package com.qst.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "ManagerFilter")
public class ManagerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /**
        * @描述:过滤用户和管理员身份
        * @参数注释:
        * @param: req
         * @param: resp
         * @param: chain
        * @返回值:void
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;

        Object user = httpServletRequest.getSession().getAttribute("user");

        if(user==null){
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
