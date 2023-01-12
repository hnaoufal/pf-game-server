package com.pr.gameserver.infrastructre.sessions;

class WSGameSession { }

/*
package com.pr.gameserver.infrastructre.sessions;

import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;

@Component
class WSGameSession implements StompSessionHandler {
    private StompSession stompSession;

    @Override
    public void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {
        this.stompSession = stompSession;
        stompSession.subscribe("/topic/greetings", this);
    }

    public void broadcastMessage(String message) {
        stompSession.send("/app/hello", message);
    }
}
*/
