/*
package com.ctcglobal.shippingapp.controller;


import com.ctcglobal.shippingapp.model.Book;
import com.ctcglobal.shippingapp.repo.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String readMe() {
        return "hello this is a placeholder readme. /date for date, /health is for app health and /host for hostname";
    }

    */
/*@GetMapping("/all")
    public List < ShippingTime > getall() {
        return shippingTimeRepository.findAll();
    }*//*

    @GetMapping("/book")
    public List <Book> getall() {
        return bookRepository.findAll();
    }

}
*/
