package com.revivable.hydrogen.configuration;

import org.springframework.stereotype.Component;

/**
 * 自定义一个消息处理器
 */
@Component
public class MessageReceiver {
    public void receiveMessage(String message){
        System.out.println("收到消息："+message);
    }
}
