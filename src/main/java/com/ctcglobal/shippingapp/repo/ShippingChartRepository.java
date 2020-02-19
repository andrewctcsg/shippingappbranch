package com.ctcglobal.shippingapp.repo;

import com.ctcglobal.shippingapp.model.ShippingChart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingChartRepository extends JpaRepository<ShippingChart, String> {

    ShippingChart findByLocation(String Location);
    boolean existsShippingChartByLocation(String Location);

}
