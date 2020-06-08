package com.example.demo.controller.dish;

import com.example.demo.bl.dish.DishService;
import com.example.demo.enums.DishCategory;
import com.example.demo.enums.DishTaste;
import com.example.demo.vo.DishVO;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dish")
public class DishController {
    @Autowired
    private DishService dishService;
    @GetMapping("/getAllDishes")
    public ResponseVO getAllDishes(){
        return dishService.getAllDishes();
    }
    @GetMapping("/getDishById")
    public ResponseVO getDishById(@RequestParam Integer id){
        return dishService.getDishById(id);
    }
    @GetMapping("/getDishByName")
    public ResponseVO getDishByName(@RequestParam String name){
        return dishService.getDishByName(name);
    }
    @GetMapping("/getDishByCategory")
    public ResponseVO getDishByCategory(@RequestParam String category){
        return dishService.getDishByCategory(DishCategory.valueOf(category));
    }
    @GetMapping("/getDishByTaste")
    public ResponseVO getDishByTaste(@RequestParam String taste){
        return dishService.getDishByTaste(DishTaste.valueOf(taste));
    }
    @PostMapping("/addDish")
    public ResponseVO addDish(@RequestBody DishVO dishVO){
        return dishService.addDish(dishVO);
    }
    @PostMapping("/deleteDish")
    public ResponseVO deleteDish(@RequestParam Integer dishId){
        return dishService.deleteDish(dishId);
    }
}
