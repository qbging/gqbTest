package com.gqb.sender.controller;

import com.gqb.sender.rabbit.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoqb
 * @date : 2019/12/3 15:27
 * @descript
 */
@RestController
@RequestMapping("/sender")
public class RabbitController {
    @Autowired
    private HelloSender helloSender;

    @RequestMapping("/direct")
    public String directTest(){
        String msg = "生产者线程："+Thread.currentThread().getName() + "+ 你发送成功了：";
//        helloSender.send(msg);//默认交换机（）
//        helloSender.sendDirectMessage(msg+="direct");//直连交换机
//        helloSender.sendTopicMessage(msg+="topic");//Topic
        helloSender.sendFanoutMessage(msg+="fanout");//fanout
        return msg;
    }
}
