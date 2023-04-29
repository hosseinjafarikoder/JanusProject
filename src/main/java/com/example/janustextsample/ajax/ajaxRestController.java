package com.example.janustextsample.ajax;

//import com.example.janustextsample.model.Channel;
import com.example.janustextsample.model.TextRoom;
import com.example.janustextsample.model.User;
import com.example.janustextsample.util.ConsumerManager;
import com.example.janustextsample.util.ProducerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;
import javax.validation.Valid;
import java.util.Set;

@RestController
public class ajaxRestController {

    private static final Logger logger = LoggerFactory.getLogger(ajaxRestController.class);
    public static TextRoom textRoom = TextRoom.getInstance();

    //create user object with ajax request from janus media server
    //with calling fire_ajax_submit2() method in textroomtest.js in line 267
    @PostMapping("/ajax/createUser")
    public void createUserObj(@Valid @RequestBody UserDto userDto, Errors errors){

        User user = new User();
        user.setName(userDto.getUsername());
        user.setTextRoom(textRoom);
        textRoom.getUsers().add(user);
        logger.info("user create successfully "+user+" textRoom Id : "+user.getTextRoom().getId());
        logger.info("textRoom details : "+textRoom);
    }


    //receive message with ajax
    //with calling send_msg_ajax() method in textroom.js in line 345
    @PostMapping("/ajax/msg")
    public ResponseEntity<?> msgAjaxLog(@Valid @RequestBody MessageDto sentMsg, Errors errors) throws Exception {
//        ProducerManager producerManager = ProducerManager.getInstance();
//        MessageProducer producer = producerManager.createProducer("MyNewQueue");
//        producerManager.sendMessage(producer,sentMsg.getDatasend());

        ProducerManager.getInstance().sendMessage(sentMsg.getDatasend());

//        ConsumerManager consumerManager = ConsumerManager.getInstance();
//        MessageConsumer consumer = consumerManager.createConsumer("MyNewQueue");
//        Message receivedMessage = consumerManager.receiveMessage(consumer);

        Message receivedMessage = ConsumerManager.getInstance().receiveMessage();
        System.out.println("main result : "+((TextMessage) receivedMessage).getText());

//        Channel channel = new Channel();
//        String queueName = "FirstQueue";
//        Set<String> queueNames = channel.getQueueNames();
//        for (String elm : queueNames){
//            if (elm.equals(queueName)){
//                throw new Exception("queue name is duplicate ");
//            }
//        }
//        channel.makeChannel("FirstQueue");

//        System.out.println("in msgAjaxLog method : sended message is : "+sentMsg.getDatasend());
        ajaxResponse ajaxResponse = new ajaxResponse();
        return null;
    }
}
