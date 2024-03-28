package com.example.mybatis.demo.mybatisdemo.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
//websocket을 활성화 하기 위해서 지정하는 어노테이션
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    WebSocketHandler webSocketHandler;

	@SuppressWarnings("null")
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //웹 소켓 endpoint 등록
        //origin은 편의상 모두 허용
        registry.addHandler(webSocketHandler, "/websocket")
                .addInterceptors(new HttpSessionHandshakeInterceptor())
                .setAllowedOrigins("*");
    }

    // 버퍼 설정
	// @Bean
	// public ServletServerContainerFactoryBean createWebSocketContainer() {
	// 	ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
	// 	//Text Message의 최대 버퍼 크기 설정
	// 	container.setMaxTextMessageBufferSize(8192);
	// 	//Binary Message의 최대 버퍼 크기 설정
	// 	container.setMaxBinaryMessageBufferSize(8192);
	// 	return container;
	// }
}