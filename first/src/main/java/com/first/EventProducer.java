package com.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class EventProducer {

    private static final String TOPIC = "test-events";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void send(TestEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}

