package test.activeMQ.first;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TextConsumerListener {
	
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
			session=connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			destination = session.createQueue("test-listener");
			consumer = session.createConsumer(destination);
//			//receive是一个主动获取消息的方法，执行一次拉去一次，学习使用，开发少用
//			message = consumer.receive();
			//注册监听器，注册成功后，队列消息变化会自动触发监听器代码，接收并处理
			consumer.setMessageListener(new MessageListener() {
				/*
				 * 一旦注册，永久有效（没有关闭Consumer代码情况下，即Consumer线程不关闭）
				 * 处理方式：只要消息未处理，自动调用onMessage方法，处理消息
				 * 监听器可以注册若干个，注册多个监听器相当于集群
				 * activeMQ自动的循环调用多个监听器，处理队列中的消息，实现并行处理
				 * @param message相当于receive方法的返回值，即为处理消息
				 * ll*/
				@Override
				public void onMessage(Message message) {
					try {
						//确认方法，代办Consumer已接收消息，确认后MQ删除对应消息
						message.acknowledge();
						ObjectMessage om = (ObjectMessage) message;
						Object data = om.getObject();
						System.out.println(data);
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
//			result = ((TextMessage)message).getText();
			//阻塞代码，保证listener代码未结束。如果代码结束了，监听器自动关闭
			System.in.read();
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
		TextConsumerListener consumer = new TextConsumerListener();
		String receive = consumer.receiveTextMessage();
		System.out.println("接收消息为："+receive);
	}
}
