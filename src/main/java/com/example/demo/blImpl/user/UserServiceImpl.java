package com.example.demo.blImpl.user;

import com.example.demo.bl.user.UserService;
import com.example.demo.data.comment.CommentDao;
import com.example.demo.data.likes.LikesDao;
import com.example.demo.data.user.UserDao;
import com.example.demo.enums.UserType;
import com.example.demo.po.User;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private LikesDao likesDao;
    @Override
    public ResponseVO addUser(User user) {
        try{
            user.setCreateDate((new SimpleDateFormat("yyyy-MM-dd")).format(new Date(System.currentTimeMillis())));
            userDao.save(user);
        }catch (Exception e){
            return ResponseVO.buildFailure("用户名或邮箱已存在");
        }
        return ResponseVO.buildSuccess("注册成功");
    }

    @Override
    public ResponseVO getAllUsers() {
        return ResponseVO.buildSuccess(userDao.findAll());
    }

    @Override
    public ResponseVO deleteUser(String userName,String email) {
        if(!"".equals(userName)&&!"".equals(email)){
            return ResponseVO.buildFailure("未知异常,删除失败");
        }
        try {
            User tempUser = userDao.getUserByUserNameOrEmail(userName, email).get(0);
            userDao.deleteUser(userName,email);
            commentDao.deleteByUserId(tempUser.getId());
            likesDao.deleteByUserId(tempUser.getId());
            return ResponseVO.buildSuccess("用户删除成功");
        }catch (Exception e){
            return ResponseVO.buildFailure("用户不存在,删除失败");
        }
    }

    @Override
    public ResponseVO updatePassword(String email, String oldPassword, String newPassword) {
        int r = userDao.updatePassword(email, oldPassword, newPassword);
        if(r==1){
            return ResponseVO.buildSuccess("密码修改成功");
        }
        return ResponseVO.buildFailure("密码修改失败");
    }

    @Override
    public ResponseVO getAllUserByUserType(UserType userType) {
        try {
            return ResponseVO.buildSuccess(userDao.getAllUserByUserType(userType));
        }catch (Exception e){
            return ResponseVO.buildFailure("用户类型不存在");
        }
    }
}
