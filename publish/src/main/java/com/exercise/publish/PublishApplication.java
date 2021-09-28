package com.exercise.publish;

import com.exercise.publish.publish.KafkaPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class PublishApplication implements CommandLineRunner {
	@Autowired
	private KafkaPublishService kafkaPublishService;
	public static void main(String[] args) {
		SpringApplication.run(PublishApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

	@Scheduled(cron = " 0/3 * * * * ? ")
	public void send(){
		kafkaPublishService.sendMessage(new Date().toString());
	}
}
