package com.example.demo.bl.comment;

import com.example.demo.vo.CommentVO;
import com.example.demo.vo.ResponseVO;

public interface CommentService {
    ResponseVO addComment(CommentVO commentVO);

    ResponseVO deleteOneCommentById(Integer id);

    ResponseVO deleteCommentByUserIdAndDishId(Integer userId,Integer dishId);

    ResponseVO deleteAllCommentOfUser(Integer userId);

    ResponseVO deleteAllCommentOfDish(Integer dishId);

    ResponseVO getAllCommentOfUser(Integer userId);

    ResponseVO getAllCommentOfDish(Integer dishId);

    ResponseVO getCommentByUserIdAndDishId(Integer userId,Integer dishId);
}
