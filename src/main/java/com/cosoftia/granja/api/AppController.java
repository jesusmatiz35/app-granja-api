package com.cosoftia.granja.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "health")
public class AppController {
	
	@GetMapping(path = "")
	public ResponseEntity<Void> health() {
		
		return ResponseEntity.ok().build();
	}

}
