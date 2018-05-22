package com.baidu.weiying.view.utils;

/**
 * Created by zs on 2018/5/21.
 */



/**

 * Created by Fu.

 * QQ:908323236

 * 2017/11/9 17:21

 */



public class User {



    private int photoResId;    //图片的资源ID

    private String name;        //名字

    private String sign;        //个性签名





    public User(int photoResId, String name, String sign) {

        this.photoResId = photoResId;

        this.name = name;

        this.sign = sign;

    }



    public int getPhotoResId() {

        return photoResId;

    }



    public void setPhotoResId(int photoResId) {

        this.photoResId = photoResId;

    }



    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }



    public String getSign() {

        return sign;

    }



    public void setSign(String sign) {

        this.sign = sign;

    }

}
