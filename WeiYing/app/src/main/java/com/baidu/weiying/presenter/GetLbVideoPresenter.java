package com.baidu.weiying.presenter;

import com.baidu.weiying.modle.TotalModle;
import com.baidu.weiying.view.fragments.Iview.GetLbViewInterface;

/**
 * Created by work on 2018/5/21.
 */

public class GetLbVideoPresenter implements GetLbVideointerface {

    private TotalModle totalModle;
    private GetLbViewInterface getLbViewInterface;

    public GetLbVideoPresenter(GetLbViewInterface getLbViewInterface) {
        this.getLbViewInterface = getLbViewInterface;
        this.totalModle = new TotalModle();
    }

    public void getVideo(String url) {

        totalModle.getVideo(url,this);


    }


    @Override
    public void OnSuccess(Object o) {

        getLbViewInterface.OnSuccess(o);
    }

    @Override
    public void Faild(String msg) {

        getLbViewInterface.Faild(msg);
    }

    @Override
    public void OnDestry() {
        if (getLbViewInterface != null) {

            getLbViewInterface = null;
        }


    }
}
