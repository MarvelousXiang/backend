package com.example.demo.data.user;

import com.example.demo.enums.UserType;
import com.example.demo.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    @Query("delete from User where email=:email or userName=:userName")
    @Modifying
    @Transactional
    int deleteUser(@Param("userName") String userName,@Param("email") String email);

    @Query("update User set password=:newPassword where email=:email and password=:oldPassword")
    @Modifying
    @Transactional
    int updatePassword(@Param("email") String email,@Param("oldPassword") String oldPassword,@Param("newPassword") String newPassword);

    @Query("select u from User u where u.userType=:userType")
    List<User> getAllUserByUserType(@Param("userType")UserType userType);

    @Query("select u from User u where u.id=:id")
    List<User> getUserById(@Param("id") Integer id);

    @Query("select u from User u where u.userName=:userName")
    List<User> getUserByUserName(@Param("userName") String userName);

    @Query("select u from User u where u.email=:email")
    List<User> getUserByEmail(@Param("email") String email);

    @Query("select u from User u where u.userName=:userName or u.email=:email")
    List<User> getUserByUserNameOrEmail(@Param("userName") String userName,@Param("email") String email);
}
