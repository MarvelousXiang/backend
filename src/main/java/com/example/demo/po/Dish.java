package com.example.demo.po;

import com.example.demo.enums.DishCategory;
import com.example.demo.enums.DishTaste;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private DishCategory dishCategory;
    @Column
    private DishTaste dishTaste;
    @Column
    private double price;
    @Column
    private String createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
