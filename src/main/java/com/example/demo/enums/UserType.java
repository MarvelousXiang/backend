package com.example.demo.enums;

public enum UserType {
    Client("1"),
    Manager("2");
    private String value;
    UserType(String value){
        this.value=value;
    }
    @Override
    public String toString(){
        return value;
    }
}
