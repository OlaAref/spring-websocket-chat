package com.olaaref.chat.config;

import com.olaaref.chat.dto.ChatMessage;
import com.olaaref.chat.enums.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
    private final SimpMessageSendingOperations messagingTemplate;

    /**
     * Handles WebSocket disconnection events.
     * This method listens for `SessionDisconnectEvent` and processes the event when a user disconnects.
     * It retrieves the username from the WebSocket session attributes and logs the disconnection.
     * A `ChatMessage` of type `LEAVE` is then created and broadcasted to the "/topic/public" topic.
     *
     * @param event the WebSocket session disconnect event
     */
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
            log.info("User Disconnected: {}", username);
            var chatMessage = ChatMessage
                    .builder()
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .build();
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }

}
