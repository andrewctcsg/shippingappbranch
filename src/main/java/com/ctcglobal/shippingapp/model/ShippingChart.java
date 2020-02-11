package com.ctcglobal.shippingapp.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipping_chart")
public class ShippingChart {

    @Id
    private String location;
    private int x;
    private int y;

    public ShippingChart() {}

    public ShippingChart(String location, int x, int y) {
        this.location = location;
        this.x = x;
        this.y = y;
    }

    public String getLocation() {
        return location;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
