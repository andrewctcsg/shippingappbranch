package com.ctcglobal.shippingapp.controller;

import com.ctcglobal.shippingapp.model.*;
import com.ctcglobal.shippingapp.repo.OrderRepository;
import com.ctcglobal.shippingapp.repo.ShippingChartRepository;
import com.ctcglobal.shippingapp.repo.ShippingtRepository;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    private ShippingChartRepository shippingChartRepository;
    private OrderRepository orderRepository;
    private final dateAndTime datentime = new dateAndTime();

    public ShippingController(ShippingChartRepository shippingChartRepository, OrderRepository orderRepository) {
        this.shippingChartRepository = shippingChartRepository;
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String readMe() {
        return "hello this is a placeholder readme.";
    }

    @GetMapping("/locations/all")
    public List < ShippingChart > getAll() {
        return shippingChartRepository.findAll();
    }

    @GetMapping("/locations/{location}")
    public ShippingChart getOne(@PathVariable String location) {
        return shippingChartRepository.findByLocation(location);
    }

    @GetMapping("/locations/distance/{destination}/{source}")
    public double getDistance(@PathVariable String destination, @PathVariable String source) {
        int x1,x2,x3,y1,y2,y3;
        if(checkLocation(destination)) {
            x1 = shippingChartRepository.findByLocation(destination).getX();
            y1 = shippingChartRepository.findByLocation(destination).getY();
        }
        else if(checkOtherLocation(destination))
        {
            x1 = shippingChartRepository.findByLocation(destination).getX();
            y1 = shippingChartRepository.findByLocation(destination).getY();
        }
        else
        {
            x1=0;
            y1=0;
        }
        if(checkLocation(source)) {
            x2 = shippingChartRepository.findByLocation(source).getX();
            y2 = shippingChartRepository.findByLocation(source).getY();
        }
        else if(checkOtherLocation(source)) {
            x2 = shippingChartRepository.findByLocation(source).getX();
            y2 = shippingChartRepository.findByLocation(source).getY();
        }
        else
        {
            x2=0;
            y2=0;
        }
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

    @PostMapping("/order/add")
    public Order addOrder(@RequestBody OrderForm orderForm) {
        if ((checkLocation(orderForm.getDestPin()) || checkOtherLocation(orderForm.getDestPin())) &&
                ((checkLocation(orderForm.getSourcePin())) || checkOtherLocation(orderForm.getSourcePin())))
        {
            Order newOrder = new Order(orderForm.getName(), orderForm.getSourcePin(), orderForm.getDestPin(), orderForm.getOrderTime(), orderForm.getWeight(), getDistance(orderForm.getSourcePin(), orderForm.getDestPin()));
            orderRepository.save(newOrder);
            return newOrder;
        }
        return null;
    }

    @GetMapping("/order/all")
    public List < Order > getAllOrders() {
        return orderRepository.findAll();
    }

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
        OrderView currOrder = new OrderView(existOrder.getName(), existOrder.getSourcePin(), existOrder.getDestPin(),
                existOrder.getOrderTime(), existOrder.getWeight(), existOrder.getArrived(), existOrder.getDistance(), distanceLeft);
        return currOrder;
    }

    @PutMapping("/order/check/all")
    public List<OrderView> checkAllOrders() {
        List<Order> allOrders = getAllOrders();
        List<OrderView> allOrderView = new java.util.ArrayList<>(Collections.emptyList());
        for(Order oneOrder:allOrders) {
            double originalDistance = oneOrder.getDistance();
            long minutesDiff = datentime.diffMinutesTime(oneOrder.getOrderTime());
            System.out.print(minutesDiff);

            double distanceLeft = originalDistance - minutesDiff;
            if (distanceLeft < 0)
            {
                distanceLeft = 0;
            }
            oneOrder.checkArrived(distanceLeft);
            orderRepository.save(oneOrder);
            OrderView currOrder = new OrderView(oneOrder.getName(), oneOrder.getSourcePin(), oneOrder.getDestPin(),
                    oneOrder.getOrderTime(), oneOrder.getWeight(), oneOrder.getArrived(), oneOrder.getDistance(), distanceLeft);
            allOrderView.add(currOrder);
        }

        return allOrderView;
    }

    @DeleteMapping("/order/delete/{id}")
    public Order deleteOrders(@PathVariable int id) {
        Order existOrder = orderRepository.findById(id);
        orderRepository.delete(existOrder);
        return existOrder;
    }

    @DeleteMapping("/order/delete/all")
    public List <Order> deleteAllOrders() {
        List <Order> existAllOrder = orderRepository.findAll();
        for (Order eachOrder: existAllOrder) {
            orderRepository.delete(eachOrder);
        }
        return existAllOrder;
    }

    @RequestMapping(value = "/locations/others/{location}", method = RequestMethod.GET)
    public String allOtherLocations(@PathVariable String location) {
        final String uri = "insert here";
        RestTemplate restTemplate = new RestTemplate();
        try{
            String Response = restTemplate.getForObject(uri, String.class);
            Gson gson = new Gson();
            ShippingChart otherLoc = gson.fromJson(Response, ShippingChart.class);
            return otherLoc.toString();}
        catch(Exception e) {
            return "location not found";
        }
    }

    public boolean checkLocation(String location) {
        boolean exists = shippingChartRepository.existsShippingChartByLocation(location);
        return exists;
    }

    public boolean checkOtherLocation(String location) {
        boolean exists = shippingChartRepository.existsShippingChartByLocation(location);
        return exists;
    }

}
