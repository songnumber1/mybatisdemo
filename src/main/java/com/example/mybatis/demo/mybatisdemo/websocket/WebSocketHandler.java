package com.example.mybatis.demo.mybatisdemo.websocket;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler {
	private final Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

	//websocket handshake가 완료되어 연결이 수립될 때 호출
	@Override
	public void afterConnectionEstablished(@SuppressWarnings("null") WebSocketSession session) throws Exception {
		log.info("connection established, session id={}", session.getId());
		sessionMap.putIfAbsent(session.getId(), session);
	}

	//websocket 오류가 발생했을 때 호출
	@Override
	public void handleTransportError(@SuppressWarnings("null") WebSocketSession session, @SuppressWarnings("null") Throwable exception) throws Exception {
		log.error("session transport exception, session id={}, error={}", session.getId(), exception.getMessage());
		sessionMap.remove(session.getId());
	}

	//websocket 세션 연결이 종료되었을 때 호출
	@Override
	public void afterConnectionClosed(@SuppressWarnings("null") WebSocketSession session, @SuppressWarnings("null") CloseStatus status) throws Exception {
		log.info("connection closed, sesson id={}, close status={}", session.getId(), status);
		sessionMap.remove(session.getId());
	}

	//websocket sessoin 으로 메시지가 수신되었을 때 호출
	@Override
	protected void handleTextMessage(@SuppressWarnings("null") WebSocketSession session, @SuppressWarnings("null") TextMessage message) throws Exception {
    	//getPayload를 통해 websocket 메시지 payload를 가져온다.
		String payload = message.getPayload();
		log.info("received message, session id={}, message={}", session.getId(), payload);
		//broadcasting message to all session
		sessionMap.forEach((sessionId, session1) -> {
			try {
				session1.sendMessage(message);
			} catch (IOException e) {
				log.error("fail to send message to session id={}, error={}",
					sessionId, e.getMessage());
			}
		});
	}
}