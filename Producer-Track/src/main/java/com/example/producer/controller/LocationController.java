package com.example.producer.controller;

import java.util.Map;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.producer.model.LocationEvent;

@RestController
public class LocationController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public LocationController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/location")
    public void receiveLocation(@RequestBody Map<String, Object> payload) {

        LocationEvent event = new LocationEvent(
                "PHONE1",
                ((Number) payload.get("lat")).doubleValue(),
                ((Number) payload.get("lon")).doubleValue(),
                payload.get("vel") == null ? 0 : ((Number) payload.get("vel")).intValue(),
                System.currentTimeMillis()
        );

        kafkaTemplate.send("car-location", event);

        System.out.println("📲 Phone location sent to Kafka: " + event.getLatitude());
    }
}

