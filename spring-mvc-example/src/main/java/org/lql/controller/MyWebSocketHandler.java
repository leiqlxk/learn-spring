package org.lql.controller;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * Title: MyWebSocketHandler <br>
 * ProjectName: learn-spring <br>
 * description: websocket <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/31 14:27 <br>
 */
public class MyWebSocketHandler extends AbstractWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 处理文本消息
        System.out.println("收到消息" + message.getPayload());
        // 模拟延时
        Thread.sleep(2000);
        // 发送文本消息
        System.out.println("发送消息：hello world！");
        session.sendMessage(new TextMessage("hello world"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("建立新连接");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("关闭连接");
    }
}
