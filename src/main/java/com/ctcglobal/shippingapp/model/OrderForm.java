package com.ctcglobal.shippingapp.model;

public class OrderForm {

    private String name;
    private String sourcePin;
    private String destPin;
    private String orderTime;
    private int weight;

    public OrderForm(String name, String sourcePin, String destPin, int weight) {
        this.name = name;
        this.sourcePin = sourcePin;
        this.destPin = destPin;
        this.weight = weight;
        this.orderTime = new dateAndTime().getDateTime();
    }

    public String getName() {
        return name;
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

    public void setWeight(int quantity) {
        this.weight = weight;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}
