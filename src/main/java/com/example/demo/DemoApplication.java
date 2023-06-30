package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private JmsTemplate template;

	@Value("${spring.jms.servicebus.destination}")
	private String destination;

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("sending the 1st message");
		template.convertAndSend(destination, "message 1");
		Duration duration = Duration.ofMinutes(10);
		LOGGER.info("waiting for {} seconds", duration.getSeconds());
		TimeUnit.SECONDS.sleep(duration.getSeconds());
		LOGGER.info("sending the 2nd message");
		template.convertAndSend(destination, "message 2");
	}
}
