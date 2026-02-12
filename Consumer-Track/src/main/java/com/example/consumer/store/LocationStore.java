package com.example.consumer.store;

import com.example.consumer.model.LocationEvent;
import org.springframework.stereotype.Component;

@Component
public class LocationStore {

    private volatile LocationEvent latest;

    public void update(LocationEvent event) {
        this.latest = event;
    }

    public LocationEvent getLatest() {
        return latest;
    }
}
