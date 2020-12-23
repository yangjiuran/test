package com.yjr.responseChain;

/**
 * @author yangjiuran
 * @Date 2020/9/1
 */
public class MyRequest {
    private int id;
    private float price;

    public MyRequest(int id, float price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
