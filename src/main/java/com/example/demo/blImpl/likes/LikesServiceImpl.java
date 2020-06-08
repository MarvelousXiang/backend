package com.example.demo.blImpl.likes;

import com.example.demo.bl.likes.LikesService;
import com.example.demo.data.dish.DishDao;
import com.example.demo.data.likes.LikesDao;
import com.example.demo.po.Likes;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    private LikesDao likesDao;
    @Autowired
    private DishDao dishDao;

    @Override
    public ResponseVO addLike(Integer userId, Integer dishId) {
        if(likesDao.getLikesByUserIdAndDishId(userId,dishId).size()>0){
            return ResponseVO.buildFailure("不可重复添加收藏");
        }
        int r = dishDao.increaseDishLikesNum(dishId);
        if(r==0){
            return ResponseVO.buildFailure("菜品不存在,添加收藏失败");
        }
        likesDao.save(new Likes(userId,dishId));
        return ResponseVO.buildSuccess("添加成功");
    }

    @Override
    public ResponseVO deleteLike(Integer userId, Integer dishId) {
        if(likesDao.getLikesByUserIdAndDishId(userId,dishId).size()==0){
            return ResponseVO.buildFailure("该用户未将该菜品添加至收藏,无法删除");
        }
        int r=dishDao.decreaseDishLikesNum(dishId);
        if(r==0){
            return ResponseVO.buildFailure("菜品不存在");
        }
        likesDao.deleteLike(userId,dishId);
        return ResponseVO.buildSuccess("取消收藏成功");
    }
}
