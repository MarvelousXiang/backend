package com.example.demo.bl.dish;

import com.example.demo.enums.DishCategory;
import com.example.demo.enums.DishTaste;
import com.example.demo.vo.DishVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DishServiceTest {
    @Autowired
    private DishService dishService;
    @Test
    public void test1(){
        DishVO dishVO=new DishVO();
        dishVO.setName("dish1");
        dishVO.setPrice(1.2);
        dishVO.setDishCategory(DishCategory.Shucai);
        dishVO.setDishTaste(DishTaste.la);
        dishService.addDish(dishVO);
    }

}