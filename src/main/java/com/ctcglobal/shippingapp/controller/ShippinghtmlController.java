package com.ctcglobal.shippingapp.controller;

import com.ctcglobal.shippingapp.model.*;
import com.ctcglobal.shippingapp.repo.OrderRepository;
import com.ctcglobal.shippingapp.repo.ShippingChartRepository;
import com.ctcglobal.shippingapp.repo.ShippingtRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.google.gson.Gson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/shipping")
public class ShippinghtmlController {

    private static String Response;
    private ShippingChartRepository shippingChartRepository;
    private OrderRepository orderRepository;
    private final dateAndTime datentime = new dateAndTime();

    public ShippinghtmlController(ShippingChartRepository shippingChartRepository, OrderRepository orderRepository) {
        this.shippingChartRepository = shippingChartRepository;
        this.orderRepository = orderRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/gethealth", method = RequestMethod.GET)
    public String responsetest() {
        final String uri = "http://shippingapp-shipping-springboot.apps.ocp4.sgctcdemo.local/api/health";

        RestTemplate restTemplate = new RestTemplate();
        try{
            Response = restTemplate.getForObject(uri, String.class);
            Gson gson = new Gson();
            health name = gson.fromJson(Response, health.class);
            if (name.getStatus().equals("healthy"))
           { return "other app is live";}
            return "other app is not healthy";}
        catch(Exception e) {
            return "other app is not responding";
        }
    }

    /*@ResponseBody
    @GetMapping("/healthcheck")
    public String responseinside() {

        getEmployees();

        objmapper.writeValue(Response);


        return shippingChartRepository.findAll();
    }*/

    /*@RequestMapping(value = "", method = RequestMethod.GET)
    public String readMe() {
        return "hello this is a placeholder readme. /date for date, /health is for app health and /host for hostname";
    }

    @ResponseBody
    @GetMapping("/locations/all")
    public List < ShippingChart > getAll() {
        return shippingChartRepository.findAll();
    }

    public double getDistance(@PathVariable String destination, @PathVariable String source) {
        int x1 = shippingChartRepository.findByLocation(destination).getX();
        int y1 = shippingChartRepository.findByLocation(destination).getY();

        int x2 = shippingChartRepository.findByLocation(source).getX();
        int y2 = shippingChartRepository.findByLocation(source).getY();

        int x3;
        int y3;

        if(x1 > x2) {
            x3 = x1 - x2;
        }
        else {
            x3 = x2 - x1;
        }

        if(y1 > y2) {
            y3 = y1 - y2;
        }
        else{
            y3 = y2 - y1;
        }


        return Math.sqrt (Math.pow(x3, 2) + Math.pow(y3, 2));
    }

    @ResponseBody
    @PostMapping("/order/add")
    public Order addOrder(@RequestBody OrderForm orderForm) {
        Order newOrder = new Order(orderForm.getName(), orderForm.getSourcePin(), orderForm.getDestPin(), orderForm.getOrderTime(), orderForm.getWeight(), getDistance(orderForm.getSourcePin(), orderForm.getDestPin()));
        orderRepository.save(newOrder);
        return newOrder;
    }

    @ResponseBody
    @GetMapping("/order/all")
    public List < Order > getAllOrders() {
        return orderRepository.findAll();
    }

    @ResponseBody
    @PutMapping("/order/check/{id}")
    public OrderView checkOrders(@PathVariable int id) {
        Order existOrder = orderRepository.findById(id);
        double originalDistance = existOrder.getDistance();

        long minutesDiff = datentime.diffMinutesTime(existOrder.getOrderTime());
        System.out.print(minutesDiff);

        double distanceLeft = originalDistance - minutesDiff;
        if (distanceLeft < 0)
        {
            distanceLeft = 0;
        }
        existOrder.checkArrived(distanceLeft);
        orderRepository.save(existOrder);
        OrderView currOrder = new OrderView(existOrder.getName(), existOrder.getSourcePin(), existOrder.getDestPin(), existOrder.getOrderTime(), existOrder.getWeight(), existOrder.getArrived(), existOrder.getDistance(), distanceLeft);
        return currOrder;
    }

    @ResponseBody
    @DeleteMapping("/order/delete/{id}")
    public Order deleteOrders(@PathVariable int id) {
        Order existOrder = orderRepository.findById(id);
        orderRepository.delete(existOrder);
        return existOrder;
    }*/
}
