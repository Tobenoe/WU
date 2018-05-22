package com.baidu.weiying.presenter;

import com.baidu.weiying.modle.TotalModle;
import com.baidu.weiying.view.fragments.Iview.VideoPLVinterface;

/**
 * Created by work on 2018/5/22.
 */

public class VideoPLPresenter implements VideoPLPinterface {

    private TotalModle totalModle;
    private VideoPLVinterface videoPLVinterface;

    public VideoPLPresenter(VideoPLVinterface videoPLVinterface) {
        this.videoPLVinterface = videoPLVinterface;
        this.totalModle = new TotalModle();
    }

    public void getPL(String id) {

        totalModle.getPl(id,this);

    }

    @Override
    public void OnSuccess(Object o) {
        videoPLVinterface.OnSuccess(o);
    }

    @Override
    public void Faild(String msg) {

        videoPLVinterface.Faild(msg);
    }

    @Override
    public void OnDestry() {
        if (videoPLVinterface != null) {

            videoPLVinterface = null;
        }


    }
}
