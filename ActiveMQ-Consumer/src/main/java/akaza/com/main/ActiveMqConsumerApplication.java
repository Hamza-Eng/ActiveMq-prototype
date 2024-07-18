package akaza.com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import akaza.com.main.ActiveMQ.Consumer_Subscriber;

@SpringBootApplication
public class ActiveMqConsumerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ActiveMqConsumerApplication.class, args);

//		Consumer.ConsumePointToPoint();
		Consumer_Subscriber.ConsumeFromManyPublisher();

	}

}
