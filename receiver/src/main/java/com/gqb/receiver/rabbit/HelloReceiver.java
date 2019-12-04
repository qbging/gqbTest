package com.gqb.receiver.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * rabbit 接收端
 */
@Component
public class HelloReceiver {

//    @RabbitHandler
    @RabbitListener(queues = "hello")
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }

//    @RabbitHandler
    @RabbitListener(queues = {DirectRabbitConfig.DIRECT_QUEUE1})
    public void processDirectMessage(String hello) {
        System.out.println("消费者 Receiver DirectMessage : " + hello);
    }

    //topic 绑定不同规则交换机的队列
    @RabbitListener(queues = {TopicRabbitConfig.TOPIC_QUEUE1})
    public void processTopicMessage(String hello) {
        System.out.println("消费者 topic1 Receiver TopicMessage : " + hello);
    }
    @RabbitListener(queues = {TopicRabbitConfig.TOPIC_QUEUE2})
    public void processTopicMessage2(String hello) {
        System.out.println("消费者 topic2 Receiver TopicMessage : " + hello);
    }


    @RabbitListener(queues = {FanoutRabbitConfig.FANOUT_QUEUE1})
    public void processfanoutMessage1(String hello) {
        System.out.println("消费者 FANOUT1 Receiver fanoutMessage : " + hello);
    }
    @RabbitListener(queues = {FanoutRabbitConfig.FANOUT_QUEUE2})
    public void processfanoutMessage2(String hello) {
        System.out.println("消费者 FANOUT2 Receiver fanoutMessage : " + hello);
    }

}