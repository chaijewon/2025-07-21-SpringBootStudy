package com.sist.web.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
/*
 *     1. LLM 
 *     2. RAG => 실제 데이터 수집 => AI전송 *****
 *     3. 임베디드 : LMM
 *     ---------------------------------
 */

import com.google.api.client.util.Value;


import reactor.core.publisher.Flux;
@Service
public class ChatService {
   // 연결 => 클래스가 이미 만들어져 있다 => 클래스 추상화 
   private final ChatClient chatClient; // interface
   
   
   // 초기화 => 인터페이스로 만들어져 있다 
   public ChatService(ChatClient.Builder chatClientBuilder)
   {
	    this.chatClient=chatClientBuilder.build();
   }
   
   public String syncChat(String message)
   {
	   String s=chatClient.prompt()
			   .user(message)
			   .call()
			   .content();
	   return s;
   }
   
   public Flux<String> streamChat(String userMessage)
   {
	   String systemPrompt = "You are a helpful AI assistant.\n"
	   		+ "Answer questions clearly and concisely in Korean.\n"
	   		+ "Be friendly and professional."; 

	   Flux<String> f=chatClient.prompt()
			      .system(systemPrompt)
			      .user(userMessage)
			      .stream()
			      .content()
			      .doOnNext(System.out::println);
	   System.out.println(f);
	   return f;
   }
   private Flux<String> typingEffect(String chunk) {
	    return Flux.fromArray(chunk.split("\n"))   // 글자 단위
	             .delayElements(Duration.ofMillis(100)); // 타이핑 속도
   }
}
