package com.example.demo.data.likes;

import com.example.demo.po.Likes;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LikesDao extends JpaRepository<Likes,Integer> {
    @Query("select l from Likes l where l.userId=:userId and l.dishId=:dishId")
    List<Likes> getLikesByUserIdAndDishId(@Param("userId") Integer userId,@Param("dishId") Integer dishId);

    @Query("delete from Likes l where l.userId=:userId and l.dishId=:dishId")
    @Modifying
    @Transactional
    int deleteLike(@Param("userId") Integer userId,@Param("dishId") Integer dishId);

    @Query("select l from Likes l where l.userId=:userId")
    List<Likes> getAllLikesOfUser(@Param("userId") Integer userId);

    @Query("select l from Likes l where l.dishId=:dishId")
    List<Likes> getAllLikesOfDish(@Param("dishId") Integer dishId);

    @Query("delete from Likes l where l.dishId=:dishId")
    @Modifying
    @Transactional
    int deleteByDishId(@Param("dishId") Integer dishId);

    @Query("delete from Likes l where l.userId=:userId")
    @Modifying
    @Transactional
    int deleteByUserId(@Param("userId") Integer userId);
}
