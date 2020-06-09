package com.example.demo.controller.user;

import com.example.demo.bl.user.UserService;
import com.example.demo.enums.UserType;
import com.example.demo.po.User;
import com.example.demo.vo.RegisterVO;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseVO getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/deleteUser")
    public ResponseVO deleteUser(@RequestParam(defaultValue = "",required = false) String userName,@RequestParam(defaultValue = "",required = false) String email){
        return userService.deleteUser(userName,email);
    }

    @PostMapping("/register")
    public ResponseVO register(@RequestBody RegisterVO registerVO){
        return userService.addUser(new User(registerVO));
    }

    @PostMapping("/updatePassword")
    public ResponseVO updatePassword(@RequestParam String email,@RequestParam String oldPassword,@RequestParam String newPassword){
        return userService.updatePassword(email, oldPassword, newPassword);
    }

    @GetMapping("/getAllUsersOfType")
    public ResponseVO getAllUsersOfType(@RequestParam String userType){
        return userService.getAllUserByUserType(UserType.valueOf(userType));
    }
}
