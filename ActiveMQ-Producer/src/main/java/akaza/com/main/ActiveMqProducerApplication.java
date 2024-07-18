package akaza.com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import akaza.com.main.ActiveMQ.Producer;
import akaza.com.main.ActiveMQ.Producer_Publisher;

@SpringBootApplication
public class ActiveMqProducerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ActiveMqProducerApplication.class, args);
//		Producer.ProducePointToPoint();
		Producer_Publisher.publishToManySubscriber();

	}

}
