package com.cosoftia.granja;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.annotation.PostConstruct;

@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@SpringBootApplication
public class AppGranjaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppGranjaApiApplication.class, args);
	}
	
	@PostConstruct
    public void executeAfterMain() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Bogota"));
    }

}
