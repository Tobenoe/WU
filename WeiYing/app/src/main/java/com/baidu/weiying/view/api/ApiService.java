package com.baidu.weiying.view.api;

import com.baidu.weiying.view.bean.HomePageSuperClass;
import com.baidu.weiying.view.bean.PL_bean;
import com.baidu.weiying.view.bean.VideoLBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

    @FormUrlEncoded
    @POST("front/Commentary/getCommentList.do")
    Flowable<PL_bean> getPL(@Field("mediaId") String id);
}
