package com.ctcglobal.shippingapp.controller;

import com.ctcglobal.shippingapp.model.dateAndTime;
import com.ctcglobal.shippingapp.model.health;
import com.ctcglobal.shippingapp.model.hostName;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    private final dateAndTime datentime = new dateAndTime();
    private final hostName host = new hostName();
    private health apphealth = new health();


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String readMe() {
        return "hello this is a placeholder readme. /date for date, /health is for app health and /host for hostname";
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public dateAndTime date() {
        return datentime;
    }

    @RequestMapping(value = "/host", method = RequestMethod.GET)
    public hostName host() {
        return host;
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public health apphealth() {
        apphealth.setStatus("healthy");
        return apphealth;
    }


}
