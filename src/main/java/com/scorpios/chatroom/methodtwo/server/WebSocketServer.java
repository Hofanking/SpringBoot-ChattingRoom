package com.scorpios.chatroom.methodtwo.config.server;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Think
 * @Title: WebSocketServer
 * @ProjectName chatroom
 * @Description: TODO
 * @date 2019/3/1020:23
 */

/**
 * 方式二
 */
//
//@ServerEndpoint("/websocket/{name}")
//@Component
//public class WebSocketServer {
//
//    private static Map<String,Session> allClients = new HashMap<>();
//
//    private String name;
//
//    private Session session;
//
//    /**
//     * 连接建立成功调用的方法*/
//    @OnOpen
//    public void onOpen(@PathParam("name") String name,Session session) {
//        this.name = name;
//        this.session = session;
//        allClients.put(name,session);
//    }
//
//    /**
//     * 连接关闭调用的方法
//     */
//    @OnClose
//    public void onClose() {
//
//    }
//
//    /**
//     * 收到客户端消息后调用的方法
//     *
//     * @param message 客户端发送过来的消息*/
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        JSONObject jsonObject = JSONObject.parseObject(message);
//        String to = jsonObject.getString("toUser");
//        String toMessage = jsonObject.getString("toMessage");
//        Session toSession = allClients.get(to);
//
//        if(toSession != null){
//            if(toSession.isOpen()){
//                toSession.getAsyncRemote().sendText(toMessage);
//            }else{
//                session.getAsyncRemote().sendText("对方不在线");
//            }
//        }
////        String content = "收到来自"+fromUser+"的消息，内容是："+toMessage;
////        TextMessage textMessage = new TextMessage(content);
////        sendMessage(toUser,textMessage);
//    }
//
//    /**
//     *
//     * @param session
//     * @param error
//     */
//    @OnError
//    public void onError(Session session, Throwable error) {
//    }
//
//
//    public void sendMessage(String message) throws IOException {
//
//    }
//
//
//    /**
//     * 群发自定义消息
//     * */
//    public static void sendInfo(String message) throws IOException {
//
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Session getSession() {
//        return session;
//    }
//
//    public void setSession(Session session) {
//        this.session = session;
//    }
//}
