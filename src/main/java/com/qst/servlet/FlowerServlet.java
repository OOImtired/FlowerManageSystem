package com.qst.servlet;

import com.qst.bean.Flower;
import com.qst.bean.Page;
import com.qst.dao.FlowerDao;
import com.qst.dao.PageDao;
import com.qst.utils.WebUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/FlowerServlet")
public class FlowerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");

        if("queryFlower".equals(method)){
            FlowerDao flowerDao = new FlowerDao();
            List<Flower> flowerList = flowerDao.queryFlower();
            request.setAttribute("flowerList",flowerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/manager/flower_manager.jsp");
            dispatcher.forward(request,response);
        } else if ("addFlower".equals(method)){
            int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 0);
            pageNo+=1;
            Flower flower = requestDataObj(request);
            FlowerDao flowerDao =new FlowerDao();
            flowerDao.addFlower(flower);
            request.setAttribute("flower",flower);
            response.sendRedirect(request.getContextPath()+"/FlowerServlet?method=page&pagNo="+pageNo);
        } else if ("deleteFlower".equals(method)){
            FlowerDao flowerDao = new FlowerDao();
            Integer id = Integer.valueOf(request.getParameter("id") );
            flowerDao.deleteFlower(id);
            response.sendRedirect(request.getContextPath()+"/FlowerServlet?method=page&pageNo="+request.getParameter("pageNo"));
        } else if("getFlower".equals(method)){
            FlowerDao flowerDao = new FlowerDao();
            Integer id =Integer.valueOf(request.getParameter("id"));
            Flower flower = flowerDao.queryFlowerById(id);
            request.setAttribute("flower",flower);
            request.getRequestDispatcher("/pages/manager/flower_update.jsp").forward(request,response);
        } else if("updateFlower".equals(method)){
            Flower flower =requestDataObj(request);
            FlowerDao flowerDao =new FlowerDao();
            flower.setId(Integer.valueOf(request.getParameter("id")));
            flowerDao.updateFlower(flower);
            request.setAttribute("flower",flower);
            response.sendRedirect(request.getContextPath()+"/FlowerServlet?method=page&pageNo="+request.getParameter("pageNo"));
        } else if("page".equals(method)){
            page(request,response);
        }


    }

    private Flower requestDataObj(HttpServletRequest request) {
        String flowerName = request.getParameter("flowerName");
        double flowerPrice = Double.valueOf(request.getParameter("flowerPrice"));
        Integer flowerHot = Integer.valueOf(request.getParameter("flowerHot"));
        String flowerIntroduction = request.getParameter("flowerIntroduction");
        Integer flowerSales = Integer.valueOf(request.getParameter("flowerSales"));
        String imgPath = request.getParameter("imgPath");
        Flower flower =new Flower(null,flowerName,flowerPrice,flowerHot,flowerIntroduction,flowerSales,imgPath);
        return flower;
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageDao pageDao = new PageDao();
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用PageDao.page(pageNo，pageSize)：Page对象
        Page<Flower> page = pageDao.page(pageNo, pageSize);
        page.setUrl("FlowerServlet?method=page");
        //3 保存Page对象到Request域中
        request.setAttribute("page",page);
        //4 请求转发到pages/manager/flower_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/flower_manager.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
