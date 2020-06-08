package com.example.demo.blImpl.dish;

import com.example.demo.bl.dish.DishService;
import com.example.demo.data.dish.DishDao;
import com.example.demo.enums.DishCategory;
import com.example.demo.enums.DishTaste;
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
        dish.setNumOfLikes(0);
        dish.setCreateDate((new SimpleDateFormat("yyyy-MM-dd")).format(new Date(System.currentTimeMillis())));
        dishDao.save(dish);
        return ResponseVO.buildSuccess("菜品添加成功");
    }

    @Override
    public ResponseVO getDishByCategory(DishCategory dishCategory) {
        try {
            return ResponseVO.buildSuccess(dishDao.getDishByCategory(dishCategory));
        }catch (Exception e){
            return ResponseVO.buildFailure("菜品种类不存在");
        }
    }

    @Override
    public ResponseVO getDishByTaste(DishTaste dishTaste) {
        try {
            return ResponseVO.buildSuccess(dishDao.getDishByTaste(dishTaste));
        }catch (Exception e){
            return ResponseVO.buildFailure("菜品味道不存在");
        }
    }

    @Override
    public ResponseVO deleteDish(Integer id) {
        int r = dishDao.deleteDish(id);
        if(r==1){
            return ResponseVO.buildSuccess("菜品删除成功");
        }
        return ResponseVO.buildFailure("菜品删除失败");
    }
}
