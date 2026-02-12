package com.example.producer.service;

import com.example.producer.model.LocationEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.Random;

@Service
public class LocationProducerService {

//    private final KafkaTemplate<String, Object> kafkaTemplate;
//    private static final String TOPIC = "car-location";
//
//    public LocationProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @PostConstruct
//    public void startSending() throws InterruptedException {
//
//        Random random = new Random();
//
//        double lat = 17.3850;
//        double lon = 78.4867;
//
//        while (true) {
//            lat += random.nextDouble() / 1000;
//            lon += random.nextDouble() / 1000;
//
//            LocationEvent event = new LocationEvent(
//                    "CAR_101",
//                    lat,
//                    lon,
//                    random.nextInt(80),
//                    System.currentTimeMillis()
//            );
//
//            kafkaTemplate.send(TOPIC, event);
//
//            System.out.println("Sent location: " + event.getLatitude() + ", " + event.getLongitude());
//
//            Thread.sleep(1000);
//        }
//    }
}
