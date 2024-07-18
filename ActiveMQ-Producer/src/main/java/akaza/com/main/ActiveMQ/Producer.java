package akaza.com.main.ActiveMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.MessageProducer;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

public class Producer {
	public static void ProducePointToPoint() throws Exception {
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		Connection connection = factory.createConnection();

		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue("chate-id-001");

		MessageProducer Producer = session.createProducer(destination);

		TextMessage message = session.createTextMessage("Hello word");
		while (true) {

			Producer.send(message);
			Thread.sleep(3000);

		}

	}

}
