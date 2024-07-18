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

public class Consumer_Subscriber {

	public static void ConsumeFromManyPublisher() throws Exception {

		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		Connection connection = factory.createConnection();

		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createTopic("Topic-001");

		MessageConsumer consumer = session.createConsumer(destination);

		consumer.setMessageListener(new MessageListener() {

			public void onMessage(Message message) {
				try {
					if (message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;
						System.out.println("Received message: " + textMessage.getText());
					}
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
