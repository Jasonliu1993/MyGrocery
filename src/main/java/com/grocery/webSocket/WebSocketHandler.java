package com.grocery.webSocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;

@Component
public class WebSocketHandler extends TextWebSocketHandler{

    //连接建立后处理
    @Override
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
        System.out.println("connection established");
//        WebSocketSessionUtil.add(getUserNameFromSession(session), session);
    }

    //接收文本消息，并发送出去
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        System.out.println("receive a message." + message);

//        WebSocketSessionUtil.broadcast(message);
    }

    //抛出异常时处理
    @Override
    public void handleTransportError(WebSocketSession session,
                                     Throwable exception) throws Exception {
//        WebSocketSessionUtil.remove(getUserNameFromSession(session));
    }

    //连接关闭后处理
    @Override
    public void afterConnectionClosed(WebSocketSession session,
                                      CloseStatus closeStatus) throws Exception {
        System.out.println("conection closed." + closeStatus);

//        WebSocketSessionUtil.add(getUserNameFromSession(session), session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    private String getUserNameFromSession(WebSocketSession session) {
        Map<String, Object> params = session.getAttributes();

        return params.get("userName").toString();
    }

}
