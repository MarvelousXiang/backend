package com.example.demo.data.comment;

import com.example.demo.po.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Integer> {
    @Query("delete from Comment c where c.userId=:userId and c.dishId=:dishId")
    @Modifying
    @Transactional
    int deleteByUserIdAndDishId(@Param("userId") Integer userId,@Param("dishId") Integer dishId);

    @Query("delete from Comment c where c.userId=:userId")
    @Modifying
    @Transactional
    int deleteByUserId(@Param("userId") Integer userId);

    @Query("delete from Comment c where c.dishId=:dishId")
    @Modifying
    @Transactional
    int deleteByDishId(@Param("dishId") Integer dishId);

    @Query("select c from Comment c where c.userId=:userId")
    List<Comment> findAllByUserId(@Param("userId") Integer userId);

    @Query("select c from Comment c where c.dishId=:dishId")
    List<Comment> findAllByDishId(@Param("dishId") Integer dishId);

    @Query("select c from Comment c where c.userId=:userId and c.dishId=:dishId")
    List<Comment> findAllByUserIdAndDishId(@Param("userId") Integer userId,@Param("dishId") Integer dishId);
}
