package com.example.demo.enums;

public enum DishTaste {
    tian("1"),
    xian("2"),
    suan("3"),
    la("4");
    private String value;
    DishTaste(String value){
        this.value=value;
    }
    @Override
    public String toString(){
        return value;
    }
}
