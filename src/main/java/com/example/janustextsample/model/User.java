package com.example.janustextsample.model;

public class User {
    private Long id;
    private String name;
    private TextRoom textRoom;

    public User() {
    }

    public User(Long id, String name, TextRoom textRoom) {
        this.id = id;
        this.name = name;
        this.textRoom = textRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TextRoom getTextRoom() {
        return textRoom;
    }

    public void setTextRoom(TextRoom textRoom) {
        this.textRoom = textRoom;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
