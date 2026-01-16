package com.sist.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/chat-ws")
		        .setAllowedOriginPatterns("*")
		        .withSockJS();
	}
    /*
     *      class Function
     *      {
     *        public static final int LOGIN=100
     *      }
     */
	// STOMP 의 메세지 규칙 
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// TODO Auto-generated method stub
		registry.enableSimpleBroker("/topic","/queue");
		// /topic: 전체  /queue : 개인 
		/*
		 *   convertAndSend("/topic/chat", msg) => 전체 처리 
		 *   convertAndSend("/queue/msg", msg) => 개인 
		 */
		// 서버가 아니라 브로커로 바로 메세지 전송 => Message Hook
		registry.setApplicationDestinationPrefixes("/app");
		registry.setUserDestinationPrefix("/user");// 1:1
	}
    
}
