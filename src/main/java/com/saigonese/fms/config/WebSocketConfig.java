package com.saigonese.fms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
@EnableScheduling
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
//		System.out.println("***configureMessageBroker");
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/ChatApp");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
//		System.out.println("***registerStompEndpoints");
		registry.addEndpoint("/ws").withSockJS();
	}
}