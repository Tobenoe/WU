package com.baidu.weiying.presenter;

import com.baidu.weiying.modle.BannerListener;
import com.baidu.weiying.modle.TotalModle;
import com.baidu.weiying.view.activity.IChoicenessView;
import com.baidu.weiying.view.bean.HomePageSuperClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 杜晓彤 on 2018/5/21.
 */

public class ChoicenessPresenter implements IChoicenessPresenter {

    TotalModle totalModle=new TotalModle(this);
    IChoicenessView iChoicenessView;

    public ChoicenessPresenter(IChoicenessView iChoicenessView) {
        this.iChoicenessView = iChoicenessView;
    }

    //获得banner的数据的方法
    @Override
    public void showBanner(String url) {
        totalModle.getBanner(url, new BannerListener() {
            @Override
            public void bannerSuccess(HomePageSuperClass homePageSuperClass) {
                iChoicenessView.onbannersuccess(homePageSuperClass);
            }

            @Override
            public void bannerFail(Exception e) {

                iChoicenessView.onbannerfailed(e);
            }
        });


    }

    @Override
    public void showToView(TotalModle totalModle, IChoicenessView iChoicenessView) {

        this.iChoicenessView=iChoicenessView;
        //创建Map集合
        Map<String,String> map=new HashMap<>();
        totalModle.getList(map);
    }

    //获取首页列表的方法
    @Override
    public void getDataLists(List<HomePageSuperClass.RetBean.ListBean.ChildListBean> list) {

        iChoicenessView.showListData(list);
    }
}
