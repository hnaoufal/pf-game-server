package com.pr.gameserver.application.websockets.server;

import com.pr.gameserver.application.websockets.common.StaticData;
import jakarta.websocket.DeploymentException;
import org.glassfish.tyrus.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** A WebSocket server for handling hello message requests. */
public class WebServer {
    private static final Logger log = LoggerFactory.getLogger(WebServer.class);

    private static final String SERVER_HOSTNAME = "localhost";

    private Server server;

    public static final String SERVER_ADDRESS = StaticData.getServerAdress(SERVER_HOSTNAME);

    /**
     * Starts the server executing.
     *
     * @throws DeploymentException if there was an error starting the server and
     *                             deploying the server websocket endpoint to it.
     */
    public void start() throws DeploymentException {
            log.info("Starting server for " + SERVER_ADDRESS);

            server = new Server(
                    SERVER_HOSTNAME,
                    StaticData.SERVER_PORT,
                    StaticData.SERVER_CONTEXT_PATH,
                    null,
                    WsServerEndpoint.class
            );

            try {
                server.start();
            } catch(DeploymentException e) {
            }
    }

    /**
     * Shuts down the server.
     */
    public void stop() {
        if (server != null) {
            log.info("Stopping server for " + SERVER_ADDRESS);

            server.stop();
        }
    }



}
