package com.pr.gameserver;

import com.pr.gameserver.application.sockets.server.MessageProcessor;
import com.pr.gameserver.application.websockets.server.WebServer;
import jakarta.websocket.DeploymentException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameServerApplication {

	public static void main(String[] args) {
		// Runs the Websocket connection
		WebServer wsServer = new WebServer();

		try {
			wsServer.start();
		} catch (DeploymentException e) {
			throw new RuntimeException(e);
		}

		// Run Spring Boot
		SpringApplication.run(GameServerApplication.class, args);

		// Runs the Socket LAN connection
		MessageProcessor.init();
	}

}
