package com.itcpay.date.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Order {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime payTime;

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

}
