package com.example.demo.util;

import java.util.Random;
import java.util.Scanner;

public class MyStringUtil {

    public static String getRandomString(int length){
        String base="abcdefghijklmnopqrstuvwxyz0123456789";
        Random random =new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            int number=random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}