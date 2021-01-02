package com.qst.bean;

import java.math.BigDecimal;

/*
* 购物车中的商品的属性
* */
public class CartItem {
    private Integer id;
    private String tradeName;
    private Integer tradeCount;
    private BigDecimal tradePrice;
    private BigDecimal tradeTotalPrice;

    public CartItem() {
    }

    public CartItem(Integer id, String tradeName, Integer tradeCount, BigDecimal tradePrice, BigDecimal tradeTotalPrice) {
        this.id = id;
        this.tradeName = tradeName;
        this.tradeCount = tradeCount;
        this.tradePrice = tradePrice;
        this.tradeTotalPrice = tradeTotalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public Integer getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public BigDecimal getTradeTotalPrice() {
        return tradeTotalPrice;
    }

    public void setTradeTotalPrice(BigDecimal tradeTotalPrice) {
        this.tradeTotalPrice = tradeTotalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", tradeName='" + tradeName + '\'' +
                ", tradeCount=" + tradeCount +
                ", tradePrice=" + tradePrice +
                ", tradeTotalPrice=" + tradeTotalPrice +
                '}';
    }
}
