package com.example.janustextsample.util;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ProducerManager {
    private static ProducerManager instance;
    public static Session session;
    public static Destination destination;
    public static MessageProducer producer;

    static {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;
        try {
            connection = factory.createConnection("admin", "password");
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("defaultQueue");
            producer = session.createProducer(destination);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public ProducerManager() {
    }

    public static ProducerManager getInstance(){
        if (instance==null){
            instance = new ProducerManager();
        }
        return instance;
    }

////    public MessageProducer createProducer(String queueName) throws JMSException {
//    public MessageProducer createProducer() throws JMSException {
////        Destination destination = session.createQueue(queueName);
//        return session.createProducer(destination);
//
//    }

//    public void sendMessage(MessageProducer producer, String message) throws JMSException {
    public void sendMessage( String message) throws JMSException {
//        MessageProducer producer = getInstance().createProducer();
        TextMessage msg = session.createTextMessage(message);
        producer.send(msg);
//        msg.acknowledge();
    }
}
