package com.example.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumer.model.LocationEvent;
import com.example.consumer.store.LocationStore;

@RestController
@RequestMapping("/api")
public class TrackingRestController {

    private final LocationStore store;

    public TrackingRestController(LocationStore store) {
        this.store = store;
    }

    @GetMapping("/location")
    public LocationEvent getLatestLocation() {
        return store.getLatest();
    }
}

