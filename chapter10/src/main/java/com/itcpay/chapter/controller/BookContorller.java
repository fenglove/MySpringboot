package com.itcpay.chapter.controller;

import com.itcpay.chapter.config.RabbitConfig;
import com.itcpay.chapter.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/books")
public class BookContorller {

    private static final Logger log = LoggerFactory.getLogger(BookContorller.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public void defaultMessage() {
        Book book = new Book().builder().id("1").name("一起学Spring Boot").build();
        // 添加延迟队列
        rabbitTemplate.convertAndSend(RabbitConfig.REGISTER_DELAY_EXCHANGE, RabbitConfig.DELAY_ROUTING_KEY, book, message -> {
            // 第一句可要可不要，根据自己情况自行处理
            message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, Book.class.getName());
            // 如果配置了 params.put("x-message-ttl", 5*1000);那么这一句也可以省略，根据具体业务是声明 Queue的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(5 * 1000 + "");
            return message;
        });
        log.info("[发送时间]-{}", LocalDateTime.now());
    }

}
