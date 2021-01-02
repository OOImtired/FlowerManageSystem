package com.qst.servlet;

import com.qst.bean.Flower;
import com.qst.bean.Page;
import com.qst.dao.PageDao;
import com.qst.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ClientServlet")
public class ClientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");

        if("page".equals(method)){
            page(request,response);
        }else if("pageByPrice".equals(method)){
            pageByPrice(request,response);
        }
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageDao pageDao = new PageDao();
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用PageDao.page(pageNo，pageSize)：Page对象
        Page<Flower> page = pageDao.page(pageNo, pageSize);
        page.setUrl("ClientServlet?method=page");
        //3 保存Page对象到Request域中
        request.setAttribute("page",page);
        //4 请求转发到pages/manager/flower_manager.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageDao pageDao = new PageDao();
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        /*double min2 = Double.parseDouble(req.getParameter("min"));
        double max2 = Double.parseDouble(req.getParameter("max"));*/
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Flower> page = pageDao.pageByPrice(pageNo,pageSize,min,max);

        StringBuilder sb = new StringBuilder("ClientServlet?method=pageByPrice");
        // 如果有最小价格的参数,追加到分页条的地址参数中
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        // 如果有最大价格的参数,追加到分页条的地址参数中
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
