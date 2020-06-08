package com.example.demo.controller.likes;

import com.example.demo.bl.likes.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/likes")
public class LikesController {
    @Autowired
    private LikesService likesService;
}
