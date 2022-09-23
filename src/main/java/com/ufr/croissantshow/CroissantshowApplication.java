package com.ufr.croissantshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CroissantshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(CroissantshowApplication.class, args);
	}

}
