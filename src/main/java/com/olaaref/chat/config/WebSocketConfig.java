package com.olaaref.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Registers a STOMP endpoint at the specified URL and enables SockJS fallback options.
     * This endpoint will be used by clients to connect to the WebSocket server.
     * SockJS is used to provide fallback options for browsers that do not support WebSocket.
     *
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/ws")
                .withSockJS();
    }

    /**
     * Configures the message broker with application destination prefixes and enables a simple in-memory broker.
     * The application destination prefix is used to filter destinations targeted to application annotated methods.
     * The simple broker handles subscriptions and broadcasting messages to subscribed clients.
     *
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry
                .setApplicationDestinationPrefixes("/app")
                .enableSimpleBroker("/topic");
    }
    
}
