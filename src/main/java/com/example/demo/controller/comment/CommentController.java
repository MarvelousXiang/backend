package com.example.demo.controller.comment;

import com.example.demo.bl.comment.CommentService;
import com.example.demo.vo.CommentVO;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public ResponseVO addComment(@RequestBody CommentVO commentVO){
        return commentService.addComment(commentVO);
    }
    @PostMapping("/deleteOneCommentById")
    public ResponseVO deleteOneCommentById(@RequestParam Integer id){
        return commentService.deleteOneCommentById(id);
    }
    @PostMapping("/deleteCommentByUserIdAndDishId")
    public ResponseVO deleteCommentByUserIdAndDishId(@RequestParam Integer userId,@RequestParam Integer dishId){
        return commentService.deleteCommentByUserIdAndDishId(userId,dishId);
    }
    @PostMapping("/deleteAllCommentOfUser")
    public ResponseVO deleteAllCommentOfUser(@RequestParam Integer userId){
        return commentService.deleteAllCommentOfUser(userId);
    }
    @PostMapping("/deleteAllCommentOfDish")
    public ResponseVO deleteAllCommentOfDish(@RequestParam Integer dishId){
        return commentService.deleteAllCommentOfDish(dishId);
    }
    @GetMapping("/getAllCommentOfUser")
    public ResponseVO getAllCommentOfUser(@RequestParam Integer userId){
        return commentService.getAllCommentOfUser(userId);
    }
    @GetMapping("/getAllCommentOfDish")
    public ResponseVO getAllCommentOfDish(@RequestParam Integer dishId){
        return commentService.getAllCommentOfDish(dishId);
    }
    @GetMapping("/getCommentByUserIdAndDishId")
    public ResponseVO getCommentByUserIdAndDishId(@RequestParam Integer userId,@RequestParam Integer dishId){
        return commentService.getCommentByUserIdAndDishId(userId, dishId);
    }
}
