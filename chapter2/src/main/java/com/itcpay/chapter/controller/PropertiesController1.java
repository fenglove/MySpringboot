package com.itcpay.chapter.controller;

import com.itcpay.chapter.properties.MyProperties;
import com.itcpay.chapter.properties.MyProperties2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties2")
public class PropertiesController1 {

    private static final Logger log = LoggerFactory.getLogger(PropertiesController1.class);

    @Autowired
    private MyProperties2 myProperties2;

    @GetMapping("/2")
    public MyProperties2 myProperties() {
        log.info("==========");
        log.info(myProperties2.toString());
        log.info("==========");
        return myProperties2;
    }

}
