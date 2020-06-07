package com.example.demo.controller.captcha;

import com.example.demo.util.CaptchaUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/api/captcha")
public class CaptchaUtilController {
    @GetMapping("/getOneCaptcha")
    public void getOneCaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        CaptchaUtil vc = new CaptchaUtil();
        BufferedImage image = vc.getImage();
        String text = vc.getText();
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("captchaCode", text);
        CaptchaUtil.output(image, httpServletResponse.getOutputStream());
        System.out.println(text);
    }
}
