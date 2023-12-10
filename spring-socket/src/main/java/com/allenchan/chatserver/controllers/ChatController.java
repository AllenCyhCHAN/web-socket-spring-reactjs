package com.allenchan.chatserver.controllers;

import com.allenchan.chatserver.controllers.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message) {
        // Process received message
        // TODO: Implement logic to handle the received message
        // e.g., perform business logic, store in database, etc.
        return message;
    }

    @MessageMapping("/private-message")
    public Message recMessage(@Payload Message message) {
        // Send private message to the specified user
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
//        System.out.println(message.toString());

        // TODO: Implement logic for private message handling
        // e.g., perform additional checks, apply security measures, etc.

        return message;
    }
}