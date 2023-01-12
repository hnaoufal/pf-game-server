package com.pr.gameserver.application.websockets;

import com.pr.gameserver.application.websockets.dto.GameSyncIncomingMessage;
import com.pr.gameserver.application.websockets.dto.GameSyncOutgoingMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GameSyncController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GameSyncOutgoingMessage greeting(GameSyncIncomingMessage message) throws Exception {
        Thread.sleep(1000);
        return new GameSyncOutgoingMessage("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
