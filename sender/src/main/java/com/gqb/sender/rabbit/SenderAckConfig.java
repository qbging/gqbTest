package com.gqb.sender.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author guoqb
 * @date : 2020/1/26 17:15
 * @descript ConfirmCallback 只确认消息是否正确到达 Exchange 中
 *  * ReturnCallback   消息没有正确到达队列时触发回调，如果正确到达队列不执行
 *  * 1. 如果消息没有到exchange,则confirm回调,ack=false
 *  * 2. 如果消息到达exchange,则confirm回调,ack=true
 *  * 3. exchange到queue成功,则不回调return
 *  * 4. exchange到queue失败,则回调return
 */
@Component
public class SenderAckConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//        System.out.println(correlationData.getId()+",");
        if (ack){
            System.out.println("消息发送确认成功");
        } else {
            System.out.println("消息发送失败："+cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
// 反序列化对象输出
//        System.out.println("消息主体: " + SerializationUtils.deserialize(message.getBody()));
        System.out.println("消息主体: " + message.getBody());
        System.out.println("应答码: " + replyCode);
        System.out.println("描述：" + replyText);
        System.out.println("消息使用的交换器 exchange : " + exchange);
        System.out.println("消息使用的路由键 routing : " + routingKey);
    }
}
