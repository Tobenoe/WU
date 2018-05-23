package com.baidu.weiying.modle;

import com.baidu.weiying.view.bean.HomePageSuperClass;

/**
 *Banner的监听接口
 */

public interface BannerListener {

    void bannerSuccess(HomePageSuperClass homePageSuperClass);

    void bannerFail(Exception e);
}
