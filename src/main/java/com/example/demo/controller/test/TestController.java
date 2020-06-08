package com.example.demo.controller.test;

import com.example.demo.bl.dish.DishService;
import com.example.demo.blImpl.mail.MailServiceImpl;
import com.example.demo.enums.DishCategory;
import com.example.demo.enums.DishTaste;
import com.example.demo.util.MyStringUtil;
import com.example.demo.util.UploadUtil;
import com.example.demo.vo.DishVO;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.util.Objects;

@Controller
public class TestController {
    @Autowired
    private MailServiceImpl mailService;
    @Autowired
    private DishService dishService;

    @GetMapping("/mailTest")
    public String mainTest(){
        return "mailTest";
    }
    @PostMapping("/mailTest")
    public String mainTest(@RequestParam String mail, HttpServletRequest httpServletRequest){
        String mailCode= MyStringUtil.getRandomString(6);
        httpServletRequest.getSession().setAttribute("mailCode",mailCode);
        mailService.sendMail(mail,"邮箱验证码","您的邮箱验证码为:"+mailCode);
        return "mailTest2";
    }
    @PostMapping("/mailTest2")
    @ResponseBody
    public ResponseVO mailTest2(@RequestParam String mailCode,HttpServletRequest httpServletRequest){
        try{
            if(String.valueOf(httpServletRequest.getSession().getAttribute("mailCode")).equals(mailCode)){
                return ResponseVO.buildSuccess("邮箱验证码正确");
            }
        }catch (Exception ignored){

        }
        return ResponseVO.buildFailure("邮箱验证码错误");
    }

    @GetMapping("/captchaTest")
    public String captchaTest(){
        return "captchaTest";
    }
    @PostMapping("/captchaTest")
    @ResponseBody
    public ResponseVO captchaTest(@RequestParam String captchaCode,HttpServletRequest httpServletRequest){
        try {
            if((String.valueOf(httpServletRequest.getSession().getAttribute("captchaCode"))).toLowerCase().equals(captchaCode.toLowerCase())){
                return ResponseVO.buildSuccess("图形验证码正确");
            }
        }catch (Exception ignored){

        }
        return ResponseVO.buildFailure("图形验证码不正确");
    }

    @GetMapping("/uploadTest")
    public String uploadTest(){
        return "uploadTest";
    }
    @PostMapping("/uploadTest")
    @ResponseBody
    public ResponseVO uploadTest(@RequestParam MultipartFile file){
        try {
            if(!file.isEmpty()){
                String fileType= Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[file.getOriginalFilename().split("\\.").length-1];
                FileInputStream inputStream=(FileInputStream)file.getInputStream();
                String path=UploadUtil.uploadFile(inputStream,MyStringUtil.getRandomString(10)+"."+fileType);
                System.out.println(path);
                return ResponseVO.buildSuccess("文件已成功上传至云盘,链接为:"+path);
            }
        }catch (Exception ignored){

        }
        return ResponseVO.buildFailure("文件上传失败,请再试一次");
    }

    @GetMapping("/tempTest")
    @ResponseBody
    public String test(){
        DishVO dishVO=new DishVO();
        dishVO.setName("ads");
        dishVO.setDishTaste(DishTaste.valueOf("la"));
        dishVO.setDishCategory(DishCategory.Shucai);
        dishVO.setPrice(23.21);
        dishService.addDish(dishVO);
        return "ss";
    }
}
