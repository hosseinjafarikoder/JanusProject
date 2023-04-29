package com.example.janustextsample.model;

import com.example.janustextsample.controller.StartChatController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TextRoom {
    private static final Logger logger = LoggerFactory.getLogger(TextRoom.class);

    private static TextRoom instance;
    private Long id=1234L;
    private String plugin= "textroom";
    private List<User> users = new ArrayList<>();

    public TextRoom() {
    }

    public TextRoom( List<User> users) {
        this.users = users;
    }

    public static TextRoom getInstance(){
        if (instance==null){
            instance = new TextRoom();
            logger.info("textRoom created successfully :"+ instance);
        }
        return instance;
    }

    public Long getId() {
        return id;
    }

    public String getPlugin() {
        return plugin;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "TextRoom{" +
                "id=" + id +
                ", plugin='" + plugin + '\'' +
                ", users=" + users +
                '}';
    }
}
