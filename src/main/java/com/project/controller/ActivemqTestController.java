package com.project.controller;

import com.common.ActivemqTools;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@RequestMapping("/activemqTestController")
@Controller
public class ActivemqTestController {

    @Autowired
    JmsTemplate jmsTemplate;

    @Qualifier("activeMQQueue_1")
    @Autowired
    ActiveMQQueue activeMQQueue;

    @Autowired
    ActivemqTools activemqTools;

    Logger logger = LoggerFactory.getLogger(ActivemqTestController.class);

    @RequestMapping("/test1")
    public void test1(String message) throws JMSException {

        for(int i = 0;i<10;i++){

            jmsTemplate.send(activeMQQueue, activemqTools.getStringMessageCreator(message));
        }

        System.out.println("发送消息："+message);
    }
}
