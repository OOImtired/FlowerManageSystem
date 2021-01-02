package com.qst.test;

import com.qst.bean.Cart;
import com.qst.bean.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
class CartTest {

    @Test
    void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"1",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"1",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"2",1,new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"1",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"1",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"2",1,new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(1);

        System.out.println(cart);
    }

    @Test
    void clearCart() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"1",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"1",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"2",1,new BigDecimal(100),new BigDecimal(100)));

        cart.clear();

        System.out.println(cart);

    }

    @Test
    void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"1",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"1",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"2",1,new BigDecimal(100),new BigDecimal(100)));

        cart.updateCount(2,2);

        System.out.println(cart);
    }
}