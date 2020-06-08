package com.example.demo.data.dish;

import com.example.demo.po.Dish;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishDao extends JpaRepository<Dish,Integer> {
    @Query("select d from Dish d where d.id=:id")
    List<Dish> getDishById(@Param("id") Integer id);

    @Query("select d from Dish d where d.name=:name")
    List<Dish> getDishByName(@Param("name") String name);
}
