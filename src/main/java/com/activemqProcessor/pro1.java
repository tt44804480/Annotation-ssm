package com.activemqProcessor;

import org.apache.activemq.advisory.ConsumerEvent;
import org.apache.activemq.advisory.ConsumerListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 处理activemq 地址是activemq.queue1 的消息
 */
@Component(value = "messageListener1")
public class pro1 implements MessageListener{

    //此方法为消费者消费的具体实现，处于单线程环境，只有这个消息消费完了  才会来下一个消息
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            Thread.sleep(2000);
            System.out.println("接收到了:"+textMessage.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
