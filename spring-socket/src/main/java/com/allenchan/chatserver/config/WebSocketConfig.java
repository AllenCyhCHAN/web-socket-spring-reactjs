package com.allenchan.chatserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
        // The "/ws" endpoint allows clients to connect to the WebSocket server
        // setAllowedOriginPatterns("*") allows connections from any origin
        // withSockJS() enables fallback options for browsers that don't support WebSocket natively
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        // The "/app" prefix is used for messages that are routed to @MessageMapping handlers

        registry.enableSimpleBroker("/chatroom","/user");
        // Enable a simple message broker with two destination prefixes
        // "/chatroom" is used for broadcasting messages to all subscribed clients in a chatroom
        // "/user" is used for sending messages to specific users (private messages)

        registry.setUserDestinationPrefix("/user");
        // The "/user" prefix is used for messages that are sent to individual users
        // This allows the server to send messages directly to specific users
    }
}