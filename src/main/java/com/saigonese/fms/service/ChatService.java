package com.saigonese.fms.service;

import com.saigonese.fms.domain.ChatMessage;


public interface ChatService {
	public ChatMessage getLastMessage();
	public void save(ChatMessage message);
	public void clear();
}
