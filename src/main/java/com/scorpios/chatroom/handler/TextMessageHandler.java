package com.scorpios.chatroom.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Think
 * @Title: TextMessageHandler
 * @ProjectName chatroom
 * @Description: TODO
 * @date 2019/3/1018:08
 */
public class TextMessageHandler extends TextWebSocketHandler {

    Map<String,WebSocketSession> allClients = new HashMap<>();

     /**
     * 当连接建立的时候调用
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String name = (String) session.getAttributes().get("name");
        if(name != null){
            allClients.put(name,session);
        }
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(new String(message.asBytes()));
        String toUser = jsonObject.getString("toUser");
        String toMessage = jsonObject.getString("toMessage");
        String fromUser = (String) session.getAttributes().get("name");
        String content = "收到来自"+fromUser+"的消息，内容是："+toMessage;
        TextMessage textMessage = new TextMessage(content);
        sendMessage(toUser,textMessage);
    }

    /**
     * 当连接关闭的时候
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }


    public void sendMessage(String toUser,TextMessage message){
        WebSocketSession session = allClients.get(toUser);
        if(session != null && session.isOpen()) {
            try {
                session.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
