package com.itcpay.chapter.handler;

import com.itcpay.chapter.entity.Book;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

/**
 * BOOK_QUEUE 消费者
 */
@Component
public class BookHandler {

    private static final Logger log = LoggerFactory.getLogger(BookHandler.class);

    public void listenerAutoAck(Book book, Message message, Channel channel) {
        // 如果手动ACK，消息会被监听消费，但是消息在队列中依旧存在，如果未配置acknowledge-mode默认是会在消费完毕后自动ACK掉
        long deliverTag = message.getMessageProperties().getDeliveryTag();



    }

}
