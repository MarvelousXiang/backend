package com.example.demo.blImpl.dish;

import com.example.demo.bl.dish.DishService;
import com.example.demo.data.dish.DishDao;
import com.example.demo.po.Dish;
import com.example.demo.vo.DishVO;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishDao dishDao;
    @Override
    public ResponseVO getAllDishes() {
        return ResponseVO.buildSuccess(dishDao.findAll());
    }

    @Override
    public ResponseVO getDishById(Integer id) {
        return ResponseVO.buildSuccess(dishDao.getDishById(id).get(0));
    }

    @Override
    public ResponseVO getDishByName(String name) {
        return ResponseVO.buildSuccess(dishDao.getDishByName(name));
    }

    @Override
    public ResponseVO addDish(DishVO dishVO) {
        Dish dish=new Dish();
        dish.setName(dishVO.getName());
        dish.setDishCategory(dishVO.getDishCategory());
        dish.setDishTaste(dishVO.getDishTaste());
        dish.setPrice(dishVO.getPrice());
        dish.setCreateDate((new SimpleDateFormat("yyyy-MM-dd")).format(new Date(System.currentTimeMillis())));
        dishDao.save(dish);
        return ResponseVO.buildSuccess("菜品添加成功");
    }
}
