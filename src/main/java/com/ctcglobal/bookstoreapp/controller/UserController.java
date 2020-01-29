package com.ctcglobal.bookstoreapp.controller;

import com.ctcglobal.bookstoreapp.model.dateAndTime;
import com.ctcglobal.bookstoreapp.model.health;
import com.ctcglobal.bookstoreapp.model.hostName;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    private final dateAndTime datentime = new dateAndTime();
    private final hostName host = new hostName();
    private final health apphealth = new health();


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
        return apphealth;
    }
}
