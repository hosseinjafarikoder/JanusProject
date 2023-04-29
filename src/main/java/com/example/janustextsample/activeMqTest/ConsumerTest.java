package com.example.janustextsample.activeMqTest;


// ActiveMQ JMS Provider
import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.qpid.jms.JmsConnectionFactory;

// JMS API types
import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;
import javax.jms.*;

class ConsumerTest {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//        JmsConnectionFactory factory = new JmsConnectionFactory("amqp://localhost:5672");
        Connection connection = factory.createConnection("admin", "password");
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = null;
        destination = session.createQueue("MyQueue");

        MessageConsumer consumer = session.createConsumer(destination);

        Message msg = consumer.receive();
        String body = ((TextMessage) msg).getText();

        System.out.println("Received = "+body);

    }
}
