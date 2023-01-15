package com.ragemouse.staticlistofcities.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.time.LocalTime;

@Component
@Slf4j
public class EventHandler extends TextWebSocketHandler implements WebSocketHandler {



    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

    }
}


