package com.chat.app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.chat.app.model.ChatMessage;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ChatController {

    //Because its a chat group, a person sending message should be visible to everyone right!!, so any who sends message at the end point `/app/sendMessage`, his message get's broadcasted to everyone in the group, and the group is basically a topic with endpoint "/topic/messages"
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    @GetMapping("chat")
    public String chat() {
        return "chat";
    }
    
}
