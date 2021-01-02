package com.qst.test;

import com.qst.bean.Flower;
import com.qst.bean.Page;
import com.qst.dao.PageDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PageDaoTest {

    PageDao pageDao = new PageDao();
    @Test
    void queryForPageTotalCount() {
        int count = pageDao.queryForPageTotalCount();
        System.out.println(count);
    }

    @Test
    void queryForPageItems() {
        List<Flower> flowerList = pageDao.queryForPageItems(0, 2);
        for (Flower f:flowerList
             ) {
            System.out.println(f);
        }
    }

    @Test
    void queryForPageTotalCountByPrice() {
        Integer count = pageDao.queryForPageTotalCountByPrice(11.0, 12.0);
        System.out.println(count);
    }

    @Test
    void queryForPageItemsByPrice() {
        List<Flower> flowerList = pageDao.queryForPageItemsByPrice(0, 2, 11.0, 12.0);
        for (Flower f:flowerList
             ) {
            System.out.println(f);
        }
    }

    @Test
    void page(){
        Page<Flower> page = pageDao.page(1, 2);
        System.out.println(page);
    }

    @Test
    void pageByPrice(){
        Page<Flower> flowerPage = pageDao.pageByPrice(1, 2, 11.0, 12.0);
        System.out.println(flowerPage);
    }
}