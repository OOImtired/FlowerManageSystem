package com.qst.test;

import com.qst.bean.Flower;
import com.qst.dao.FlowerDao;
import com.qst.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlowerDaoTest {

    FlowerDao flowerDao = new FlowerDao();

    @Test
    void addFlower() {
        flowerDao.addFlower(new Flower(null,"3",3.0,3,"3",3,null));
    }

    @Test
    void deleteFlower() {
        flowerDao.deleteFlower(2);
    }

    @Test
    void updateFlower() {
        flowerDao.updateFlower(new Flower(1,"4",4.0,4,"4",4,null));

    }

    @Test
    void queryFlowerById() {
        Flower flower = flowerDao.queryFlowerById(3);
        System.out.println(flower);
    }

    @Test
    void queryFlower() {
        List<Flower> flowerList = new ArrayList<>();
        flowerList = flowerDao.queryFlower();
        for (Flower f:flowerList) {
            System.out.println(f);
        }
        /*System.out.println(flowerList+"\n");*/
    }

    @Test
    void updatePic(){
        FlowerDao flowerDao = new FlowerDao();
        flowerDao.updatePic(15,"static/img/default.jpg");
    }
}