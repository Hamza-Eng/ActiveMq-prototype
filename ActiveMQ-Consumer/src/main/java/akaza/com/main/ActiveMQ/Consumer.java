package akaza.com.main.ActiveMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageConsumer;
import jakarta.jms.MessageListener;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

public class Consumer {

	public static void ConsumePointToPoint() throws Exception {
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		Connection connection = factory.createConnection();
		
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue("chate-id-001");

		MessageConsumer consumer = session.createConsumer(destination);

		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				
				try {
					Message msg = consumer.receive();
					String  response= ((TextMessage) msg).getText();
					System.out.println("Received = " + response );
				} catch (JMSException e) {
					
					e.printStackTrace();
				}
			}
		});
		
//		String response;
//		int i = 0;
//		while (true) {
//
//			Message msg = consumer.receive();
//			response = ((TextMessage) msg).getText();
//
//			System.out.println("Received = " + response + " " + i);
//			i++;
//			Thread.sleep(5000);
//		}
	}
}
