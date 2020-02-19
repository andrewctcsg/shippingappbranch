package com.ctcglobal.shippingapp.model;

import java.time.LocalDateTime;

public class OrderView {
    private String name;
    private String sourcePin;
    private String destPin;
    private String orderTime;
    private String currentTime;
    private int weight;
    private int arrived;
    private double distance;
    private double distanceLeft;

    public OrderView(String name, String sourcePin, String destPin, String orderTime, int weight, int arrived, double distance, double distanceLeft) {
        this.name = name;
        this.sourcePin = sourcePin;
        this.destPin = destPin;
        this.orderTime = orderTime;
        this.currentTime = new dateAndTime().getDateTime();
        this.weight = weight;
        this.arrived = arrived;
        this.distance = distance;
        this.distanceLeft = distanceLeft;
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

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
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

    public void setArrived(int arrived) {
        this.arrived = arrived;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistanceLeft() {
        return distanceLeft;
    }

    public void setDistanceLeft(double distanceLeft) {
        this.distanceLeft = distanceLeft;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
