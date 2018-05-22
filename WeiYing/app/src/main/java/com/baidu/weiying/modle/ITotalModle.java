package com.baidu.weiying.modle;

import com.baidu.weiying.presenter.GetLbVideointerface;
import com.baidu.weiying.presenter.IDiscoverPresenter;

/**
 * Modle层接口
 */

public interface ITotalModle {
    //主要数据
    void getData(IDiscoverPresenter discoverPresenter);
    void getVideo(String url,GetLbVideointerface getLbVideointerface);
}
