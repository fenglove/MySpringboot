package com.itcpay.date.controller;

import com.itcpay.date.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public String query() {
        Order order = new Order();
        order.setPayTime(LocalDateTime.now());
        return "now:"+order.getPayTime();
    }

}
