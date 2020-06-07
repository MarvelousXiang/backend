package com.example.demo.data.user;

import com.example.demo.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserDao extends JpaRepository<User,Integer> {
    @Query("delete from User where email=:email")
    @Modifying
    @Transactional
    int deleteUserByEmail(@Param("email") String email);
}
