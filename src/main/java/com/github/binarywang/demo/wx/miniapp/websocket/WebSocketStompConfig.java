package com.github.binarywang.demo.wx.miniapp.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Package com.github.binarywang.demo.wx.miniapp.websocket
 * @ClassName WebSocketStompConfig
 * @Author shaobin.wang
 * @Date 2019/10/29 11:42
 * @Version 1.0
 * @Description:
 **/
@Configuration
public class WebSocketStompConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
