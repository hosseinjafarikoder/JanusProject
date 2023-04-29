//package com.example.janustextsample.model;
//
//import com.example.janustextsample.util.ConsumerManager;
//import com.example.janustextsample.util.ProducerManager;
//
//import javax.jms.*;
//import java.util.List;
//import java.util.Set;
//
//public class Channel {
//    private MessageProducer messageProducer;
//    private MessageConsumer messageConsumer;
//    private Message message;
//
//    private Set<String> queueNames;
//
//    public void makeChannel(String queueName) throws JMSException {
//        ProducerManager producerManager = ProducerManager.getInstance();
//        MessageProducer producer = producerManager.createProducer(queueName);
//        this.messageProducer = producer;
//        ConsumerManager consumerManager = ConsumerManager.getInstance();
//        MessageConsumer consumer = consumerManager.createConsumer(queueName);
//        this.messageConsumer = consumer;
//        this.queueNames.add(queueName);
//    }
//
//    public void sendMessage(String msg) throws JMSException {
//        ProducerManager producerManager = ProducerManager.getInstance();
//        producerManager.sendMessage(this.messageProducer,msg);
//        ConsumerManager consumerManager = ConsumerManager.getInstance();
//        Message message = consumerManager.receiveMessage(this.messageConsumer);
//        String body = ((TextMessage) message).getText();
//        System.out.println("in CHANNEL CLASS , Received = "+body);
//    }
//
//
//
//    public MessageProducer getMessageProducer() {
//        return messageProducer;
//    }
//
//    public void setMessageProducer(MessageProducer messageProducer) {
//        this.messageProducer = messageProducer;
//    }
//
//    public MessageConsumer getMessageConsumer() {
//        return messageConsumer;
//    }
//
//    public void setMessageConsumer(MessageConsumer messageConsumer) {
//        this.messageConsumer = messageConsumer;
//    }
//
//    public Message getMessage() {
//        return message;
//    }
//
//    public void setMessage(Message message) {
//        this.message = message;
//    }
//
//    public Set<String> getQueueNames() {
//        return queueNames;
//    }
//
//    public void setQueueNames(Set<String> queueNames) {
//        this.queueNames = queueNames;
//    }
//}
