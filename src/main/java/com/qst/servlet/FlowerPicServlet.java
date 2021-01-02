package com.qst.servlet;

import com.qst.bean.Flower;
import com.qst.dao.FlowerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/FlowerPicServlet")
@MultipartConfig
public class FlowerPicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Part part = request.getPart("imgPath");
        String cd = part.getHeader("Content-Disposition");
        //截取不同类型的文件需要自行判断
        String filename = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);

        String dir =this.getServletContext().getRealPath("/static/img");

        String f=dir+"\\"+filename;

        File imgDir=new File(f);
        if(imgDir.exists()){
            imgDir.mkdirs();
        }
        part.write(dir+"\\"+filename);

        FlowerDao flowerDao = new FlowerDao();

        String id = request.getParameter("id");
        flowerDao.updatePic(Integer.valueOf(id),"/FlowerManageSystem/static/img/"+filename);

        Flower flower = flowerDao.queryFlowerById(Integer.valueOf(id));
        request.setAttribute("flower",flower);

        request.getRequestDispatcher("/pages/manager/flower_update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
