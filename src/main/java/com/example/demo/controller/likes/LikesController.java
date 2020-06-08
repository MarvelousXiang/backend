package com.example.demo.controller.likes;

import com.example.demo.bl.likes.LikesService;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikesController {
    @Autowired
    private LikesService likesService;

    @PostMapping("/addLike")
    public ResponseVO addLike(@RequestParam Integer userId, @RequestParam Integer dishId){
        return likesService.addLike(userId,dishId);
    }

    @PostMapping("/deleteLike")
    public ResponseVO deleteLike(@RequestParam Integer userId,@RequestParam Integer dishId){
        return likesService.deleteLike(userId,dishId);
    }

    @GetMapping("/getAllLikeDishesOfUser")
    public ResponseVO getAllLikeDishesOfUser(@RequestParam Integer userId){
        //TODO
        //ResponseVO的content类型为List<Dish>
        return null;
    }

    @GetMapping("/getAllLikeUsersOfDish")
    public ResponseVO getAllLikeUsersOfDish(@RequestParam Integer dishId){
        //TODO
        //ResponseVO的content类型为List<User>
        return null;
    }
}
