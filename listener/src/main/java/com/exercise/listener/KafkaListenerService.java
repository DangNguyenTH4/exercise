package com.exercise.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaListenerService {

    @KafkaListener(topics="test", groupId = "myGroup")
    public void listen(String message) throws InterruptedException {
        log.info("Received a message: {}", message);
        Thread.sleep(3000);
        log.info("Continue");
        System.out.println("Recieved: "+ message);
    }
}
