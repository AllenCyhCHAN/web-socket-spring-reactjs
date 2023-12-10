package com.allenchan.chatserver.controllers.model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {
    private String senderName;
    private String receiverName;
    private String message;
    private Date date;
    private Status status;
}


// TODO: Handle the sender and receiver in ID format to better identify
// TODO: encryption might be needed for the message