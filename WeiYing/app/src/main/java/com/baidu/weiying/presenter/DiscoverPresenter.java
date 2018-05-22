package com.baidu.weiying.presenter;

import com.baidu.weiying.modle.TotalModle;
import com.baidu.weiying.view.fragments.Iview.IDiscoverView;

/**
 * 发现类Presenter层
 */

public class DiscoverPresenter implements IDiscoverPresenter {

    private TotalModle totalModle;
    private IDiscoverView discoverView;

    public DiscoverPresenter(IDiscoverView discoverView) {

        this.discoverView = discoverView;
        this.totalModle = new TotalModle();
    }


    public void getData() {

        totalModle.getData(this);

    }


    @Override
    public void OnSuccess(Object o) {

        discoverView.OnSuccess(o);

    }

    @Override
    public void Faild(String msg) {

        discoverView.Faild(msg);
    }

    @Override
    public void OnDestry() {

        if(discoverView != null){
            discoverView = null;

        }
    }
}
