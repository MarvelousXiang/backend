package com.example.demo.controller.test;

import com.example.demo.bl.user.UserService;
import com.example.demo.blImpl.mail.MailService;
import com.example.demo.po.User;
import com.example.demo.util.CaptchaUtil;
import com.example.demo.util.MyStringUtil;
import com.example.demo.util.UploadUtil;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@Controller
public class TestController {
    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;
    @GetMapping("/mailTest")
    @ResponseBody
    public ResponseVO mailTest(){
        mailService.sendMail("609607764@qq.com","验证码","您的验证码为:"+ MyStringUtil.getRandomString(10));
        return ResponseVO.buildSuccess("test success");
    }
//    @GetMapping("/captchaTest")
//    @ResponseBody
//    public void captchaTest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
//        CaptchaUtil vc = new CaptchaUtil();
//        BufferedImage image = vc.getImage();
//        String text = vc.getText();
//        HttpSession httpSession = httpServletRequest.getSession();
//        httpSession.setAttribute("captchaCode", text);
//        CaptchaUtil.output(image, httpServletResponse.getOutputStream());
//        System.out.println(text);
//    }
    @GetMapping("/uploadTest")
    public String uploadTest(){
        return "uploadTest";
    }
    @PostMapping("/uploadTest")
    @ResponseBody
    public ResponseVO uploadTest(@RequestParam("file") MultipartFile file,@RequestParam("captcha") String captcha,HttpServletRequest httpServletRequest){
        if(!(captcha.toLowerCase()).equals(String.valueOf(httpServletRequest.getSession().getAttribute("captchaCode")).toLowerCase())){
            return ResponseVO.buildFailure("验证码错误");
        }
        try{
            if(!file.isEmpty()){
                String fileType= Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[file.getOriginalFilename().split("\\.").length-1];
                FileInputStream inputStream=(FileInputStream)file.getInputStream();
                String path= UploadUtil.uploadImage(inputStream,MyStringUtil.getRandomString(10)+"."+fileType);
                System.out.println(path);
                return ResponseVO.buildSuccess("上传成功,文件路径为"+path);
            }
        }catch (Exception ignored){

        }
        return ResponseVO.buildFailure("上传失败,请再试一次");
    }

    @GetMapping("/userTest")
    public String userTest(){
        return "userTest";
    }
    @PostMapping("/userTest")
    @ResponseBody
    public ResponseVO userTest(@RequestParam String email,@RequestParam String password){
        return userService.addUser(new User(email,password));
    }

    @GetMapping("/getAllUsers")
    @ResponseBody
    public ResponseVO getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/deleteUserByEmail")
    @ResponseBody
    public ResponseVO deleteUserByEmail(@RequestParam String email){
        return userService.deleteUserByEmail(email);
    }
    @GetMapping("/test")
    public String test(){
        return "testPage";
    }


}
