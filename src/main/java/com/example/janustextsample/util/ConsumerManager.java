package com.example.janustextsample.util;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumerManager {
    private static ConsumerManager instance;
    public static Session session;
    public static Destination destination;
    public static MessageConsumer consumer;

    static {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;
        try {
            connection = factory.createConnection("admin", "password");
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("defaultQueue");
            consumer = session.createConsumer(destination);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }


    public ConsumerManager() {
    }

    public static ConsumerManager getInstance(){
        if (instance==null){
            instance = new ConsumerManager();
        }
        return instance;
    }

////    public MessageConsumer createConsumer(String queueName) throws JMSException {
//    public MessageConsumer createConsumer() throws JMSException {
////        Destination destination = session.createQueue(queueName);
//        return session.createConsumer(destination);
//    }

//    public Message receiveMessage(MessageConsumer consumer) throws JMSException {
    public Message receiveMessage() throws JMSException {
//        MessageConsumer consumer = getInstance().createConsumer();
        Message msg = consumer.receive();
        String body = ((TextMessage) msg).getText();
//        System.out.println("in consumer manager , Received = "+body);
        return msg;
    }
}
