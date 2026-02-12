package com.example.consumer.controller;

import com.example.consumer.model.LocationEvent;
import com.example.consumer.store.LocationStore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrackingController {

    private final LocationStore store;

    public TrackingController(LocationStore store) {
        this.store = store;
    }

    @GetMapping("/track")
    public String showTracking(Model model) {
        LocationEvent latest = store.getLatest();
//        System.out.println("Controller store hash: " + store.hashCode());

//        System.out.println("🧭 Controller sees: " + latest);
        model.addAttribute("location", latest);
        return "tracking";
        
    }

}
