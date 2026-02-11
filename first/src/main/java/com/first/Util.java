package com.first;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Util {
//	@Autowired
//	FeignApi fa;
	
	@Autowired
	EventProducer producer;
	
	ArrayList<Integer> al;
	Util(){
		al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
	}
	@PostMapping("/{i}")
	public void save(@PathVariable int i) {
		al.add(i);
	}
	@GetMapping("/home")
	public String welcome() {
		return "Hello Welcome";
	}
//	@GetMapping("/getAllB")
//	public ArrayList<Integer> getAllB(){
//		return fa.getAll();
//	}
	
	@PostMapping("/publish")
    public String publish(@RequestParam String msg) {
        producer.send(new TestEvent(msg));
        return "Event published";
    }
}
