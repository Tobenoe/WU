package com.baidu.weiying.modle;

import com.baidu.weiying.presenter.GetLbVideointerface;
import com.baidu.weiying.presenter.IDiscoverPresenter;
import com.baidu.weiying.presenter.VideoPLPinterface;

import java.util.Map;

/**
 * Modle层接口
 */

public interface ITotalModle {
    //主要数据
    void getData(IDiscoverPresenter discoverPresenter);
    void getVideo(String url,GetLbVideointerface getLbVideointerface);
    void getPl(String id,VideoPLPinterface videoPLPinterface);


    //请求数据的方法
    void getBanner(String url, BannerListener bannerListener);

    //首页列表请求数据方法
    void getList(Map<String,String> map);
}
