package com.revivable.hydrogen.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisConfiguration {
    /**
     * redis消息监听器容器
     * 可以添加多个监听不同频道的redis监听器，只需要把消息监听器和相应的消息订阅处理器绑定
     * 该消息监听器通过反射调用消息订阅的相关方法进行一系列业务处理
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);

        //此处可以添加多个messageListener
        container.addMessageListener(listenerAdapter,new PatternTopic("revivable"));
        container.addMessageListener(listenerAdapter,new PatternTopic("medemo"));

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceiver messageReceiver){
        return new MessageListenerAdapter(messageReceiver,"receiveMessage");
    }

    /**
     * 使用默认的工厂初始化redis操作模板
     * @param connectionFactory
     * @return
     */
    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }
}
