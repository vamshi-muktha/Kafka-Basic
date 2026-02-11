package com.first;

import java.util.ArrayList;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "SECOND")
public interface FeignApi {
	@GetMapping("/getAll")
	public ArrayList<Integer> getAll();
}
