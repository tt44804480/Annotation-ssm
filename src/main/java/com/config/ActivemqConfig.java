package com.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.MessageListener;

@Configuration
@PropertySource(value = {"classpath:appContext.properties"})
public class ActivemqConfig {

    @Value("${activemq.url}")
    public String URL;

    @Value("${activemq.queue1}")
    public String QUEUENAME_1;

    @Value("${activemq.queue2}")
    public String QUEUENAME_2;


    //创建一个activemq实现的连接工厂
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(URL);
        return activeMQConnectionFactory;
    }

    //使用spring为我们提供的连接工厂
    @Bean
    public SingleConnectionFactory singleConnectionFactory(ActiveMQConnectionFactory activeMQConnectionFactory){

        SingleConnectionFactory singleConnectionFactory = new SingleConnectionFactory();
        singleConnectionFactory.setTargetConnectionFactory(activeMQConnectionFactory);

        return singleConnectionFactory;
    }

    @Bean
    public ActiveMQQueue activeMQQueue_1(){
        return new ActiveMQQueue(QUEUENAME_1);
    }

    @Bean
    public ActiveMQQueue activeMQQueue_2(){
        return new ActiveMQQueue(QUEUENAME_2);
    }

    //创建spring提供的模板发送消息
    @Bean
    public JmsTemplate jmsTemplate(SingleConnectionFactory singleConnectionFactory){
        return new JmsTemplate(singleConnectionFactory);
    }

    //创建接收消息的容器1
    @Bean
    public DefaultMessageListenerContainer defaultMessageListenerContainer_1(SingleConnectionFactory singleConnectionFactory, ActiveMQQueue activeMQQueue_1, MessageListener messageListener1){
        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
        defaultMessageListenerContainer.setConnectionFactory(singleConnectionFactory);
        defaultMessageListenerContainer.setDestination(activeMQQueue_1);
        defaultMessageListenerContainer.setMessageListener(messageListener1);
        return defaultMessageListenerContainer;
    }
}
