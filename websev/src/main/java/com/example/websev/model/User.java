package com.example.websev.model;

public class User {
    private String id;
    private String name;
    private String surname;
    private Long age;
    private byte[] bytes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setImage(byte[] bytes) {
        this.bytes = bytes;
    }

}


