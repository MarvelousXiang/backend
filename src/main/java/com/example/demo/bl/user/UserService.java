package com.example.demo.bl.user;

import com.example.demo.enums.UserType;
import com.example.demo.po.User;
import com.example.demo.vo.ResponseVO;

public interface UserService {
    ResponseVO addUser(User user);

    ResponseVO getAllUsers();

    ResponseVO deleteUser(String userName,String email);

    ResponseVO updatePassword(String email,String oldPassword,String newPassword);

    ResponseVO getAllUserByUserType(UserType userType);
}
