package com.example.demo.blImpl.comment;

import com.example.demo.bl.comment.CommentService;
import com.example.demo.data.comment.CommentDao;
import com.example.demo.po.Comment;
import com.example.demo.vo.CommentVO;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public ResponseVO addComment(CommentVO commentVO) {
        Comment comment=new Comment();
        comment.setUserId(commentVO.getUserId());
        comment.setDishId(commentVO.getDishId());
        comment.setContent(commentVO.getContent());
        comment.setCreateDate((new SimpleDateFormat("yyyy-MM-dd")).format(new Date(System.currentTimeMillis())));
        commentDao.save(comment);
        return ResponseVO.buildSuccess("评论添加成功");
    }

    @Override
    public ResponseVO deleteOneCommentById(Integer id) {
        try{
            commentDao.deleteById(id);
        }catch (Exception e){
            return ResponseVO.buildFailure("评论不存在,删除失败");
        }
        return ResponseVO.buildSuccess("评论删除成功");
    }

    @Override
    public ResponseVO deleteCommentByUserIdAndDishId(Integer userId, Integer dishId) {
        int r = commentDao.deleteByUserIdAndDishId(userId, dishId);
        if(r==0){
            return ResponseVO.buildFailure("评论不存在,删除失败");
        }
        return ResponseVO.buildSuccess("评论删除成功");
    }

    @Override
    public ResponseVO deleteAllCommentOfUser(Integer userId) {
        int r = commentDao.deleteByUserId(userId);
        if(r==0){
            return ResponseVO.buildFailure("评论不存在,删除失败");
        }
        return ResponseVO.buildSuccess("评论删除成功");
    }

    @Override
    public ResponseVO deleteAllCommentOfDish(Integer dishId) {
        int r = commentDao.deleteByDishId(dishId);
        if(r==0){
            return ResponseVO.buildFailure("评论不存在,删除失败");
        }
        return ResponseVO.buildSuccess("评论删除成功");
    }

    @Override
    public ResponseVO getAllCommentOfUser(Integer userId) {
        return ResponseVO.buildSuccess(commentDao.findAllByUserId(userId));
    }

    @Override
    public ResponseVO getAllCommentOfDish(Integer dishId) {
        return ResponseVO.buildSuccess(commentDao.deleteByDishId(dishId));
    }

    @Override
    public ResponseVO getCommentByUserIdAndDishId(Integer userId, Integer dishId) {
        return ResponseVO.buildSuccess(commentDao.findAllByUserIdAndDishId(userId, dishId));
    }
}
