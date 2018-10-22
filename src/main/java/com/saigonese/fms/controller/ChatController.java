package com.saigonese.fms.controller;

import org.springframework.stereotype.Controller;

import com.saigonese.fms.domain.ChatMessage;
import com.saigonese.fms.service.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
/**
 * 
 * @author Cong Khanh Tran - trancongkhanh@gmail.com
 *
 *
 */
@Controller
public class ChatController {
	@Autowired
	ChatService chatService;

	/**
	 * WebSocket Handler to add one stock
	 */
	@MessageMapping("/send")
	@SendTo("/topic/chat")
	public ChatMessage addMessage(ChatMessage message) throws Exception {
		chatService.save(message);
		return message;
	}
}