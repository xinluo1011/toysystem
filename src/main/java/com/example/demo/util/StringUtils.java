package com.example.demo.util;

import java.util.Random;

//避免图片上传重名
public class StringUtils {
    //生成指定长度随机字符串方法
    public static String getRandomString(int length){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random =new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number =random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
