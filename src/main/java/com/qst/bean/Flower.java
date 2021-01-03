package com.qst.bean;

/**
* @描述:鲜花类
* @创建人:OOImtired
* @创建时间:2021/1/3
*/
public class Flower {

    private Integer id;
    private String flowerName;
    private Double flowerPrice;
    private Integer flowerHot;
    private String flowerIntroduction;
    private Integer flowerSales;
    private String imgPath;

    public Flower() {
    }

    public Flower(Integer id, String flowerName, Double flowerPrice, Integer flowerHot, String flowerIntroduction, Integer flowerSales, String imgPath) {
        this.id = id;
        this.flowerName = flowerName;
        this.flowerPrice = flowerPrice;
        this.flowerHot = flowerHot;
        this.flowerIntroduction = flowerIntroduction;
        this.flowerSales = flowerSales;
        if (imgPath!=null && !"".equals(imgPath)){
            this.imgPath = imgPath;
        }
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        if (imgPath!=null && !"".equals(imgPath)){
            this.imgPath = imgPath;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public Double getFlowerPrice() {
        return flowerPrice;
    }

    public void setFlowerPrice(Double flowerPrice) {
        this.flowerPrice = flowerPrice;
    }

    public Integer getFlowerHot() {
        return flowerHot;
    }

    public void setFlowerHot(Integer flowerHot) {
        this.flowerHot = flowerHot;
    }

    public String getFlowerIntroduction() {
        return flowerIntroduction;
    }

    public void setFlowerIntroduction(String flowerIntroduction) {
        this.flowerIntroduction = flowerIntroduction;
    }

    public Integer getFlowerSales() {
        return flowerSales;
    }

    public void setFlowerSales(Integer flowerSales) {
        this.flowerSales = flowerSales;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", flowerName='" + flowerName + '\'' +
                ", flowerPrice=" + flowerPrice +
                ", flowerHot=" + flowerHot +
                ", flowerIntroduction='" + flowerIntroduction + '\'' +
                ", flowerSales=" + flowerSales +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
