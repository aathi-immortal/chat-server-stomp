    package com.socketserver.server.model;

    import lombok.Data;

    @Data
    public class Message {
        private String senderName;
        private String receiverName;
        private String messageContent;
        private Status status;

    }
