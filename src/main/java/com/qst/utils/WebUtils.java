package com.qst.utils;

import com.qst.bean.Flower;
import com.qst.bean.Page;
import com.qst.dao.PageDao;

import java.util.List;

public class WebUtils {

    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
