package com.sist.web.manager;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.*;
import java.io.*;
import java.util.*;

@ServerEndpoint(value="/chat-ws",configurator = WebSocketSessionConfigurator.class)
public class ChatManager {
  // 접속자 저장 
	private static Map<Session,ChatVO> users=
			Collections.synchronizedMap(new HashMap<Session,ChatVO>());
	
  // 접속시 처리 
  @OnOpen
  public void onOpen(Session session,EndpointConfig config)
  throws Exception
  {
	  /*ChatVO vo=new ChatVO();
	  HttpSession hs=(HttpSession)config.getUserProperties().get(HttpSession.class.getName());
	  
	  if (hs == null) {
		    System.out.println("❌ HttpSession 없음 → 연결 종료");
		    session.close();
		    return;
		}
	  vo.setId((String)hs.getAttribute("id"));
	  vo.setName((String)hs.getAttribute("name"));
	  vo.setSession(session);
	  */
	  ChatVO vo=new ChatVO();
	  users.put(session,vo);
	  
	  // 입장 메세지 
	  Iterator<Session> it=users.keySet().iterator();
	  while(it.hasNext())
	  {
		  Session ss=it.next();
		  if(ss.getId()!=session.getId())// 본인이 아닌 경우
		  {
			  ss.getBasicRemote().sendText("msg:[🔔 알림] hong님이 입장하셨습니다");
		  }
	  }
	  /*System.out.println("클라이언트 접속:"+vo.getId()+","
			  +vo.getName()+","+vo.getSession());*/
  }
  // 접속해제 처리 => 
  @OnClose
  public void onClose(Session session) throws Exception
  {
	  Iterator<Session> it=users.keySet().iterator();
	  while(it.hasNext())
	  {
		  
		  Session ss=it.next(); // 접속자 전체 
		  ChatVO vo=users.get(session); // 나가는 사람
		  // session : 접속마다 번호부여 
		  if(ss.getId()!=session.getId())// 본인이 아닌 경우
		  {
			  ss.getBasicRemote().sendText("msg:[🔔 알림]"+vo.getName()+"님이 퇴장하셨습니다");
		  }
	  }
	  System.out.println("클라이언트 접속 종료:"+users.get(session).getName());
	  users.remove(session);
  }
  // 에러 처리 
  @OnError
  public void onError(Session session,Throwable ex)
  {
	  ex.printStackTrace();
  }
  // 메세지 처리 
  @OnMessage
  public void onMessage(String message,Session session)
  throws Exception
  {
	  System.out.println("수신된 메세지:"+message+","
			  +users.get(session).getName());
	  Iterator<Session> it=users.keySet().iterator();
	  while(it.hasNext())
	  {
		  Session ss=it.next(); // 접속자 전체
		  ChatVO vo=users.get(session); // 보낸 사람 
		  if(session.getId()==ss.getId())// 본인
		  {
			  ss.getBasicRemote().sendText("my:["+vo.getName()+"]"+message);
		  }
		  else // 상대방 
		  {
			  ss.getBasicRemote().sendText("you:["+vo.getName()+"]"+message);
		  }
	  }
  }
	
}