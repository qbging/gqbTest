package test.activeMQ.first;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TextProducer {
	public void sendTextMessage(String datas) {
		ConnectionFactory factory = null;
		Connection connection = null;
		Destination destination = null;
		Session session =null;
		MessageProducer producer=null;
		Message message = null;
		try {
			//创建链接工厂，链接activemq服务费链接工厂
			//创建工厂，构造方法有三个参数
			factory = new ActiveMQConnectionFactory("guest", "guest", "tcp://192.168.24.101:61616");
			connection = factory.createConnection();
			//建议启动，消息发送者不是必须启动连接，消息消费者必须启动连接。
			//producer在发送消息时，会检查是否启动了连接，如果未启动，自动启动
			//如果有特殊配置，建议配置完毕再启动连接
			connection.start();
			//不推荐使用事务，如果是批量发送可以使用事务，可以提供缓冲区
			//第一个参数transacted，是否支持事务。true 支持事务，第二个参数对producer无效,建议是session.transacted
			// false 不支持事务，常用参数，第二个参数必须传递，且必须有效。
			//第二个参数acknowledgeMode。如何确认消息的处理，使用确认机制实现
			//auto_ACKNOWLEDGE 自动确认消息，消费者处理消息后自动确认，商业不推荐。
			//client_ACKNOWLEDGE，客户端手动确认(即Consumer需要message.acknowledge();)
			session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			//创建目的地，参数为目的地名，唯一标记
			destination = session.createQueue("first-mq");
			//通过回话对象 创建消息的发送者，发送者发送消息一定要指定目的地（创建producer时可以不指定目的地，在发送消息时指定）
			producer = session.createProducer(destination);
			//创建文本信息
			message = session.createTextMessage(datas);
			//发送失败会抛出异常
			producer.send(message);
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
		TextProducer producer = new TextProducer();
		producer.sendTextMessage("测试ActiveMq");
	}
}
