package com.example.demo.controller.user;

import com.example.demo.bl.user.UserService;
import com.example.demo.blImpl.mail.MailService;
import com.example.demo.util.MyStringUtil;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @PostMapping("/sendRegisterMailCode")
    public ResponseVO sendRegisterMailCode(@RequestParam String email, HttpServletRequest httpServletRequest){
        try {
            String mailCode = MyStringUtil.getRandomString(6);
            httpServletRequest.getSession().setAttribute("mailCode", mailCode);
            mailService.sendMail(email, "注册验证码", "您的注册验证码为:" + mailCode);
        }catch (Exception e){
            return ResponseVO.buildFailure("验证码发送失败,请重试");
        }
        return ResponseVO.buildSuccess("验证码发送成功");
    }
    @GetMapping("/getAllUsers")
    public ResponseVO getAllUsers(){
        return userService.getAllUsers();
    }
}
