package com.example.demo.po;

import com.example.demo.vo.RegisterVO;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(unique = true,nullable = false)
    private String userName;
    @Column(unique = true,nullable = false)
    private String email;
    @Column
    private String password;
    @Column
    private String createDate;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }
    public User(String userName,String email,String password){
        this.userName=userName;
        this.email=email;
        this.password=password;
    }
    public User(RegisterVO registerVO){
        this.userName=registerVO.getUserName();
        this.email=registerVO.getEmail();
        this.password=registerVO.getPassword();
    }
}
