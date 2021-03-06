package com.ctcglobal.shippingapp.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;
    private String sourcePin;
    private String destPin;
    private String orderTime;
    private int weight;
    private int arrived;
    private double distance;

    public Order () {}

    public Order(String name, String sourcePin, String destPin, String orderTime, int weight, double distance) {

        this.name = name;
        this.sourcePin = sourcePin;
        this.destPin = destPin;
        this.weight = weight;
        this.arrived = 0;
        this.orderTime = orderTime;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourcePin() {
        return sourcePin;
    }

    public void setSourcePin(String sourcePin) {
        this.sourcePin = sourcePin;
    }

    public String getDestPin() {
        return destPin;
    }

    public void setDestPin(String destPin) {
        this.destPin = destPin;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getArrived() {
        return arrived;
    }

    public void checkArrived(double distanceLeft) {
        if(distanceLeft == 0)
        {
            this.arrived = 1;
        }
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
