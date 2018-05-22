package com.baidu.weiying.view.api;

<<<<<<< HEAD
import com.baidu.weiying.view.bean.Faxianclass;

import io.reactivex.Flowable;
=======
import com.baidu.weiying.view.bean.HomePageSuperClass;
import com.baidu.weiying.view.bean.VideoLBean;

import io.reactivex.Flowable;
import retrofit2.http.FormUrlEncoded;
>>>>>>> 35a0099fe6c09995a1f4c1eddd49a17c57f6cb72
import retrofit2.http.POST;

/**
 * 实现类
 */

public interface ApiService {
    @POST("front/homePageApi/homePage.do")
    Flowable<Faxianclass>  getMssgea();

    //获取总数据
    @POST("front/homePageApi/homePage.do")
    Flowable<HomePageSuperClass> getData();

    //获取列表视频数据
    @POST
    Flowable<VideoLBean> getVideo();
}
