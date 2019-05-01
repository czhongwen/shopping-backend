package com.zhongwen.shopping.webSocket;

import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author caozw
 * @version 1.0
 * @data 2019-04-30 15:19
 **/

@Component
@ServerEndpoint("/webSocket")
public class MyWebSocket {

    private Session session;

    private static CopyOnWriteArraySet<MyWebSocket> webSockets=new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSockets.add(this);
        System.out.println("有新的连接，总数"+webSockets.size());
    }

    @OnClose
    public void onClose(){
        webSockets.remove(this);
        System.out.println("有新的断开，总数"+webSockets.size());
    }

    @OnMessage
    public void onMessage(String message){

        System.out.println(message);

        send(message);
    }

    public void send(String message){
        for (MyWebSocket webSocket:webSockets){
            try {
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}