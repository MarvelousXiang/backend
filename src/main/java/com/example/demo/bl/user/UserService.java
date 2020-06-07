package com.example.demo.bl.user;

import com.example.demo.po.User;
import com.example.demo.vo.ResponseVO;

public interface UserService {
    ResponseVO addUser(User user);

    ResponseVO getAllUsers();

    ResponseVO deleteUserByEmail(String email);
}
