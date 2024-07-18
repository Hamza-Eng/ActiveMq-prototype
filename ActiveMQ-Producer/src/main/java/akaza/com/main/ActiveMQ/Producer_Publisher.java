package akaza.com.main.ActiveMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.MessageProducer;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

public class Producer_Publisher {

	public static void publishToManySubscriber() throws Exception {

		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		Connection connection = factory.createConnection();

		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createTopic("Topic-001");

		MessageProducer publisher = session.createProducer(destination);

		int i = 1;
		while (true) {
			TextMessage message = session.createTextMessage("Hello World ! ==> " + i);

			publisher.send(message);
			i++;
			Thread.sleep(2000);

		}
	}

}
