package com.example.demo.data.user;

import com.example.demo.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserDao extends JpaRepository<User,Integer> {
    @Query("delete from User where email=:email or userName=:userName")
    @Modifying
    @Transactional
    int deleteUser(@Param("userName") String userName,@Param("email") String email);

    @Query("update User set password=:newPassword where email=:email and password=:oldPassword")
    @Modifying
    @Transactional
    int updatePassword(@Param("email") String email,@Param("oldPassword") String oldPassword,@Param("newPassword") String newPassword);
}
