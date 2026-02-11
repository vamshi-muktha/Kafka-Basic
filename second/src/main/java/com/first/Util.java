package com.first;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Util {
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
	@GetMapping("/getAll")
	public ArrayList<Integer> getAll(){
		return al;
	}
}
