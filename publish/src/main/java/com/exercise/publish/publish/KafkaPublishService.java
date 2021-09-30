package com.exercise.publish.publish;

import com.exercise.publish.model.MessageHistory;
import com.exercise.publish.repository.MessageHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Service
@Slf4j
public class KafkaPublishService {
    private final String TOPIC = "test";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private MessageHistoryRepository messageHistoryRepository;

    public void sendMessage(String message){
        log.info("Send a message to topic : {} ", message);

        kafkaTemplate.send(TOPIC, message).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Kafka unable to send message='{}'", message, ex);
                saveHistory(null,message,"FAILED");

            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Kafka sent message='{}' with offset={}, {}", message,
                        result.getRecordMetadata().offset(), result);
                saveHistory(result.getRecordMetadata().offset(),message,"SUCCESSED");
            }
        });
    }

    private void saveHistory(Long offset, String message, String status){
        String id = UUID.randomUUID().toString();
        MessageHistory history = new MessageHistory(id, offset,status, message);
        messageHistoryRepository.save(history);

    }

}
