package com.ctcglobal.shippingapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Method;

@Entity
@Table(name = "shipping_time")
public class Shippingt {

    @Id
    private String destination;

    private String cc102l;
    private String jb711d;
    private String dp641g;
    private String vv411j;
    private String kl133m;
    private String mm999m;
    private String sd549n;
    private String ip561p;
    private String fd956g;
    private String aa110b;

    public Shippingt () {

    }

    public Shippingt(String destination, String cc102l, String jb711d, String dp641g, String vv411j, String kl133m, String mm999m, String sd549n, String ip561p, String fd956g, String aa110b) {
        this.destination = destination;
        this.cc102l = cc102l;
        this.jb711d = jb711d;
        this.dp641g = dp641g;
        this.vv411j = vv411j;
        this.kl133m = kl133m;
        this.mm999m = mm999m;
        this.sd549n = sd549n;
        this.ip561p = ip561p;
        this.fd956g = fd956g;
        this.aa110b = aa110b;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCc102l() {
        return cc102l;
    }

    public void setCc102l(String cc102l) {
        this.cc102l = cc102l;
    }

    public String getJb711d() {
        return jb711d;
    }

    public void setJb711d(String jb711d) {
        this.jb711d = jb711d;
    }

    public String getDp641g() {
        return dp641g;
    }

    public void setDp641g(String dp641g) {
        this.dp641g = dp641g;
    }

    public String getVv411j() {
        return vv411j;
    }

    public void setVv411j(String vv411j) {
        this.vv411j = vv411j;
    }

    public String getKl133m() {
        return kl133m;
    }

    public void setKl133m(String kl133m) {
        this.kl133m = kl133m;
    }

    public String getMm999m() {
        return mm999m;
    }

    public void setMm999m(String mm999m) {
        this.mm999m = mm999m;
    }

    public String getSd549n() {
        return sd549n;
    }

    public void setSd549n(String sd549n) {
        this.sd549n = sd549n;
    }

    public String getIp561p() {
        return ip561p;
    }

    public void setIp561p(String ip561p) {
        this.ip561p = ip561p;
    }

    public String getFd956g() {
        return fd956g;
    }

    public void setFd956g(String fd956g) {
        this.fd956g = fd956g;
    }

    public String getAa110b() {
        return aa110b;
    }

    public void setAa110b(String aa110b) {
        this.aa110b = aa110b;
    }

    @Override
    public String toString() {
        return "ShippingTime{" +
                "destination='" + destination + '\'' +
                ", cc102l='" + cc102l + '\'' +
                ", jb711d='" + jb711d + '\'' +
                ", dp641g='" + dp641g + '\'' +
                ", vv411j='" + vv411j + '\'' +
                ", kl133m='" + kl133m + '\'' +
                ", mm999m='" + mm999m + '\'' +
                ", sd549n='" + sd549n + '\'' +
                ", ip561p='" + ip561p + '\'' +
                ", fd956g='" + fd956g + '\'' +
                ", aa110b='" + aa110b + '\'' +
                '}';
    }

    public String distance (String source) {
        String dist="x";
        switch (source)
        {
            case "cc102l":
                return dist = this.cc102l;
            case "jb711d":
                return dist = this.jb711d;
            case "dp641g":
                return dist = this.dp641g;
            case "vv411j":
                return dist = this.vv411j;
            case "kl133m":
                return dist = this.kl133m;
            case "mm999m":
                return dist = this.mm999m;
            case "sd549n":
                return dist = this.sd549n;
            case "ip561p":
                return dist = this.ip561p;
            case "fd956g":
                return dist = this.fd956g;
            case "aa110b":
                return dist = this.aa110b;

        }
        return dist;
    }

}

