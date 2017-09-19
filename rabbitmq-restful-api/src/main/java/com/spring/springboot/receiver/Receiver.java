package com.spring.springboot.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by 男孩的天职 on 2016/11/14.
 */
@Component
@RabbitListener(queues = "order")
public class Receiver {
    @RabbitHandler
    public void process(String order){
        System.out.println("Receiver:"+order);
    }
}
