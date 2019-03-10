package com.scorpios.chatroom.methodone.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * @author Think
 * @Title: ChatInterceptor
 * @ProjectName chatroom
 * @Description: TODO
 * @date 2019/3/1017:57
 */
public class ChatInterceptor extends HttpSessionHandshakeInterceptor {


    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        System.out.println("握手");
        String url = request.getURI().toString();
        String name = url.substring(url.lastIndexOf("/") + 1);
        attributes.put("name",name);
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        System.out.println("握手之后");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
