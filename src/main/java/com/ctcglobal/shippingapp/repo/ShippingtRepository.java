package com.ctcglobal.shippingapp.repo;

import com.ctcglobal.shippingapp.model.Shippingt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Method;
import java.util.List;

public interface ShippingtRepository extends JpaRepository<Shippingt, String> {

    /*@Query("select aa110b from shipping_time where destination='vv411j'")
    public String findDestination();*/
    Shippingt findByDestination(String Destination);



}