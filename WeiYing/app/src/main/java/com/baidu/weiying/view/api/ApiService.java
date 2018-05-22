package com.baidu.weiying.view.api;


import io.reactivex.Flowable;

import com.baidu.weiying.view.bean.HomePageSuperClass;
import com.baidu.weiying.view.bean.VideoLBean;

import retrofit2.http.POST;

/**
 * 实现类
 */

public interface ApiService {



    //获取总数据
    @POST("front/homePageApi/homePage.do")
    Flowable<HomePageSuperClass> getData();

    //获取列表视频数据
    @POST
    Flowable<VideoLBean> getVideo();
}
