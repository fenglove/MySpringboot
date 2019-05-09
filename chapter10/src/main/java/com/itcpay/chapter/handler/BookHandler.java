package com.itcpay.chapter.handler;

import com.itcpay.chapter.config.RabbitConfig;
import com.itcpay.chapter.entity.Book;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * BOOK_QUEUE 消费者
 */
@Component
public class BookHandler {

    private static final Logger log = LoggerFactory.getLogger(BookHandler.class);

    @RabbitListener(queues = {RabbitConfig.REGISTER_QUEUE_NAME})
    public void listenerDelayQueue(Book book, Message message, Channel channel) {
        log.info("[listenerDelayQueue 监听的消息]-[消费时间]-[{}]-[{}]", LocalDateTime.now(), book.toString());
        try {
            // 通知MQ消息已被成功消费了，可以ACK了
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            // 如果报错了，那么我们可以进行容错处理，比如转移当前消息进入其它队列
            e.printStackTrace();
        }
    }

}
