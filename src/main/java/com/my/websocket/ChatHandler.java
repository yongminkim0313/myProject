package com.my.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatHandler extends TextWebSocketHandler {

	private static Map<String, WebSocketSession> sessionUsers = new HashMap<String, WebSocketSession>();

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		String userNickName = (String) session.getHandshakeAttributes().get("userNickName");
		System.out.println(userNickName + "¥‘¿Ã ∏ﬁºº¡ˆ∏¶ ∫∏≥¿¥œ¥Ÿ.");
		System.out.println("@@@@@@@@@@@@@@@@@@@handleMessage@@@@@@@@@@@@@@@@@@@@@");
		super.handleMessage(session, message);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		String userNickName = (String) session.getHandshakeAttributes().get("userNickName");
		System.out.println(userNickName + "¥‘¿Ã ¿‘¿Â«œºÃΩ¿¥œ¥Ÿ.");
		sessionUsers.put(userNickName, session);
		System.out.println("@@@@@@@@@@@@@@@@@@@afterConnectionEstablished@@@@@@@@@@@@@@@@@@@@@");
		super.afterConnectionEstablished(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		String userNickName = (String) session.getHandshakeAttributes().get("userNickName");
		System.out.println(userNickName + "¥‘¿Ã ≥™∞°ºÃΩ¿¥œ¥Ÿ.");
		sessionUsers.remove(userNickName);
		System.out.println("@@@@@@@@@@@@@@@@@@@afterConnectionClosed@@@@@@@@@@@@@@@@@@@@@");
		super.afterConnectionClosed(session, status);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		String userNickName = (String) session.getHandshakeAttributes().get("userNickName");
		System.out.println(userNickName + "¥‘¿Ã ∏ﬁºº¡ˆ∏¶ ∫∏≥¿¥œ¥Ÿ.");

		String payload = message.getPayload();
		System.out.println("payload : " + payload);

		session.sendMessage(message);

		System.out.println("@@@@@@@@@@@@@@@@@@@handleTextMessage@@@@@@@@@@@@@@@@@@@@@");
//		super.handleTextMessage(session, message);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("@@@@@@@@@@@@@@@@@@@handleTransportError@@@@@@@@@@@@@@@@@@@@@");
		super.handleTransportError(session, exception);
	}
}
