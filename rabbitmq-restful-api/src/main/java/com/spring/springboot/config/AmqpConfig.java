package com.spring.springboot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by 男孩的天职 on 2016/11/14.
 */
@Configuration
public class AmqpConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue("order");
    }
}
