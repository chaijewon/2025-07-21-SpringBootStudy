package com.sist.web.security;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import lombok.RequiredArgsConstructor;

import java.security.*; // Principal
@Component
@RequiredArgsConstructor
public class WebSockerListener {
   private final WebSocketSessionRegistry wsRegistry;
   private final SimpMessagingTemplate template;
   private final UserSessionRegistry userRegistry;
   // Stomp => javascript : Stomp (Storm) , SockJS
   // User 접속 
   @EventListener
   public void connect(SessionConnectEvent event) {
	   StompHeaderAccessor acc=
			   StompHeaderAccessor.wrap(event.getMessage());
	   Principal p=acc.getUser();
	   if(p==null) return;
	   String userid=p.getName();
	   String sessionId=acc.getSessionId();
	   
	   wsRegistry.register(userid, sessionId);
	   userRegistry.add(userid);
	   //  접속시 저장 
	   // 접속자 목록 갱신
	   template.convertAndSend(
	      "/topic/users",
	      userRegistry.getUsers()
	   );
	   
   }
   // User 해제 
   @EventListener
   public void disconnect(SessionDisconnectEvent event) {
	   StompHeaderAccessor acc=
			   StompHeaderAccessor.wrap(event.getMessage());
	   Principal p=acc.getUser();
	   if(p==null) return;
	   String userid=p.getName();
	   String sessionId=acc.getSessionId();
	   wsRegistry.unregister(userid, sessionId);
	   userRegistry.remove(userid);
	   
	   template.convertAndSend(
			      "/topic/users",
			      userRegistry.getUsers()
	   );
	   
   }
}
