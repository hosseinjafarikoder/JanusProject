package com.example.janustextsample.activeMqTest;



import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.qpid.jms.JmsConnectionFactory;

// JMS API types
import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.Destination;
import javax.jms.TextMessage;
import javax.jms.MessageProducer;

import java.util.Scanner;

class ProducerTest {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//        JmsConnectionFactory factory = new JmsConnectionFactory("amqp://localhost:5672");
        Connection connection = factory.createConnection("admin", "password");
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = null;
        destination = session.createQueue("MyQueue");


        MessageProducer producer = session.createProducer(destination);

        System.out.println("enter a message : ");
        String enteredMsg = sc.next();

        TextMessage msg = session.createTextMessage(enteredMsg);
        producer.send(msg);

    }
}