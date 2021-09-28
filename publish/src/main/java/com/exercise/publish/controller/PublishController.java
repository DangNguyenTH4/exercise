package com.exercise.publish.controller;

import com.exercise.publish.publish.KafkaPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/publish")
public class PublishController {
    @Autowired
    private KafkaPublishService kafkaPublishService;
    @GetMapping("/{message}")
    public ResponseEntity<String> publish(@PathVariable String message){
        kafkaPublishService.sendMessage(message);
        return null;
    }
}
