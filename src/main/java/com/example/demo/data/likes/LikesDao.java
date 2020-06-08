package com.example.demo.data.likes;

import com.example.demo.po.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesDao extends JpaRepository<Likes,Integer> {
}
