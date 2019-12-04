package com.gqb.sender.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guoqb
 * @date : 2019/12/3 22:04
 * @descript
 */
@Configuration
public class TopicRabbitConfig {
    //topic
    public static final String TOPIC_QUEUE1 = "rabbit-topic.queue1";
    public static final String TOPIC_QUEUE2 = "rabbit-topic.queue2";
    public static final String TOPIC_EXCHANGE = "rabbit-topic.exchange";
    public static final String TOPIC_ROUTING_KEY1 = "lzc.123";
    public static final String TOPIC_ROUTING_KEY2 = "lzc.#";

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }
    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1);
    }
    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE2);
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }
    @Bean
    public Binding topicBinding1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(TOPIC_ROUTING_KEY1);
    }
    @Bean
    public Binding topicBinding2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(TOPIC_ROUTING_KEY2);
    }
}
