package com.example.consumer.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.consumer.model.LocationEvent;
import com.example.consumer.store.LocationStore;
@Service
public class LocationConsumerService {

    private final LocationStore store;

    public LocationConsumerService(LocationStore store) {
        this.store = store;
    }

    @KafkaListener(topics = "car-location", groupId = "tracking-group")
    public void consume(LocationEvent event) {

        // 🔍 DEBUG LINE (Kafka thread)
//        System.out.println("Kafka thread store hash: " + store.hashCode());

        store.update(event);

        System.out.println(
            "📍 Car " + event.getVehicleId() +
            " at (" + event.getLatitude() +
            ", " + event.getLongitude() +
            ") speed=" + event.getSpeed()
        );
    }
}
