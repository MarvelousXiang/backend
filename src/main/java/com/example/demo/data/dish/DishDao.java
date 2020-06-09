package com.example.demo.data.dish;

import com.example.demo.enums.DishCategory;
import com.example.demo.enums.DishTaste;
import com.example.demo.po.Dish;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DishDao extends JpaRepository<Dish,Integer> {
    @Query("select d from Dish d where d.id=:id")
    List<Dish> getDishById(@Param("id") Integer id);

    @Query("select d from Dish d where d.name=:name")
    List<Dish> getDishByName(@Param("name") String name);

    @Query("select d from Dish d where d.dishCategory=:dishCategory")
    List<Dish> getDishByCategory(@Param("dishCategory") DishCategory dishCategory);

    @Query("select d from Dish d where d.dishTaste=:dishTaste")
    List<Dish> getDishByTaste(@Param("dishTaste")DishTaste dishTaste);

    @Query("delete from Dish where id=:id")
    @Modifying
    @Transactional
    int deleteDish(@Param("id") Integer id);

    @Query("update Dish d set d.numOfLikes=d.numOfLikes+1 where d.id=:id")
    @Modifying
    @Transactional
    int increaseDishLikesNum(@Param("id") Integer id);

    @Query("update Dish d set d.numOfLikes=d.numOfLikes-1 where d.id=:id")
    @Modifying
    @Transactional
    int decreaseDishLikesNum(@Param("id") Integer id);

    @Query("select d from Dish d order by d.numOfLikes desc ")
    List<Dish> getAllDishesSortByNumOfLikes();

    @Query("select d from Dish d where d.dishTaste=:dishTaste order by d.numOfLikes desc")
    List<Dish> getAllDishesOfTasteSortByNumOfLikes(@Param("dishTaste") DishTaste dishTaste);

    @Query("select d from Dish d where d.dishCategory=:dishCategory order by d.numOfLikes desc")
    List<Dish> getAllDishesOfCategorySortByNumOfLikes(@Param("dishCategory") DishCategory dishCategory);

    @Query("select d from Dish d where d.dishCategory=:dishCategory and d.dishTaste=:dishTaste order by d.numOfLikes desc")
    List<Dish> getAllDishesOfCategoryAndTasteSortByNumOfLikes(@Param("dishCategory") DishCategory dishCategory,@Param("dishTaste") DishTaste dishTaste);
}
