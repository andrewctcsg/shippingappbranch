package com.ctcglobal.bookstoreapp.model;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class hostName {

    public InetAddress methodset() {
        InetAddress hostName = null;
        try {
            hostName = InetAddress.getLocalHost();

        } catch (UnknownHostException e) {

        }
        return hostName;
    }

    public String getHostName() {
        return this.methodset().getHostName();
    }

    public String getHostAddress() {
        return this.methodset().getHostAddress();
    }
}


