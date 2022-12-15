package com.example.SortRace;

import com.example.SortRace.service.GameService;
import com.example.SortRace.service.GameServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class SortRaceApplication {

	public static void main(String[] args) {
		GameService gameService=new GameServiceImpl();
		gameService.create();
		SpringApplication.run(SortRaceApplication.class, args);
	}

}
