package com.first;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumer {

    @KafkaListener(topics = "test-events", groupId = "second-group")
    public void consume(TestEvent event) {
        System.out.println("Consumed event: " + event.getMessage());
    }
}

