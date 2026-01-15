package com.sist.web.config;

import java.time.LocalTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChatController {
	/*@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(ChatMessage message) {
	message.setTime(LocalTime.now().toString());
	return message; // 모든 사용자에게 전송
	}
	
	@GetMapping("/mychat")
	public String chat()
	{
		return "chat";
	}*/
	@GetMapping("/start")
	public String start(HttpSession session)
	{
		session.setAttribute("id", "hong");
		session.setAttribute("name", "홍길동");
		return "start";
	}
	@GetMapping("/mychat")
	public String chat()
	{
		return "chat";
	}
}
