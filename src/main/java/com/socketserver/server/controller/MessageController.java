package com.socketserver.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.socketserver.server.model.Message;

import ch.qos.logback.core.status.Status;

@Controller
public class MessageController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom")
    private Message recivePublicMessage(@Payload Message message) {

        // System.out.println("message rec" + message);
        Message m = new Message();
        m.setMessage("jjjj");
        m.setReceiverName("jjjder");
        m.setSenderName("jjuu");
        return m;
        // m.setMessage(message.getMessage());
        // return m;
    }

    @MessageMapping("/private")
    private Message recivePrivateMessage(@Payload Message message) {
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
        return message;
    }
}
