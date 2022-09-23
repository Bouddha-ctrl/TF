package com.ufr.croissantshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class CroissantshowApplication {

	@GetMapping("/greeting")
	public String greeting(){
		System.out.println("he");
		return "Hello";
	}


	public static void main(String[] args) {


		SpringApplication.run(CroissantshowApplication.class, args);
		System.out.println("Hello word!");
	}

}
