package com.olaaref.chat.controller;

import com.olaaref.chat.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    /**
     * Handles incoming chat messages and broadcasts them to the public topic.
     * This method is mapped to the "/chat.sendMessage" destination.
     * When a message is sent to this destination, it will be broadcasted to all subscribers of the "/topic/public" topic.
     *
     * @param chatMessage the chat message payload
     * @return the chat message to be broadcasted
     */
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }


    /**
     * Handles adding a new user to the chat and broadcasts the user join message to the public topic.
     * This method is mapped to the "/chat.addUser" destination.
     * When a user joins, their username is added to the WebSocket session attributes and a join message is broadcasted to all subscribers of the "/topic/public" topic.
     *
     * @param chatMessage the chat message payload containing the username
     * @param headerAccessor the WebSocket message header accessor
     * @return the chat message to be broadcasted
     */
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in web socket session
        headerAccessor
                .getSessionAttributes()
                .put("username", chatMessage.getSender());
        return chatMessage;
    }

}
