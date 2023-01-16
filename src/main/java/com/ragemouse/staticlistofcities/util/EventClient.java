package com.ragemouse.staticlistofcities.util;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class EventClient {

    public static void createEventClient(String allCities) throws ExecutionException, InterruptedException {
        String uri = "ws://localhost:2711/cities";

        StandardWebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new StringMessageConverter());
        CompletableFuture<StompSession> future = stompClient.connectAsync(uri, new EventHandler());
        StompSession session;
        session = future.get();
        session.send("/topic/cities", allCities);


    }
}
