package com.saigonese.fms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saigonese.fms.domain.ChatMessage;
import com.saigonese.fms.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private ChatMessage lastMessage;
	
	@Override
	public ChatMessage getLastMessage() {
		
		return lastMessage;
	}

	@Override
	public void save(ChatMessage message) {
		lastMessage = message;
	}

	@Override
	public void clear() {
		lastMessage.clear();
	}
}
