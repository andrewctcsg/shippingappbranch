package com.ctcglobal.shippingapp.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;
    private String sourcePin;
    private String destPin;
    private int distanceBet;
    private String orderDate;
    private int eta;
    private int quantity;
    private int arrived;

    public Order(int id, String name, String sourcePin, String destPin, int distanceBet, String orderDate, int eta, int quantity, int arrived) {
        dateAndTime dat = new dateAndTime();
        Shippingt shipt = new Shippingt();

        this.id = id;
        this.name = name;
        this.sourcePin = sourcePin;
        this.destPin = destPin;
        this.distanceBet = Integer.parseInt(shipt.distance(destPin));
        this.orderDate = orderDate;
        this.eta = eta;
        this.quantity = quantity;
        this.arrived = arrived;
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

    public int getDistanceBet() {
        return distanceBet;
    }

    public void setDistanceBet(int distanceBet) {
        this.distanceBet = distanceBet;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getArrived() {
        return arrived;
    }

    public void setArrived(int arrived) {
        this.arrived = arrived;
    }
}
