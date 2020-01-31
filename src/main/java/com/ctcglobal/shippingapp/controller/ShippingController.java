package com.ctcglobal.shippingapp.controller;

import com.ctcglobal.shippingapp.model.Order;
import com.ctcglobal.shippingapp.model.Shippingt;
import com.ctcglobal.shippingapp.repo.OrderRepository;
import com.ctcglobal.shippingapp.repo.ShippingtRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    private ShippingtRepository shippingtRepository;
    private OrderRepository orderRepository;


    public ShippingController(ShippingtRepository shippingtRepository, OrderRepository orderRepository) {
        this.shippingtRepository = shippingtRepository;
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String readMe() {
        return "hello this is a placeholder readme. /date for date, /health is for app health and /host for hostname";
    }

    @GetMapping("/all")
    public List < Shippingt > getAll() {
        return shippingtRepository.findAll();
    }


    @GetMapping("/distance/{destination}/{source}")
    public String getDistance(@PathVariable String destination, @PathVariable String source) {
        Shippingt x = shippingtRepository.findByDestination(destination);
        return x.distance(source);
    }

    @PostMapping("/order")
    public void addMember(@RequestBody Order order) {
       orderRepository.save(order);

    }

}
