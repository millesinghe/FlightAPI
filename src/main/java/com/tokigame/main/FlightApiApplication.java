package com.tokigame.main;

import com.tokigame.flight.core.DataExtractor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@ComponentScan({"com.tokigame.flight.api"})
public class FlightApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightApiApplication.class, args);
	}

	@Bean
	@Primary
	public void initServices() {
		DataExtractor ee = DataExtractor.getInstance();
		ee.extractAll();
	}
}
