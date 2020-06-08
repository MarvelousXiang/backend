package com.example.demo.vo;

import com.example.demo.enums.DishCategory;
import com.example.demo.enums.DishTaste;

public class DishVO {
    private String name;
    private DishCategory dishCategory;
    private DishTaste dishTaste;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DishCategory getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(DishCategory dishCategory) {
        this.dishCategory = dishCategory;
    }

    public DishTaste getDishTaste() {
        return dishTaste;
    }

    public void setDishTaste(DishTaste dishTaste) {
        this.dishTaste = dishTaste;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
