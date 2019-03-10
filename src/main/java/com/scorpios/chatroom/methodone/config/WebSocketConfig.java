package com.scorpios.chatroom.methodone.config;

import com.scorpios.chatroom.methodone.handler.TextMessageHandler;
import com.scorpios.chatroom.methodone.interceptor.ChatInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author Think
 * @Title: WebSocketConfig
 * @ProjectName chatroom
 * @Description: TODO
 * @date 2019/3/1014:14
 */

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {

        webSocketHandlerRegistry.addHandler(getHandler(),"/websocket/*").addInterceptors(new ChatInterceptor());
    }

    public TextMessageHandler getHandler(){
        return new TextMessageHandler();
    }

}
