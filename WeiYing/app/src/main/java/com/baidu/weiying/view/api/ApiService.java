package com.baidu.weiying.view.api;

import com.baidu.weiying.view.bean.Faxianclass;

import io.reactivex.Flowable;
import retrofit2.http.POST;

/**
 * 实现类
 */

public interface ApiService {
    @POST("front/homePageApi/homePage.do")
    Flowable<Faxianclass>  getMssgea();

}
