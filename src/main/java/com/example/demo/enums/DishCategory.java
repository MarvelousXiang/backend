package com.example.demo.enums;

public enum DishCategory {
    Qinlei("1"),
    Shucai("2");

    private String value;
    DishCategory(String value){
        this.value=value;
    }
    @Override
    public String toString(){
        return value;
    }
}
