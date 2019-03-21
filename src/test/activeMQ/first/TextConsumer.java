package test.activeMQ.first;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TextConsumer {
	
	public String receiveTextMessage() {
		String result = "";
		ConnectionFactory factory = null;
		Connection connection = null;
		Destination destination = null;
		Session session =null;
		MessageConsumer consumer=null;
		Message message = null;
		
		try {
			factory = new ActiveMQConnectionFactory("guest", "guest", "tcp://192.168.24.101:61616");
			connection = factory.createConnection();
			//消息消费者必须启动连接，否则无法处理消息
			connection.start();
			//Consumer没有事务
			session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("first-mq");
			consumer = session.createConsumer(destination);
			//receive是一个主动获取消息的方法，执行一次拉去一次，学习使用，开发少用
			message = consumer.receive();
			result = ((TextMessage)message).getText();
//			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(consumer != null) {
				try {
					consumer.close();
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
		return result;
	}
	
	public static void main(String[] args) {
		TextConsumer consumer = new TextConsumer();
		String receive = consumer.receiveTextMessage();
		System.out.println("接收消息为："+receive);
	}
}
