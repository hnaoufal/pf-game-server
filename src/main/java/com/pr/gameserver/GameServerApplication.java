package com.pr.gameserver;

import com.pr.gameserver.application.sockets.MessageProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameServerApplication {

	public static void main(String[] args) {
		// Run Spring Boot
		SpringApplication.run(GameServerApplication.class, args);
		MessageProcessor.init();
	}

}
