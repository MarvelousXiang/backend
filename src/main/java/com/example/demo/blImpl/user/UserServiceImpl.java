package com.example.demo.blImpl.user;

import com.example.demo.bl.user.UserService;
import com.example.demo.data.user.UserDao;
import com.example.demo.po.User;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public ResponseVO addUser(User user) {
        try{
            userDao.save(user);
        }catch (Exception e){
            return ResponseVO.buildFailure("用户邮箱已存在");
        }
        return ResponseVO.buildSuccess("注册成功");
    }

    @Override
    public ResponseVO getAllUsers() {
        return ResponseVO.buildSuccess(userDao.findAll());
    }

    @Override
    public ResponseVO deleteUserByEmail(String email) {
        int r = userDao.deleteUserByEmail(email);
        if(r==1){
            return ResponseVO.buildSuccess("用户删除成功");
        }
        return ResponseVO.buildFailure("用户不存在,删除失败");
    }
}
