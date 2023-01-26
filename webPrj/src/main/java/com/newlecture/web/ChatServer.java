package com.newlecture.web;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatServer {
	
	static CopyOnWriteArrayList<Session> sessions = new CopyOnWriteArrayList<>();
	
	// OPEN
	@OnOpen
	public void openHandler(Session session) {
		System.out.println("connected from ");
		sessions.add(session);
	}
	
	// MESSAGE
	@OnMessage
	public void massageHandler(Session session, String message) throws IOException {
		System.out.println(message);
		for(Session s : sessions)
			s.getBasicRemote().sendText(message);
	}
	
	// CLOSE
	@OnClose
	public void closeHandler(Session session) {
		sessions.remove(session);
	}
}
