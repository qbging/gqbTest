package com.gqb.receiver.rabbit;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

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

    @RabbitHandler
    @RabbitListener(queues = {DirectRabbitConfig.DIRECT_QUEUE1})
    public void processDirectMessage(String hello) {
        System.out.println("消费者 Receiver DirectMessage : " + hello);
    }
    @RabbitHandler
    @RabbitListener(queues = {DirectRabbitConfig.DIRECT_QUEUE1})
    public void processDirectMessageUser(Message message, Channel channel) throws IOException {
        String s = new String(message.getBody());
//        System.out.println(s);
//        if (s.indexOf("错误")!=-1){
        //出现错误拒绝消息，第一个boolean表示一个consumer还是所有，最后一个参数 true表示重新入队列
//            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
//        }
        s = s.replace("错误", "正确");
        System.out.println(s);
        //该消费者手动ack告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 确认消费成功
        // 否则消息服务器以为这条消息没处理掉 后续还会在发，true确认所有消费者获得的消息
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        System.out.println("消费者 Receiver DirectMessage User: " + message);
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