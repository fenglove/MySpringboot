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

/**
 * BOOK_QUEUE 消费者
 */
@Component
public class BookHandler {

    private static final Logger log = LoggerFactory.getLogger(BookHandler.class);

    @RabbitListener(queues = {RabbitConfig.DEFAULT_BOOK_QUEUE})
    public void listenerAutoAck(Book book, Message message, Channel channel) {
        // 如果手动ACK，消息会被监听消费，但是消息在队列中依旧存在，如果未配置acknowledge-mode默认是会在消费完毕后自动ACK掉
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.info("listenerAutoAck 监听的消息-{}", book.toString());
            // 通知 MQ 消息已被成功消费，可以ACK了
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                // 处理失败，重新压入MQ
                channel.basicRecover();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @RabbitListener(queues = {RabbitConfig.MANUAL_BOOK_QUEUE})
    public void listenerManualAck(Book book, Message message, Channel channel) {
        log.info("listenerManualAck 监听的消息-{}", book.toString());
        try {
            // 通知 MQ 消息已被成功消费了，可以ACK了
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            // 如果报错了，那么我们可以进行容错处理，比如转移当前消息进入其他队列
            e.printStackTrace();
        }
    }

}
