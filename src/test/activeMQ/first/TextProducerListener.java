package test.activeMQ.first;

import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TextProducerListener {
	public void sendTextMessage(String datas) {
		ConnectionFactory factory = null;
		Connection connection = null;
		Destination destination = null;
		Session session =null;
		MessageProducer producer=null;
		Message message = null;
		try {
			factory = new ActiveMQConnectionFactory("guest", "guest", "tcp://192.168.24.101:61616");
			connection = factory.createConnection();
			session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			//创建目的地，参数为目的地名，唯一标记
			destination = session.createQueue("test-listener");
			//通过回话对象 创建消息的发送者，发送者发送消息一定要指定目的地（创建producer时可以不指定目的地，在发送消息时指定）
			producer = session.createProducer(destination);
			connection.start();
			//创建文本信息
//			message = session.createTextMessage(datas);
			//发送失败会抛出异常
//			producer.send(message);
			Random r = new Random();
			for (int i = 0; i < 100; i++) {
				Integer data = i;
				message = session.createObjectMessage(data);
				producer.send(message);
			}
			System.out.println("消息发送完成");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(producer != null) {
				try {
					producer.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(session != null) {
				try {
					session.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		TextProducerListener producer = new TextProducerListener();
		producer.sendTextMessage("测试ActiveMq");
	}
}
