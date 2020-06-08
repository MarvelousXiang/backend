package com.example.demo.bl.dish;

import com.example.demo.enums.DishCategory;
import com.example.demo.enums.DishTaste;
import com.example.demo.vo.DishVO;
import com.example.demo.vo.ResponseVO;

public interface DishService {
    ResponseVO getAllDishes();

    ResponseVO getDishById(Integer id);

    ResponseVO getDishByName(String name);

    ResponseVO addDish(DishVO dishVO);

    ResponseVO getDishByCategory(DishCategory dishCategory);

    ResponseVO getDishByTaste(DishTaste dishTaste);

    ResponseVO deleteDish(Integer id);
}
