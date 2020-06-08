package com.example.demo.bl.dish;

import com.example.demo.vo.DishVO;
import com.example.demo.vo.ResponseVO;

public interface DishService {
    ResponseVO getAllDishes();

    ResponseVO getDishById(Integer id);

    ResponseVO getDishByName(String name);

    ResponseVO addDish(DishVO dishVO);
}
