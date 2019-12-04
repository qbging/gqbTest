package com.gqb.sender.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guoqb
 * @date : 2019/12/3 15:20
 * @descript
 */
@Configuration
public class DirectRabbitConfig {
    //redirect模式
    public static final String DIRECT_QUEUE1 = "rabbit-direct.queue1";
    public static final String DIRECT_QUEUE2 = "rabbit-direct.queue2";
    public static final String DIRECT_EXCHANGE = "rabbit-direct.exchange";
    public static final String DIRECT_ROUTING_KEY = "direct.pwl";
    /**
     * direct模式
     * 消息中的路由键（routing key）如果和 Binding 中的 binding key 一致， 交换器就将消息发到对应的队列中。路由键与队列名完全匹配
     *
     * @return
     */
    @Bean
    public Queue directQueue1() {
        return new Queue(DIRECT_QUEUE1);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding directBinding1() {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with(DIRECT_ROUTING_KEY);
    }
}
