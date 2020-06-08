package com.example.demo.bl.likes;

import com.example.demo.vo.ResponseVO;

public interface LikesService {
    ResponseVO addLike(Integer userId,Integer dishId);

    ResponseVO deleteLike(Integer userId,Integer dishId);
}
