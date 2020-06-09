package com.example.demo.vo;

import com.example.demo.enums.DishCategory;
import com.example.demo.enums.DishTaste;

public class DishVO {
    private String name;
    private String dishCategory;
    private String dishTaste;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(String dishCategory) {
        this.dishCategory = dishCategory;
    }

    public String getDishTaste() {
        return dishTaste;
    }

    public void setDishTaste(String dishTaste) {
        this.dishTaste = dishTaste;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
