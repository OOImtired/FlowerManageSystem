package com.qst.servlet;

import com.google.gson.Gson;
import com.qst.bean.Cart;
import com.qst.bean.CartItem;
import com.qst.bean.Flower;
import com.qst.dao.FlowerDao;
import com.qst.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/CartServlet")
public class CartServlet extends HttpServlet {

    FlowerDao flowerDao = new FlowerDao();

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        Flower flower = flowerDao.queryFlowerById(id);
        CartItem cartItem = new CartItem(flower.getId(),flower.getFlowerName(),1, BigDecimal.valueOf(flower.getFlowerPrice()),BigDecimal.valueOf(flower.getFlowerPrice()));
        Cart cart =(Cart) request.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        request.getSession().setAttribute("lastName",cartItem.getTradeName());
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        Cart cart =(Cart) request.getSession().getAttribute("cart");
        cart.deleteItem(id);
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void clearItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        int count =WebUtils.parseInt(request.getParameter("count"),1);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.updateCount(id,count);
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        if("addItem".equals(action)){
            addItem(request,response);
        }else if("deleteItem".equals(action)){
            deleteItem(request,response);
        }else if("clearItem".equals(action)){
            clearItem(request,response);
        }else if("updateCount".equals(action)){
            updateCount(request,response);
        }else if("ajaxAddItem".equals(action)){
            ajaxAddItem(request,response);
        }
    }

    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        Flower flower = flowerDao.queryFlowerById(id);
        CartItem cartItem = new CartItem(flower.getId(),flower.getFlowerName(),1, BigDecimal.valueOf(flower.getFlowerPrice()),BigDecimal.valueOf(flower.getFlowerPrice()));
        Cart cart =(Cart) request.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        request.getSession().setAttribute("lastName",cartItem.getTradeName());

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getTradeName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        response.getWriter().write(resultMapJsonString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
